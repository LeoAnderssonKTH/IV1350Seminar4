
package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.model.DTO.ItemDTO;

/**
 *The Item class represents the different items that are purchasable in the store
 * and contains all the necessary information of the items.
 */
public class Item {
   int totalCost;
   int VAT;
   int itemID = 0;
   int quantity;
   String name;
    
    /*
    * This is the constructor for the class Item that uses the itemDTO provided
    * by the InventoryHandler.
    */
    public Item(ItemDTO itemDTO){
        this.itemID = itemDTO.itemID;
        this.VAT = itemDTO.VAT;
        this.totalCost = itemDTO.totalCost;
        this.quantity = 1;
        this.name = itemDTO.name;
        
    }
    
}
