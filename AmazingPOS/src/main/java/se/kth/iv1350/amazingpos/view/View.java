
package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.controller.ItemIDNotFoundException;
import se.kth.iv1350.amazingpos.model.DTO.ScanItemDTO;
import se.kth.iv1350.amazingpos.util.ExceptionLogHandler;
import se.kth.iv1350.amazingpos.controller.ConnectionErrorException;


/*
 * This is not a finnished class but is used to show how the "real view" will be
 * implemented in the future and how it will do system calls via the controller.
 */
public class View {
    private Controller contr;
    private ScanItemDTO viewInfo;
    private ErrorMessageHandler errorMessageHandler;
    private ExceptionLogHandler viewExLogger = ExceptionLogHandler.getLogger();
    
    /**
     * Creates a new instance and adds observers to the controller.
     * @param contr the controller that the view will communicate with other layers through.
     * @param errorMessageHandler the errorMessageHandler that is in charge of 
     * notifying the user when something goes wrong.
     */
    public View(Controller contr, ErrorMessageHandler errorMessageHandler ){
        this.contr = contr;
        contr.addSaleObserver(new TotalRevenueView());
        contr.addSaleObserver(new TotalRevenueFileOutput());
        this.errorMessageHandler = errorMessageHandler;
        
    }
    
    /*
    * This function is used to simulate all calls done to the controller.
    * @throws ItemIDNotFoundException is thrown when the given itemID does not match
    * match any itemID of the items stored in the inventory system.
    */
    public void systemCallSimulation(){
        System.out.println("Sale 1");
        contr.startSale();
        System.out.println("A new sale has been started.");
       
        try {
            viewInfo = contr.scanItem(3);
            System.out.println("Item: " + viewInfo.itemDTO.name + ", Price: " + viewInfo.itemDTO.totalCost);
            System.out.println("Running Total is: " + viewInfo.runningTotal);
        
        } catch (ItemIDNotFoundException invalidID){
            errorMessageHandler.showErrorMessage("The itemID you have entered is invalid ");
            viewExLogger.logException(invalidID);
            } catch (ConnectionErrorException conError){
                errorMessageHandler.showErrorMessage("Connecting to the inventory was not possible.");
            }
        
        try {
            viewInfo = contr.scanItem(1);
            System.out.println("Item: " + viewInfo.itemDTO.name + ", Price: " + viewInfo.itemDTO.totalCost);
            System.out.println("Running Total is: " + viewInfo.runningTotal);
        
        } catch (ItemIDNotFoundException invalidID){
            errorMessageHandler.showErrorMessage("The itemID you have entered is invalid");
            viewExLogger.logException(invalidID);
            } catch (ConnectionErrorException conError){
                errorMessageHandler.showErrorMessage("Connecting to the inventory was not possible.");
            }
       
        try {
            viewInfo = contr.scanItem(2);
            System.out.println("Item: " + viewInfo.itemDTO.name + ", Price: " + viewInfo.itemDTO.totalCost);
            System.out.println("Running Total is: " + viewInfo.runningTotal);
        
        } catch(ItemIDNotFoundException invalidID){
            errorMessageHandler.showErrorMessage("The itemID you have entered is invalid");
            viewExLogger.logException(invalidID);
        }   catch (ConnectionErrorException conError){
                errorMessageHandler.showErrorMessage("Connecting to the inventory was not possible.");
            }
        
       try {
            viewInfo = contr.scanItem(2);
            System.out.println("Item: " + viewInfo.itemDTO.name + ", Price: " + viewInfo.itemDTO.totalCost);
            System.out.println("Running Total is: " + viewInfo.runningTotal);
        
        } catch(ItemIDNotFoundException invalidID){
            errorMessageHandler.showErrorMessage("The itemID you have entered is invalid");
            viewExLogger.logException(invalidID);
        } catch (ConnectionErrorException conError){
                errorMessageHandler.showErrorMessage("Connecting to the inventory was not possible.");
            }
       
       try {
            viewInfo = contr.scanItem(5);
            System.out.println("Item: " + viewInfo.itemDTO.name + ", Price: " + viewInfo.itemDTO.totalCost);
            System.out.println("Running Total is: " + viewInfo.runningTotal);
        
        } catch(ItemIDNotFoundException invalidID){
            errorMessageHandler.showErrorMessage("The itemID you have entered is invalid");
            viewExLogger.logException(invalidID);
        } catch (ConnectionErrorException conError){
                errorMessageHandler.showErrorMessage("Connecting to the inventory was not possible.");
            }
       
       try {
            viewInfo = contr.scanItem(6);
            System.out.println("Item: " + viewInfo.itemDTO.name + ", Price: " + viewInfo.itemDTO.totalCost);
            System.out.println("Running Total is: " + viewInfo.runningTotal);
        
        } catch(ItemIDNotFoundException invalidID){
            errorMessageHandler.showErrorMessage("The itemID you have entered is invalid");
            viewExLogger.logException(invalidID);
        } catch (ConnectionErrorException conError){
                errorMessageHandler.showErrorMessage("Connecting to the inventory was not possible.");
            }
       
        int finalPrice = contr.endSale();
        System.out.println("The Sale has ended.");
        System.out.println("The total price is: " + finalPrice);
        contr.pay(50);
        
        System.out.println("Sale 2");
        contr.startSale();
        System.out.println("A new sale has been started.");
      
       
        try {
            viewInfo = contr.scanItem(2);
            System.out.println("Item: " + viewInfo.itemDTO.name + ", Price: " + viewInfo.itemDTO.totalCost);
            System.out.println("Running Total is: " + viewInfo.runningTotal);
        
        } catch(ItemIDNotFoundException invalidID){
            errorMessageHandler.showErrorMessage("The itemID you have entered is invalid");
            viewExLogger.logException(invalidID);
        }   catch (ConnectionErrorException conError){
                errorMessageHandler.showErrorMessage("Connecting to the inventory was not possible.");
            }
        
       try {
            viewInfo = contr.scanItem(2);
            System.out.println("Item: " + viewInfo.itemDTO.name + ", Price: " + viewInfo.itemDTO.totalCost);
            System.out.println("Running Total is: " + viewInfo.runningTotal);
        
        } catch(ItemIDNotFoundException invalidID){
            errorMessageHandler.showErrorMessage("The itemID you have entered is invalid");
            viewExLogger.logException(invalidID);
        } catch (ConnectionErrorException conError){
                errorMessageHandler.showErrorMessage("Connecting to the inventory was not possible.");
            }
       
       
       
        int finalPrice2 = contr.endSale();
        System.out.println("The Sale has ended.");
        System.out.println("The total price is: " + finalPrice2);
        contr.pay(20);

    }
    
}
