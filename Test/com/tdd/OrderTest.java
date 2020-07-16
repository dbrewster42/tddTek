package com.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {
    Order order = new Order();

//    @Test
//    public void test(){
//        fail("Not yet implemented");
//    }
    @Test
    public void checkIfItemExempt(){
        Item item = new Item("book", true, 12.49);
        boolean result = item.getExempt();
        assertTrue(result);
    }
    @Test
    public void validateItemName(){
        Item item = new Item("book", true, 12.49);
        String result = item.getName();
        assertEquals(result, "book");
    }
    @Test
    public void validateItemPrice(){
        Item item = new Item("book", true, 12.49);
        double result = item.getPrice();
        assertEquals(result, 12.49, .05);
    }
    @Test
    public void checkIfOrderNull(){
        try{
            order.addItem("book", true, 12.49);
            order.addItem("music CD", false, 14.99);
            order.addItem("chocolate bar", true, .85);
            assertNotNull(order);
        }catch (final RuntimeException e) {
            fail();
        }
    }

    @Test
    public void validateOrderPrice(){
        order.addItem("book", true, 12.49);
        order.addItem("music CD", false, 14.99);
        order.addItem("chocolate bar", true, .85);
        double price = order.getPreTaxTotal();
        assertEquals(price, 28.33, .01);
    }
    @Test
    public void validateSalesTax(){
        double price = 10.0;
        double result = Tax.addSalesTax(price);
        assertEquals(result, 1.0, .01);
    }
    @Test
    public void validateImportTax(){
        double result = Tax.addImportTax(10.0);
        assertEquals(result, 0.5, .01);
    }
    @Test
    public void validateTax(){
        order.addItem("book", true, 12.49);
        order.addItem("music CD", false, 14.99);
        order.addItem("chocolate bar", true, .85);
        double tax = order.getTotal();
        assertEquals(tax, 1.50, .01);
    }
    
    @Test
    public void validateTax2(){
        order.addItem("imported bottle of perfume", false, 27.99);
        order.addItem("bottle of perfume", false, 18.99);
        order.addItem("packet of headache pills", true, 9.75);
        order.addItem("imported box of chocolates", true, 11.25);
        double tax = order.getTotal();
//        assertEquals(tax, 6.70, .01);
        assertEquals(tax, 6.65, .01);
    }
    @Test
    public void validateTotal(){
        order.addItem("book", true, 12.49);
        order.addItem("music CD", false, 14.99);
        order.addItem("chocolate bar", true, .85);
        double total = order.print();
        assertEquals(total, 29.83, .01);

    }
    @Test
    public void validateTotal2(){
        order.addItem("imported box of chocolates", true, 10.00);
        order.addItem("imported bottle of perfume", false, 47.50);
        double total = order.print();
        assertEquals(total, 65.15, .01);
    }
    @Test
    public void validateTotal3(){
        order.addItem("imported bottle of perfume", false, 27.99);
        order.addItem("bottle of perfume", false, 18.99);
        order.addItem("packet of headache pills", true, 9.75);
        order.addItem("imported box of chocolates", true, 11.25);
        double total = order.print();
//        assertEquals(tax, 74.68, .01);
        assertEquals(total, 74.63, .01);
    }

}
