
package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.model.DTO.ItemDTO;

/*
 * Thrown when the itemID entered by user is not found in the InventorySystem.
 */
public class ItemIDNotFoundException extends Exception {
  
    
    public ItemIDNotFoundException(ItemDTO item){
        super("ItemID: " + item.itemID + " is invalid or the handler was not given full item information from inventory");
        }
    
}
