package com.techelevator;
import com.sun.source.tree.Tree;
import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
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
    InventoryFileReader inventoryFileReader = new InventoryFileReader("cateringsystem.csv");

    private TreeMap<String, CateringItem> inventory = inventoryFileReader.getInventory();

    public TreeMap<String, CateringItem> getInventory() {
        return inventory;
    }

    public void setInventory(TreeMap<String, CateringItem> inventory) {
        this.inventory = inventory;
    }

    public CateringSystem() throws FileNotFoundException {
    }


    public double addMoney(String moneyToAdd) {
        if (currentAccountBalance >= 1500.00) {
            menu.displayMoneyCap();
            return currentAccountBalance;
        } else if (moneyToAdd.equalsIgnoreCase("1")
                || moneyToAdd.equalsIgnoreCase("5")
                || moneyToAdd.equalsIgnoreCase("10")
                || moneyToAdd.equalsIgnoreCase("20")
                || moneyToAdd.equalsIgnoreCase("50")
                || moneyToAdd.equalsIgnoreCase("100")) {
          double addedMoney = Double.parseDouble(moneyToAdd);
            currentAccountBalance += addedMoney;
            return currentAccountBalance;
        } else {
            menu.displayIncorrectBillMessage();
        }
        return currentAccountBalance;
    }

    public String selectAnItem(String selectedProduct) {
        for (Map.Entry<String, CateringItem>  map: inventory.entrySet()) {
            if (selectedProduct.equalsIgnoreCase(map.getKey())) {
                String selectedProductDescription = map.getValue().getDescription().toString();
                menu.displaySelectedItem(selectedProductDescription);
                setSelectedProduct(selectedProduct);
                return selectedProductDescription;
            }
        }
        selectedProduct = "";
        return selectedProduct;
    }

    public double getItemPrice(String userEnteredQty) {
        int itemQty = Integer.parseInt(userEnteredQty);
        double totalItemPrice = 0.00;
        String selectedProduct = getSelectedProduct();
        int currentItemQty = inventory.get(selectedProduct).getQuantity();
        for(Map.Entry<String, CateringItem> map : inventory.entrySet()) {
             if(selectedProduct.equalsIgnoreCase(map.getKey())) {
                double itemPrice = map.getValue().getPrice();
                totalItemPrice = itemPrice * itemQty;
                currentItemQty -= itemQty;
                    if (totalItemPrice > getCurrentAccountBalance()) {
                        menu.notEnoughMoneyMessage();
                        return totalItemPrice;
                    } else if (currentItemQty < itemQty) {
                        menu.notEnoughInStockMessage();
                        return itemQty;
                    }
                inventory.get(selectedProduct).setQuantity(currentItemQty);
                menu.returnBalanceAdded(totalItemPrice);
            }
        }
        return 0.00;
    }



    public void setSelectedProduct(String selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    public String getSelectedProduct() {
        return selectedProduct;
    }
}
