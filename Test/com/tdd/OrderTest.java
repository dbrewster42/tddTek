package com.tdd;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderTest {
    Order order = new Order();

//    @Test
//    public void test(){
//        fail("Not yet implemented");
//    }

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
    public void validateOrderPrice(){
        order.addItem("book", true, 12.49);
        order.addItem("music CD", false, 14.99);
        order.addItem("chocolate bar", true, .85);
        double price = order.getPreTaxTotal();
        assertEquals(price, 28.33, .01);
    }


}
