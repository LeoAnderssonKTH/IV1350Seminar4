
package se.kth.iv1350.amazingpos.view;

/*
 * This class informs the user of exceptions and errors.
 */
public class ErrorMessageHandler {
    
    public void showErrorMessage(String message){
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append(message);
        System.out.println(errorMessage);
    }
    
}
