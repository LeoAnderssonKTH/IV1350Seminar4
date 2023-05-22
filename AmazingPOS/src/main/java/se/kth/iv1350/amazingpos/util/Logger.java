
package se.kth.iv1350.amazingpos.util;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The purpose of this class is to give all other classes a logger that they can
 * use if they require to log something.
 * 
 */
public class Logger {
    PrintWriter logger;
    
    public Logger(String fileName){
          try {
            logger = new PrintWriter(new FileWriter(fileName), true);
        } catch (IOException ioe) {
            System.out.println("Can´t create log" + fileName);
            ioe.printStackTrace();
        }
    }
    
    public void log(String whatYouAreLoging,int somethingToLog){
        logger.println(whatYouAreLoging + ": " + somethingToLog);
        
    }
    
}
