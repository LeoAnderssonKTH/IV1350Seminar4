
package se.kth.iv1350.amazingpos.startup;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.controller.ItemIDNotFoundException;
import se.kth.iv1350.amazingpos.view.ErrorMessageHandler;
import se.kth.iv1350.amazingpos.view.View;

/**
 *  The main method that is used to start the entire application
 */
public class Main {
    public static void main (String[] args) {
        Controller contr = new Controller();
        ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
        View view = new View(contr, errorMessageHandler);
        view.systemCallSimulation();
        
    }
    
}
