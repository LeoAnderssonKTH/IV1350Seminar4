
package se.kth.iv1350.amazingpos.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.amazingpos.integration.AccountingHandler;
import se.kth.iv1350.amazingpos.integration.DiscountHandler;
import se.kth.iv1350.amazingpos.integration.InventoryHandler;
import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.model.CashRegister;
import se.kth.iv1350.amazingpos.model.DTO.ItemDTO;
import se.kth.iv1350.amazingpos.model.DTO.SaleDTO;
import se.kth.iv1350.amazingpos.model.DTO.ScanItemDTO;
import se.kth.iv1350.amazingpos.model.Receipt;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.integration.InventoryConnectionErrorException;
import se.kth.iv1350.amazingpos.model.SaleObserver;
import se.kth.iv1350.amazingpos.util.ExceptionLogHandler;


/*
 * This class functions as the controller that the view will use to access other
 * layers through systemcalls via the controller.
 */
public class Controller {
    private Sale sale;
    private CashRegister cashregister;
    private InventoryHandler inventoryhandler;
    private DiscountHandler discounthandler;
    private Printer printer;
    private Receipt receipt;
    private AccountingHandler accountinghandler;
    private ExceptionLogHandler controllerExLogger = ExceptionLogHandler.getLogger();
    private List <SaleObserver> saleObservers = new ArrayList<>();
    
    
    public Controller(){
        /*
         * The constructor also creates other classes so that when the controller is created
         * during startup the controller also creates the classes it is supposed to send system calls
         *  to in other layers.
         */
        cashregister = new CashRegister();
        inventoryhandler = new InventoryHandler();
        discounthandler = new DiscountHandler();
        printer = new Printer();
        accountinghandler = new AccountingHandler();
        
    }
    
    public void addSaleObserver(SaleObserver observer){
        saleObservers.add(observer);
    }

    /*
    * Starts a new sale.
    * This Method must be called to initialize a new sale and add/scan items to
    * the sale and also sets the observers to the new sale.
    */
    public void startSale(){
        sale = new Sale();
        sale.addSaleObserver(saleObservers.get(0));
        sale.addSaleObserver(saleObservers.get(1));
    }
    
    /*
    * This method sends the itemID forward to Sale and also gets the itemDTO from
    * the InventoryHandler which it then passes on to Sale.
    * @param itemID is the article number or identifier of the item you want to
    * the current sale.
    * @return gives an ScanItemDTO to the view for the item description, price
    * and running total that the view then presents to the user.
    * @throws ItemIDNotFoundException when the item information retrived from
    * the inventoryhandler results in a DTO containing no information other than
    */
    public ScanItemDTO scanItem(int itemID) throws ItemIDNotFoundException, ConnectionErrorException{
        try {ItemDTO itemDTO = inventoryhandler.getItemInfo(itemID);
        if(itemDTO.name == null | itemDTO.VAT == 0 | itemDTO.totalCost == 0){
            throw new ItemIDNotFoundException(itemDTO);
        }
        
        SaleDTO saleInfo = sale.registerItem(itemID, itemDTO);
        ScanItemDTO viewInfo = new ScanItemDTO(saleInfo, itemDTO);
        return viewInfo;
        } catch (InventoryConnectionErrorException connectionError) {
            controllerExLogger.logException(connectionError);
            throw new ConnectionErrorException();
        }
        
    }
    
    /*
    * This method as of now only prints out the total price of the sale since
    * further clarification is needed what "ending the sale" implies.
    * @return gives the final price of the sale
    */
    public int endSale(){
       int finalPrice = sale.getTotalPrice();
       
       return finalPrice;
        
    }
    
    /*
    * This method is used to enter the paid amount and also make sure that all
    * calls to lower layers are done and retrives a SaleDTO to be passed on 
    * to other layers/classes containing sale information.
    * Printing the amount of change to the screen, saving the sale information in
    * the SaleLog adn so on.
    * Further information by each called method will be given in their specific
    * class/method code.
    *
    * @param amount is the amount of the received payment.
    */
    public void pay(int amount){
       SaleDTO saleDTO =  sale.controlPaidAmount(amount);
       receipt = new Receipt(saleDTO);
       printer.printReceipt(receipt);
       accountinghandler.sendUpdate(saleDTO);
       inventoryhandler.sendUpdate(saleDTO);
       cashregister.updateBalanceAndSaveInfo(amount, saleDTO);
       
    }

}
