package se.kth.iv1350.amazingpos.model;

import java.time.LocalTime;
import java.time.LocalDate;
import se.kth.iv1350.amazingpos.model.DTO.ItemDTO;
import se.kth.iv1350.amazingpos.model.DTO.SaleDTO;
import java.util.ArrayList;
import java.util.List;


/**
 * The Sale Class keep track of all items that are added to the sale and stores 
 * all information that is required by other classes regarding the sale.
 */
public class Sale {
    private LocalTime timeOfSale;
    private LocalDate dateOfSale;
    Item[] itemList = new Item[1];
    int totalPrice;
    int totalVAT;
    private int paidAmount;
    private int change;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /*
     * Creates new instance and saves the current local time.
     */
    public Sale(){
        timeOfSale = LocalTime.now();
        dateOfSale = LocalDate.now();
        
    }
    
    private void informObservers(SaleDTO saleinfo){
        for (SaleObserver observer: saleObservers)
            observer.newTotalRevenue(saleinfo);  
    }
    
    public void addSaleObserver(SaleObserver observer){
        saleObservers.add(observer);
    }
    
    private void updatePrice(){
        int newPrice = 0;
        int newVAT= 0;
        for(int i = 0; i < this.itemList.length; i++){
            newPrice += this.itemList[i].totalCost*this.itemList[i].quantity;
            newVAT += this.itemList[i].VAT*this.itemList[i].quantity;
        }
        
        this.totalPrice = newPrice;
        this.totalVAT = newVAT;
    }
    
    private void addItem(Item item){
        if(null == this.itemList[0]){
            this.itemList[0] = item;
            return;
        }
        
        Item newItemList[] = new Item[this.itemList.length + 1];
        for(int i = 0; i < this.itemList.length; i++){
            newItemList[i] = this.itemList[i];
        }
        
        newItemList[this.itemList.length] = item;
        this.itemList = newItemList;
    }
    
    /*
    * This method checks if the itemID already exists in the current itemList
    * that is registered on the sale.
    * If the itemID is not located in the current itemList a new Item will be created
    * and added to the itemList.
    * If the itemID can be found the quantity of that item will be increased by 1.
    * Note that the total price of the sale is update via a private method in 
    * both cases.
    * @return saleDTO returns SaleDTO back to the caller so that it can be
    * forwarded to other layers that require information of the sale.
    */
    public SaleDTO registerItem(int itemID, ItemDTO itemDTO) {

        int i = 0;
        while(i < this.itemList.length && this.itemList[i] != null){
            if(itemID == this.itemList[i].itemID){
                this.itemList[i].quantity++;
                this.updatePrice();
                SaleDTO saleDTO = this.makeSaleDTO();
                return saleDTO;
            }
            i++;
        }
        
        Item newItem = new Item(itemDTO);
        this.addItem(newItem);
        
        this.updatePrice();
        
        SaleDTO saleDTO = this.makeSaleDTO();
        return saleDTO;
        
        
    }
    
    /*
    * Informs that the sale has ended and prints the total price of the sale
    * to the system.
    * @return finalPrice returns the final price back to the caller.
    */
    public int getTotalPrice(){
        int finalPrice = this.totalPrice;
        return finalPrice;
    }
    
    /*
    * Controls the paid amount that has been entered and returns a SaleDTO
    * back to the controller.
    * @return saleDTO returns SaleDTO back to the caller so that it can be
    * forwarded to other layers that require information of the sale.
    */
    public SaleDTO controlPaidAmount(int amount){
        this.paidAmount = amount;
        this.change = amount - this.totalPrice;
        System.out.println("Change: " + this.change);
        SaleDTO saleDTO = makeSaleDTO();
        informObservers(saleDTO);
        return saleDTO;
    }
    
    private ItemDTO[] makeItemDTOList(){
        ItemDTO itemList[] = new ItemDTO[this.itemList.length];
         for(int i = 0; i < this.itemList.length; i++){
            itemList[i] = new ItemDTO(0);
        }
        for(int i = 0; i < this.itemList.length; i++){
            itemList[i].name = this.itemList[i].name;
            itemList[i].itemID = this.itemList[i].itemID;
            itemList[i].VAT = this.itemList[i].VAT;
            itemList[i].totalCost = this.itemList[i].totalCost;
            itemList[i].quantity = this.itemList[i].quantity;
        }
        return itemList;
    }
    private SaleDTO makeSaleDTO(){
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.timeOfSale = this.timeOfSale;
        saleDTO.dateOfSale = this.dateOfSale;
        saleDTO.totalPrice = this.totalPrice;
        saleDTO.totalVAT = this.totalVAT;
        saleDTO.paidAmount = this.paidAmount;
        saleDTO.change = this.change;
        saleDTO.itemList = this.makeItemDTOList();
        
        return saleDTO;
    }
}
