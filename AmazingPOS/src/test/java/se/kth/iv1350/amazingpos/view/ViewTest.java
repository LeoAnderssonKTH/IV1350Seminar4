/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.amazingpos.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.amazingpos.controller.ConnectionErrorException;
import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.controller.ItemIDNotFoundException;
import se.kth.iv1350.amazingpos.model.DTO.ScanItemDTO;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.util.ExceptionLogHandler;

/**
 *
 * @author Leo
 */
public class ViewTest {
    private Controller contr;
    private ScanItemDTO viewInfo;
    private ErrorMessageHandler errorMessageHandler;
    private ExceptionLogHandler viewExLogger = ExceptionLogHandler.getLogger();
    
    public ViewTest() {
    }
    
    
    @BeforeEach
    public void setUp() {
        contr = new Controller();
        contr.startSale();
    }
    
    @AfterEach
    public void tearDown() {
        contr = null;
     
    }
    
    @Test
    public void testSystemCallSimulation() throws ItemIDNotFoundException, ConnectionErrorException{ 
        setUp();
        try {
            viewInfo = contr.scanItem(2);
        } catch (ItemIDNotFoundException | ConnectionErrorException testitemNotFoundException){
            
        }
        
        try {
            viewInfo = contr.scanItem(2);
        } catch (ItemIDNotFoundException | ConnectionErrorException testitemNotFoundException){
            
        }
        
        try {
            viewInfo = contr.scanItem(2);
        } catch (ItemIDNotFoundException | ConnectionErrorException testitemNotFoundException){
            
        }
        
        try {
            viewInfo = contr.scanItem(3);
               fail("Invalid item was added to the sale");
        } catch (ItemIDNotFoundException | ConnectionErrorException testitemNotFoundException){
            
        }
        
        try {
            viewInfo = contr.scanItem(1);
        } catch (ItemIDNotFoundException | ConnectionErrorException testitemNotFoundException){
            
        }
        
        try {
            viewInfo = contr.scanItem(1);
        } catch (ItemIDNotFoundException | ConnectionErrorException testitemNotFoundException){
            
        }
        
        try {
            viewInfo = contr.scanItem(5);
            fail("Invalid item was added to the sale");
        } catch (ItemIDNotFoundException | ConnectionErrorException testitemNotFoundException){
            
        }
        
        try {
            viewInfo = contr.scanItem(1);
        } catch (ItemIDNotFoundException | ConnectionErrorException testitemNotFoundException){
            
        }
        
        try {
            viewInfo = contr.scanItem(6);
            fail("Item was added when there was no connection to inventory");
        } catch (ItemIDNotFoundException | ConnectionErrorException testitemNotFoundException){
            
        }
        
        int expectedSaleLength = 2;
        int actualSaleLength = contr.sale.itemList.length;
        assertEquals(expectedSaleLength, actualSaleLength, "Invalid itemIDs have been added to the itemList");
        
        
        tearDown();
    }

    
}
