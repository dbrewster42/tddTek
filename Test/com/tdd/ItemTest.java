package com.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemTest {
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
}
