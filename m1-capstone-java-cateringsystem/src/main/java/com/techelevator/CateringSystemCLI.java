package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


/*
 * This class should control the workflow of the application, but not do any other work
 * 
 * The menu class should communicate with the user, but do no other work
 * 
 * This class should control the logical workflow of the application, but it should do no other
 * work.  It should communicate with the user (System.in and System.out) using the Menu class and ask
 * the CateringSystem class to do any work and pass the results between those 2 classes.
 */
public class CateringSystemCLI {
	/*
	 * The menu class is instantiated in the main() method at the bottom of this file.  
	 * It is the only class instantiated in the starter code.  
	 * You will need to instantiate all other classes using the new keyword before you can use them.
	 * 
	 * Remember every class and data structure is a data types and can be passed as arguments to methods or constructors.
	 */
	private Menu menu;


	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	/*
	 * Your application starts here
	 */
	public void run() throws FileNotFoundException {
		menu = new Menu();
		/*
			Display the Starting Menu and get the users choice.
			Remember all uses of System.out and System.in should be in the menu

			IF the User Choice is Display Vending Machine Items,
				THEN display vending machine items
			ELSE IF the User's Choice is Purchase,
				THEN go to the purchase menu
			*/

		InventoryFileReader inventoryFileReader = null;
		boolean hasFilePath = false;
		while (hasFilePath == false) {
			String inventoryFilePath = menu.getUserInput("Please enter the inventory file path");
			try {
				inventoryFileReader = new InventoryFileReader(inventoryFilePath);
				hasFilePath = true;
			} catch (FileNotFoundException e) {
				menu.displayError("File could not be Found.");
			}
		}

		menu.showWelcomeMessage();

		TreeMap<String, CateringItem> cateringInventory = inventoryFileReader.getInventory();

		menu.showMenuOptions();

		String userOptionChoice = menu.getUserNextLine();

		CateringSystem cateringSystem = new CateringSystem();


		while (userOptionChoice.equalsIgnoreCase("1") || userOptionChoice.equalsIgnoreCase("2") || userOptionChoice.equalsIgnoreCase("3")) {
		if (userOptionChoice.equalsIgnoreCase("1")) {
			menu.showInventoryDisplay(cateringInventory);
			menu.showMenuOptions();
			userOptionChoice = menu.getUserNextLine();
		} else if (userOptionChoice.equalsIgnoreCase("2")) {
			menu.showSubMenuOptions();
			String input = menu.getUserNextLine();
			if (input.equalsIgnoreCase("1")) {
				String newMoneyToAdd = menu.getUserAddedMoney();
				cateringSystem.addMoney(newMoneyToAdd);
				menu.printCurrentAccountBalance(cateringSystem.getCurrentAccountBalance());
			} else if (input.equalsIgnoreCase("2")) {
				menu.showInventoryDisplay(cateringInventory);
				String userSelectedItem = menu.getUserSelectedProductCode();
				String selectedCateringItem = cateringSystem.selectAnItem(userSelectedItem);
				String itemQty = menu.getItemQuantity();
				double itemPrice = cateringSystem.getItemPrice(itemQty);
				menu.returnCartBalance(itemPrice);
			}
		}
	}



	}


	/*
	 * This starts the application, but you shouldn't need to change it.  
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();



	}
}
