
package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.model.DTO.SaleDTO;

/**
 * CashRegister is used to save all information that is useful for the 
 * CashRegister.
 */
public class CashRegister {
    private int balance;
    private SaleLog salelog;
    
    
    /*
     * Creates new instance.
     * Constructoralso creates SaleLog during startup.
     */
    public CashRegister(){
        salelog  = new SaleLog();
    }
    
    public void updateBalanceAndSaveInfo(int amount, SaleDTO saveInfo){
        balance += amount;
    }
    
}
