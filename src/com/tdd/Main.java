package com.tdd;

public class Main {
    ///books, food, medical products
    public static void main(String[] args) {
        Order order1 = new Order();
        order1.addItem("book", true, 12.49);
        order1.addItem("music CD", false, 14.99);
        order1.addItem("chocolate bar", true, .85);
        order1.print();

        Order order2 = new Order();
        order2.addItem("imported box of chocolates", true, 10.00);
        order2.addItem("imported bottle of perfume", false, 47.50);
        order2.print();

        Order order3 = new Order();
        order3.addItem("imported bottle of perfume", false, 27.99);
        order3.addItem("bottle of perfume", false, 18.99);
        order3.addItem("packet of headache pills", true, 9.75);
        order3.addItem("imported box of chocolates", true, 11.25);
        order3.print();


    }
}
