package com.techelevator.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/*
    This class should contain any and all details of access to the inventory file
 */
public class InventoryFileReader {

    private String inventoryFileName;
    private TreeMap<String, String> inventoryMap = new TreeMap<String, String>();
    private List<String> fileLines = new ArrayList<String>();

    public InventoryFileReader(String inventoryFileName) {
        this.inventoryFileName = inventoryFileName;

    }
    public File getFile() {
        File file = new File(inventoryFileName);
        return file;
    }

    public void readFile() {
        try (Scanner fileScanner = new Scanner(getFile())) {
                while (fileScanner.hasNextLine()) {
                    String currentLineInFile = fileScanner.nextLine();
                    fileLines = Arrays.asList(currentLineInFile.split("\\|"));

                }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND!!! TRY AGAIN!!!");
        }
    }
}
