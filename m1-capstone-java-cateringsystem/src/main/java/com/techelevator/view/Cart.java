package com.techelevator.view;

import com.techelevator.CateringSystem;
import com.techelevator.items.CateringItem;

import java.io.FileNotFoundException;
import java.util.TreeMap;

public class Cart {

    private int totalQty = 0;
    private double totalPrice = 0.0;
    private TreeMap<String, CateringItem> cartMap = new TreeMap<String, CateringItem>();

    CateringSystem cateringSystem = new CateringSystem();

    public Cart() throws FileNotFoundException {
    }


    public double determineTotalPrice(double itemPrice) {
        totalPrice += itemPrice;
        return totalPrice;
    }

    public int determineTotalQty (double itemQty) {
        totalQty += itemQty;
        return totalQty;
    }



    public int getTotalQty() {
        return totalQty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
