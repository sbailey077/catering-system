package com.techelevator.filereader;

import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/*
    This class should contain any and all details of access to the inventory file
 */
public class InventoryFileReader {

    private String inventoryFilePath;
    private Map<String, CateringItem> inventoryMap = new HashMap<String, CateringItem>();

    public InventoryFileReader(String inventoryFilePath) {
        this.inventoryFilePath = inventoryFilePath;

    }
    public Map<String, CateringItem> getInventory() {
        return this.inventoryMap;
    }

    private void readInventoryFromFile() {
        File file = new File(inventoryFilePath);
        try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String currentLine = fileScanner.nextLine();
                    CateringItem newCateringItem = buildCateringItem(currentLine);
                    inventoryMap.put(newCateringItem.getProductCode(), newCateringItem);
                }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND!!! TRY AGAIN!!!");
        }
    }

    private CateringItem buildCateringItem(String currentLine) {
        CateringItem cateringItem = null;
        String[] cateringItemParts = currentLine.split("\\|");

        String type = cateringItemParts[0];
        String productCode = cateringItemParts[1];
        String description = cateringItemParts[2];
        String price = cateringItemParts[3];


        if (type.equalsIgnoreCase("A")) {
            cateringItem = new Appetizer(type, productCode, description);
        } else if (type.equalsIgnoreCase("B")) {
            cateringItem = new Beverage(type, productCode, description);
        } else if (type.equalsIgnoreCase("E")) {
            cateringItem = new Entree(type, productCode, description);
        } else if (type.equalsIgnoreCase("D")) {
            cateringItem = new Dessert(type, productCode, description);
        }

        cateringItem.setDescription(description);
        cateringItem.setProductCode(productCode);
        cateringItem.setPrice(Double.parseDouble(price));

        return cateringItem;
    }




}
