
package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.DTO.ItemDTO;
import se.kth.iv1350.amazingpos.model.DTO.SaleDTO;
import se.kth.iv1350.amazingpos.controller.ItemIDNotFoundException;


/**
 * This class/handler exists to help the Sale classs to get information from the
 * inventory system about items.
 * Since no specific information regarding the inventory system has been given
 * this class will only be used as a place holder for the time being and will be 
 * changed in the future.
 */
public class InventoryHandler {
    
 
    public InventoryHandler(){
        
    }
    /*
    * This methods main objective is to get information from the external
    * inventory system and give it to the controller.
    * Note that in its current state it has only been used to test the 
    * functionality  of the other classes. 
    */
    public ItemDTO getItemInfo(int itemID)throws InventoryConnectionErrorException {
        
        ItemDTO itemDTO = new ItemDTO(itemID);
        
        if(1 == itemID){
            itemDTO.VAT = 4;
            itemDTO.name = "Potato";
            itemDTO.totalCost = 10;
        }
        
        if(2 == itemID){
            itemDTO.VAT = 2;
            itemDTO.name = "Tomato";
            itemDTO.totalCost = 6;
        }
        
        if(3 == itemID){
            itemDTO.VAT = 2;
            itemDTO.totalCost = 6;
            
        }
        
        if(4 == itemID){
            itemDTO.name = "Noodles";
            itemDTO.totalCost = 3;   
        }
        
        if(5 == itemID){
            itemDTO.VAT = 9;
            itemDTO.name = "Meatballs";
            
        }
        
        if(6 == itemID){
            throw new InventoryConnectionErrorException(itemID);
        }
       
        
        return itemDTO;
        
    }
    
    public void sendUpdate(SaleDTO saleDTO){
        
    }
    

}
