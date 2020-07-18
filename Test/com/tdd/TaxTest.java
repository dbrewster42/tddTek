package com.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxTest {

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
    public void validateSalesTaxRoundsToNearest5(){
        double result = Tax.addSalesTax(13.33);
        assertEquals(result, 1.35, .01);
    }

    @Test
    public void validateImportTaxRoundstoNearest5(){
        double result = Tax.addImportTax(13.66);
        assertEquals(result, .70, .01);
    }

}
