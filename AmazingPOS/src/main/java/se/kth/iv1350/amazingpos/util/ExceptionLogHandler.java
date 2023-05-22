package se.kth.iv1350.amazingpos.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

        

/**
 *  This class is used to log exceptions that occure when running the program.
 */
public class ExceptionLogHandler {
    private static final String LOG_FILE_NAME = "amazing-pos.txt";
    private static final ExceptionLogHandler INSTANCE = new ExceptionLogHandler();
    private PrintWriter logFile;
    
    
    /*
    * Returns an Instance of the ExceptionLogHandler
    */
    public static ExceptionLogHandler getLogger() {
        return INSTANCE;
    }

    private ExceptionLogHandler() {
        try {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME, true), true);
        } catch (IOException e) {
            System.out.println("Logger could not be created");
            e.printStackTrace();
        }
    }

    /**
     * Sends information about the exception to the log together with the time
     * when it occured.
     *
     * @param exception The exception to be logged.
     */
    public void logException(Exception exception) {
        StringBuilder logMsg = new StringBuilder();
        logMsg.append("Exception: ");
        logMsg.append(exception.getMessage());
        logMsg.append("\n" + "Time of exception " + LocalDateTime.now());
        logFile.println(logMsg);
        exception.printStackTrace(logFile);
        logFile.println("\n");
    }
}

