package com.techelevator.view;

import com.sun.source.tree.Tree;
import com.techelevator.CateringSystem;
import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;
import com.techelevator.view.CashRegister;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/*
 * This is the only class that should have any usage of System.out or System.in
 *
 * Usage of System.in or System.out should not appear ANYWHERE else in your code outside of this class.
 *
 * Work to get input from the user or display output to the user should be done in this class, however, it
 * should include no "work" that is the job of the catering system.
 */
public class Menu {

	private static final Scanner userInput = new Scanner(System.in);

	public void showWelcomeMessage() {
		System.out.println("*************************");
		System.out.println("**     Weyland Corp.   **");
		System.out.println("**      Catering       **");
		System.out.println("*************************");
		System.out.println();
	}

	public void showMenuOptions() {
		System.out.println("Please select an option:");
		System.out.println();
		System.out.println("(1) Display Catering Items");
		System.out.println("(2) Order");
		System.out.println("(3) Quit");
	}

	public String getUserInput(String userFileInput) {
		System.out.println(userFileInput);
		return userInput.nextLine();
	}

	public void displayError(String errorMessage) {
		System.out.println("Error");
		System.out.println(errorMessage);
	}

	public void showInventoryDisplay(TreeMap<String, CateringItem> inventoryDisplay) {
		System.out.println("Items Available:");
		System.out.printf("%-20s %-25s %-20s %-20s %n","Product Code" , "Description","Qty" , "Price");
		System.out.println("------------------------------------------------------------------------");

		for(Map.Entry<String, CateringItem> mapEntryIndex : inventoryDisplay.entrySet()) {
			String price = String.format("$%4.2f", mapEntryIndex.getValue().getPrice());
			String output = String.format("%-20s %-25s %-20s", mapEntryIndex.getValue().getProductCode(),
					mapEntryIndex.getValue().getDescription(), mapEntryIndex.getValue().getQuantity());
			System.out.println(output + price);
		}
	}

	public String getUserOptionChoice() {
		String userOptionChoice = userInput.nextLine();
		return userOptionChoice;
	}

	public void showSubMenuOptions() {
		System.out.println("Please select an option:");
		System.out.println("(1) Add Money");
		System.out.println("(2) Select Products");
		System.out.println("(3) Complete Transactions");
	}


}
