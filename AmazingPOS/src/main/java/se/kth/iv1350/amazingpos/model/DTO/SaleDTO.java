
package se.kth.iv1350.amazingpos.model.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import se.kth.iv1350.amazingpos.model.Item;
import se.kth.iv1350.amazingpos.model.Sale;

/*
* The purpose of this class/DTO is to gather all information and simplify the
* sending of necessary Sale information to other classes/layers.
*/
public class SaleDTO {
    public LocalTime timeOfSale;
    public LocalDate dateOfSale;
    public ItemDTO[] itemList;
    public int totalPrice;
    public int totalVAT;
    public int paidAmount;
    public int change;
    
    /*
    * This creates a new instance and gathers all the information from the sale
    * and copies that on to the SaleDTO.
    * Note that this constructor is only ment to be used on the Sale class
    * when it is required to send information about the Sale further to other
    * classes/layers.
    */
    public SaleDTO(){
        
    }
    
}
