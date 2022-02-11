package com.techelevator.items;

import java.math.BigDecimal;

/*
    This represents a single catering item in the system
 */
public class CateringItem {

    private String type;
    private String productCode;
    private String description;
    private int quantity = 25;
    private double price;

    public CateringItem(String type, String productCode, String description) {
        this.productCode = productCode;
        this.description = description;
        this.type = type;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
