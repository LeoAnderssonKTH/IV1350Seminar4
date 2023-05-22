

package se.kth.iv1350.amazingpos.integration;
/*
* This exception is thrown when the program is not able to connect to the
* external inventory system.
*/

public class InventoryConnectionErrorException extends Exception {
    
    public InventoryConnectionErrorException(int itemID){
        super("Connecting to inventory was not possible when trying to scan itemID: " + itemID);
    }

}
