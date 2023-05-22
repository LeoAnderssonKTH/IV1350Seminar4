/*
 * Purpose of this class is to be able to return the ItemInfo and runningtotal
 * to the View when the scanItem method is called upon from the view.
 */
package se.kth.iv1350.amazingpos.model.DTO;


public class ScanItemDTO {
    public int runningTotal;
    public ItemDTO itemDTO;
    
    
 /*
 * This is the constructor for the ScanItemDTO class.
 * @param saleInfo is an SaleDTO
 * @param itemInfo is an ItemDTO  
 */
    public ScanItemDTO(SaleDTO saleInfo, ItemDTO itemInfo){
        this.itemDTO = itemInfo;
        this.runningTotal = saleInfo.totalPrice;
    
}
    
}
