
package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.model.DTO.SaleDTO;
import se.kth.iv1350.amazingpos.model.SaleObserver;
import se.kth.iv1350.amazingpos.util.Logger;

/**
 * Logs the total revenue generated from the program was launched and is 
 * updated every time a sale has been paid.
 */
public class TotalRevenueFileOutput implements SaleObserver {
    int totalRevenue;
    Logger revenueLogger = new Logger("revenue.txt");
    
    @Override
    public void newTotalRevenue(SaleDTO saleInfo) {
        totalRevenue += saleInfo.totalPrice;
        revenueLogger.log("Total Revenue", totalRevenue);
          
    }
    
}
