package com.techelevator;
import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.view.CashRegister;
import com.techelevator.view.Menu;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
    This class should encapsulate all the functionality of the Catering system, meaning it should
    contain all the "work"
 */
public class CateringSystem {


    private double currentAccountBalance = 0.00;
    private String selectedProduct = "";

    Menu menu = new Menu();
    CashRegister cashRegister = new CashRegister(0.00,0);

    public CateringSystem(double currentAccountBalance, String selectedProduct) {
        this.currentAccountBalance = currentAccountBalance;
        this.selectedProduct = selectedProduct;
    }


    public double addMoney(String moneyToAdd) {
        if (moneyToAdd.equalsIgnoreCase("1")
                || moneyToAdd.equalsIgnoreCase("5")
                || moneyToAdd.equalsIgnoreCase("10")
                || moneyToAdd.equalsIgnoreCase("20")
                || moneyToAdd.equalsIgnoreCase("50")
                || moneyToAdd.equalsIgnoreCase("100")) {
          double addedMoney = Double.parseDouble(menu.getUserAddedMoney());
            currentAccountBalance += addedMoney;
        } else {
            menu.displayIncorrectBillMessage();
        }
        return currentAccountBalance;
    }







    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    public String getSelectedProduct() {
        return selectedProduct;
    }
}
