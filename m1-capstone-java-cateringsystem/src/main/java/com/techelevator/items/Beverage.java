package com.techelevator.items;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class Beverage extends CateringItem {


    public Beverage(String type, String productCode, String description) throws FileNotFoundException {
        super(type, productCode, description);
    }

    public void beverageMessage() {
       menu.beverageMessage();
    }

}
