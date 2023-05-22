
package se.kth.iv1350.amazingpos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.amazingpos.model.DTO.ItemDTO;
import se.kth.iv1350.amazingpos.model.DTO.SaleDTO;
import se.kth.iv1350.amazingpos.model.DTO.ScanItemDTO;
import se.kth.iv1350.amazingpos.model.Sale;

/**
 *
 * @author Leo
 */
public class ControllerTest {
    private Sale sale;
    private SaleDTO saleDTO;
    private ItemDTO testItem1;
    private ItemDTO testItem2;
    private SaleDTO testScan;
    
    public ControllerTest() {
    }
    
  
    
    @BeforeEach
    public void setUp() {
        sale = new Sale();
        testItem1 = new ItemDTO(1);
        testItem2 = new ItemDTO(2);
        
        testItem1.VAT = 3;
        testItem1.name = "Kaka";
        testItem1.quantity = 1;
        testItem1.totalCost = 9;
        
        testItem2.VAT = 5;
        testItem2.name = "Mjölk";
        testItem2.quantity = 1;
        testItem2.totalCost = 25;
        
        testScan = sale.registerItem(1, testItem1);
        testScan = sale.registerItem(1, testItem1);
        testScan = sale.registerItem(1, testItem1);
        
        testScan = sale.registerItem(2, testItem2);
        testScan = sale.registerItem(2, testItem2);
    }
    
    @AfterEach
    public void tearDown() {
        sale = null;
        testItem1 = null;
        testItem2 = null;
    }

    

    @Test
    public void testPay() {
        setUp();
        saleDTO =  sale.controlPaidAmount(100);
        
        int expectedChange = 23;
        int actualChange = saleDTO.change;
        
        String expectedName1 = "Kaka";
        String actualName1 = saleDTO.itemList[0].name;
        int expectedVAT1 = 3;
        int actualVAT1 = saleDTO.itemList[0].VAT;
        int expectedQuantity1 = 3;
        int actualQuantity1 = saleDTO.itemList[0].quantity;
        int expectedTotalCost1 = 9;
        int actualTotalCost1 = saleDTO.itemList[0].totalCost;
        
        String expectedName2 = "Mjölk";
        String actualName2 = saleDTO.itemList[1].name;
        int expectedVAT2 = 5;
        int actualVAT2 = saleDTO.itemList[1].VAT;
        int expectedQuantity2 = 2;
        int actualQuantity2 = saleDTO.itemList[1].quantity;
        int expectedTotalCost2 = 25;
        int actualTotalCost2 = saleDTO.itemList[1].totalCost;
        
        int expectedTotalPriceOfSale = 77;
        int actualTotalPriceOfSale = saleDTO.totalPrice;
        int expectedTotalVAT = 19;
        int actualTotalVAT = saleDTO.totalVAT;
        
        assertEquals(expectedName1, actualName1, "The item name is not correct");
        assertEquals(expectedVAT1, actualVAT1, "The Item VAT is not correct");
        assertEquals(expectedQuantity1, actualQuantity1, "The registered quantity for the item is incorrect");
        assertEquals(expectedTotalCost1, actualTotalCost1, "The registered total cost is incorrect");
        
        assertEquals(expectedName2, actualName2, "The item name is not correct");
        assertEquals(expectedVAT2, actualVAT2, "The Item VAT is not correct");
        assertEquals(expectedQuantity2, actualQuantity2, "The registered quantity for the item is incorrect");
        assertEquals(expectedTotalCost2, actualTotalCost2, "The registered total cost is incorrect");
        
        assertEquals(expectedTotalPriceOfSale, expectedTotalPriceOfSale, "The total price of sale is wrong");
        assertEquals(expectedTotalVAT, actualTotalVAT, "The total VAT is wrong");
        assertEquals(expectedChange, actualChange, "The amount of change is not correct");
        
        tearDown();
    }
    
}
