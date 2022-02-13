package com.techelevator.items;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class Appetizer extends CateringItem{

    private String appetizerMessage = "";

    public Appetizer(String type, String productCode, String description) throws FileNotFoundException {
        super(type, productCode, description);
    }

    public String getAppetizerMessage() {
        appetizerMessage = menu.appetizerMessage();
        return appetizerMessage;
    }

}
