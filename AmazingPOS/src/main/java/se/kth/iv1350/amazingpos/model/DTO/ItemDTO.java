
package se.kth.iv1350.amazingpos.model.DTO;

/**
 * This class is used as a DTO for the class Item to help the class sale create
 * new items that need to be added to the current sale.
 */
public class ItemDTO {
    public int totalCost;
    public int VAT;
    public int itemID;
    public String name;
    public int quantity;
    
    /*
    * This method will be used to fetch all information required from the 
    * external inventory system that Sale needs to create new items.
    * Note that no information about the nature of the inventory system has been
    * given, so this is only a place holder for the future method while
    * basic functionality is being tested.
    */
    public ItemDTO (int itemID){
       this.itemID = itemID;
    }
    
}
