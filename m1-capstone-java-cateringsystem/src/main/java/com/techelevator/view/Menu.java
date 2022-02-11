package com.techelevator.view;

import com.sun.source.tree.Tree;
import com.techelevator.filereader.InventoryFileReader;

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
	InventoryFileReader inventoryFileReader = new InventoryFileReader("cateringsystem.csv");


	private static final Scanner userInput = new Scanner(System.in);

	public void showWelcomeMessage() {
		System.out.println("*************************");
		System.out.println("**     Weyland Corp.   **");
		System.out.println("**      Catering       **");
		System.out.println("*************************");
		System.out.println();
	}

	public void showMenuOptions() {
		System.out.println("(1) Display Catering Items");
		System.out.println("(2) Order");
		System.out.println("(3) Quit");
	}

	public String setUserInput() {
		String userChoice = userInput.nextLine();
		return userChoice;
	}







}
