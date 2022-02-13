package com.techelevator.view;

import com.sun.source.tree.Tree;
import com.techelevator.CateringSystem;
import com.techelevator.items.CateringItem;

import java.io.FileNotFoundException;
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
	

	public Menu() throws FileNotFoundException {
	}


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

	public String getUserNextLine() {
		String userOptionChoice = userInput.nextLine();
		return userOptionChoice;
	}

	public void showSubMenuOptions() {
		System.out.println("Please select an option:");
		System.out.println("(1) Add Money");
		System.out.println("(2) Select Products");
		System.out.println("(3) Complete Transactions");
	}

	public void displayIncorrectBillMessage() {
		System.out.println("Please Enter a Valid Bill Amount: ");
	}

	public void printCurrentAccountBalance(double d){
		System.out.println("Current Account Balance: " + "$" + d);
	}


	public String getUserAddedMoney() {
		System.out.println("Please Enter Amount of Money you Want To Add Up To $500: ");
		String userAddedMoney = userInput.nextLine();
		return userAddedMoney;
	}

	public void displayMoneyCap() {
		System.out.println("You have reached the maximum amount you are able to add.");
	}

	public void productDoesNotExistMessage() {
		System.out.println("This product does not exist.");
	}

	public String getUserSelectedProductCode() {
		System.out.println("Please select the item you would like to purchase: ");
		String itemToPurchase = userInput.nextLine();
		return itemToPurchase;
	}

	public void displaySelectedItem(String selectedCateringItem) {
		System.out.println("You have selected: " + selectedCateringItem);
	}

	public String getItemQuantity() {
		System.out.println("How many would you like to purchase?");
		String itemQuantity = userInput.nextLine();
		return itemQuantity;
	}

	public void returnBalanceAdded (double totalItemPrice) {
		System.out.println("$" + totalItemPrice + " has been added to your cart.");
	}

	public void notEnoughMoneyMessage () {
		System.out.println("You do not have enough funds for this purchase.");
	}

	public void notEnoughInStockMessage() {
		System.out.println("There are not enough items in stock for this purchase.");
	}

	public void displayCartTotal(double totalPrice) {
		System.out.println("Total Balance in Cart: " + "$" + totalPrice);
	}

	public String appetizerMessage() {
		System.out.println("You might need extra plates.");
		return "";
	}

	public void beverageMessage() {
		System.out.println("Don't forget ice.");
	}

	public void entreeMessage() {
		System.out.println("Did you remember Dessert?");
	}

	public String dessertMessage() {
		System.out.println("Coffee goes with Dessert.");
		return "";
	}

	public void receiptMessage(TreeMap<String, CateringItem> receiptMap) {

		for(Map.Entry<String, CateringItem> mapIndex : receiptMap.entrySet()) {
			System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s %-20s"
					, mapIndex.getValue().getQuantity()
					, mapIndex.getValue().getClass()
					, mapIndex.getValue().getDescription()
					, mapIndex.getValue().getPrice()
					, mapIndex.getValue().getQuantity() * mapIndex.getValue().getPrice())
			);
		}

	}

}
