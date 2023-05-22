
package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Receipt;

/**
 * This class is used to simulate the printer in the sale process.
 */
public class Printer {
    
    public void printReceipt(Receipt receipt){
        System.out.println("----------This is the receipt----------");
        System.out.println("Time Of Sale: " + receipt.timeOfSale + " Date: " + receipt.dateOfSale);
        
        for (int i = 0; i < receipt.itemList.length; i++){
            System.out.print("Item name: " + receipt.itemList[i].name + ", ");
            System.out.print("Quantity: " + receipt.itemList[i].quantity + ", ");
            System.out.println("Price: " + receipt.itemList[i].totalCost + " ");  
        }
        System.out.println("Total Price: " + receipt.totalPrice);
        System.out.println("Total VAT: " + receipt.totalVAT);
        System.out.println("Paid amount: " + receipt.paidAmount);
        System.out.println("Change: " + receipt.change);
        System.out.println("----------End of the receipt----------");
        
    }
    
}
