package se.kth.iv1350.amazingpos.model;

import java.time.LocalDate;
import java.time.LocalTime;
import se.kth.iv1350.amazingpos.model.DTO.ItemDTO;
import se.kth.iv1350.amazingpos.model.DTO.SaleDTO;

/**
 * This class is used to generate all information required on the receipt and
 * make sure that the printer is able to print the information that is store.
 * Note that the attributes of the Receipt class are for the time being a 
 * place holder and might change if the printer require more specified 
 * information to provide a receipit.
 */
public class Receipt {
    public LocalTime timeOfSale;
    public LocalDate dateOfSale;
    public ItemDTO[] itemList;
    public int totalPrice;
    public int totalVAT;
    public int paidAmount;
    public int change;
    
    public Receipt(SaleDTO saleDTO){
      
        this.timeOfSale = saleDTO.timeOfSale;
        this.dateOfSale = saleDTO.dateOfSale;
        this.itemList = saleDTO.itemList;
        this.totalPrice = saleDTO.totalPrice;
        this.totalVAT = saleDTO.totalVAT;
        this.paidAmount = saleDTO.paidAmount;
        this.change = saleDTO.change;
    }
    
}
