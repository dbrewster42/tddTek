package com.tdd;

public class Tax {
    public static double addSalesTax(double price) {
        double tax = price * 0.1;
//        System.out.println("Adding Sales Tax of 10 % " + tax);
        tax = Math.round(tax * 20.0) / 20.0;
        return tax;
    }

    public static double addImportTax(double price) {
        double tax = price * .05;
//        System.out.println("Adding Import Tax of 5 % " + price);
        tax = Math.round(tax * 20.0) / 20.0;
        return tax;
    }
}
