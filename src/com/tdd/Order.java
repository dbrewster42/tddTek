package com.tdd;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private double totalPrice = 0;
    private double totalTax = 0;
    private List<Item> items;

    public Order(){
        items = new ArrayList<Item>();
    }

    public void addItem(String name, boolean exempt, double price) {
        Item item = new Item(name, exempt, price);
        items.add(item);
    }
    public List<Item> getItems(){
        return items;
    }
    public double getPreTaxTotal(){
        double price = 0;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price;
    }
    public double getTotalTax(){
        double totalTax = getTotal();
        return totalTax;
    }

    private double getTotal() {
        double totalTax = 0;
        for (Item item : items) {
            double salesTax = 0.0;
            double importTax = 0.0;
            if (!item.getExempt()) {
                salesTax = Tax.addSalesTax(item.getPrice());
            }
            if (item.getName().contains("imported")) {
                importTax = Tax.addImportTax(item.getPrice());

            }
//            System.out.println("Import tax:" + importTax + "Sales Tax: " + salesTax);
            double finalPrice = item.getPrice() + salesTax + importTax;
//            System.out.println(finalPrice);
            item.setPrice(finalPrice);
            totalTax += salesTax + importTax;

        }
        return totalTax;

    }

    public double TotalAndPrint() {
        double totalTax = getTotal();
        double totalPrice = 0;
        for (Item item : items) {
            System.out.println(String.format("1 " + item.getName() + ": %.2f", item.getPrice()));
            totalPrice += item.getPrice();
        }
        String result = String.format("Sales Taxes : %.2f Total: %.2f", totalTax, totalPrice);
        System.out.println(result);
        return totalPrice;
    }
}
