
package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.model.DTO.SaleDTO;
import se.kth.iv1350.amazingpos.model.SaleObserver;

/**
 * Shows the user the total revenue since the program was started
 * on every received payment.
 * 
 */
public class TotalRevenueView implements SaleObserver {
    int totalRevenue;

    /**
     * When notification is received from the observed class the total price from
     * the sale is added to the total revenue being observed.
     * @param saleInfo contains all sale information stored in the observed class.
     */
    @Override
    public void newTotalRevenue(SaleDTO saleInfo) {
       totalRevenue += saleInfo.totalPrice;
       System.out.println("The current total revenue is: " + totalRevenue);
    }
    
}
