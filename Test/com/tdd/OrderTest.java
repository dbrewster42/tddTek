package com.tdd;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderTest {
    Order order = new Order();

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
    public void validateOrderLength(){
        order.addItem("book", true, 12.49);
        order.addItem("music CD", false, 14.99);
        order.addItem("chocolate bar", true, .85);
        List<Item> checker = order.getItems();
        int size = checker.size();
        assertEquals(size, 3);
    }

    @Test
    public void validatePreTaxOrderPrice(){
        order.addItem("book", true, 12.49);
        order.addItem("music CD", false, 14.99);
        order.addItem("chocolate bar", true, .85);
        double price = order.getPreTaxTotal();
        assertEquals(price, 28.33, .01);
    }

    @Test
    public void validateOrderTax(){
        order.addItem("book", true, 12.49);
        order.addItem("music CD", false, 14.99);
        order.addItem("chocolate bar", true, .85);
        double tax = order.getTotalTax();
        assertEquals(tax, 1.50, .01);
    }

    @Test
    public void validateOrderTax2(){
        order.addItem("imported bottle of perfume", false, 27.99);
        order.addItem("bottle of perfume", false, 18.99);
        order.addItem("packet of headache pills", true, 9.75);
        order.addItem("imported box of chocolates", true, 11.25);
        double tax = order.getTotalTax();
        assertEquals(tax, 6.65, .01);
    }
    @Test
    public void validateOrderTotal(){
        order.addItem("book", true, 12.49);
        order.addItem("music CD", false, 14.99);
        order.addItem("chocolate bar", true, .85);
        double total = order.TotalAndPrint();
        assertEquals(total, 29.83, .01);
    }
    @Test
    public void validateOrderTotal2(){
        order.addItem("imported box of chocolates", true, 10.00);
        order.addItem("imported bottle of perfume", false, 47.50);
        double total = order.TotalAndPrint();
        assertEquals(total, 65.15, .01);
    }
    @Test
    public void validateOrderTotal3(){
        order.addItem("imported bottle of perfume", false, 27.99);
        order.addItem("bottle of perfume", false, 18.99);
        order.addItem("packet of headache pills", true, 9.75);
        order.addItem("imported box of chocolates", true, 11.25);
        double total = order.TotalAndPrint();
        assertEquals(total, 74.63, .01);
    }


}
