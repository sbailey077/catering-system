package com.techelevator.items;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class Dessert extends CateringItem {

    private String dessertMessage = "";

    public Dessert(String type, String productCode, String description) throws FileNotFoundException {
        super(type, productCode, description);
    }

    public String getDessertMessage() {
        dessertMessage = menu.dessertMessage();
        return dessertMessage;
    }


}


