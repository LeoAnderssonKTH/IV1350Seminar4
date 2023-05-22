
package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.model.DTO.SaleDTO;

/**
 * This interface is used for updating observers when a sale has been paid for.
 * 
 *
 */
public interface SaleObserver {
    /**
     * When a notification has been received this is implemented.
     * 
     */
    void newTotalRevenue(SaleDTO saleInfo);
}
