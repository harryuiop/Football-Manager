package main;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Market {
	
	
	private ArrayList<Item> catalog = new ArrayList<Item>();
	private ArrayList<Item> seenItems = new ArrayList<Item>();
	private ArrayList<Item> unseenItems = new ArrayList<Item>();
	
	private ArrayList<Athlete> wavierList = new ArrayList<Athlete>();
	private ArrayList<Athlete> unSeenPlayers = new ArrayList<Athlete>();
	private ArrayList<Athlete> seenPlayers = new ArrayList<Athlete>();
	
	Scanner scanner2 = new  Scanner(System.in);


	/**
	 * Creating an instance of Random
	 */
	Random rand = new Random();
	
	
	/**
	 * creates a scanner method to invoke the Scanner Class to use user inputs
	 */
	Scanner scanner = new Scanner(System.in);
	
	
	/**
	 * Adds item to catalog
	 * @param item
	 */
	public void addItemToUnseenItems(Item item) {
		unseenItems.add(item);
	}
	 
	
	/**
	 * adds athlete to wavierList being called from Athlete Class
	 * @param athlete
	 */
	public void initalWavier(PotentialPlayers potentialplayers) {
		
		ArrayList<Athlete> unSeenPlayers = potentialplayers.getAllPlayers();

		int counter = 0;
		while (counter < 20) {
			int nextPlayer = rand.nextInt(0, unSeenPlayers.size());
			Athlete chooseAth = unSeenPlayers.get(nextPlayer);
			unSeenPlayers.remove(chooseAth);
			wavierList.add(chooseAth);
			counter++;
			}
			
		}
	
	/**
	 * 
	 */
	public void rotateWavier() {
		
		if (unSeenPlayers.size() < 3) {
			for(Athlete ath: seenPlayers) {
				unSeenPlayers.add(ath);
				seenPlayers.remove(ath);
			}
		}
		
		wavierList.clear();
		
		int counter = 0;
		while (counter < 3) {
			if (unSeenPlayers.size() > 0) {
				int nextPlayer = rand.nextInt(0, unSeenPlayers.size());
				Athlete choosenPlayer = unSeenPlayers.get(nextPlayer);
				wavierList.add(choosenPlayer);
				unseenItems.remove(choosenPlayer);
				counter++;
				} else {
					counter++;					
			}
		}
	}
	
	
	
	
	/**
	 * This method will get called once at the start of the program to set the first market rotation
	 */
	public void initalMarketItems() {
		int counter = 0;
		while (counter < 3) {
			int nextItem = rand.nextInt(0, unseenItems.size());
			Item choosenItem = unseenItems.get(nextItem);
			catalog.add(choosenItem);
			unseenItems.remove(choosenItem);
			counter++;
		}
	}
	
	
	/**
	 * This method can be called at any time in order to change the items in the market
	 */
	public void rotateMarketItems() {
		if (unseenItems.size() < 3) {
			for(Item item: seenItems) {
				unseenItems.add(item);
				seenItems.remove(item);
			}
		}
			
		catalog.clear();
	
		
		int counter = 0;
		while (counter < 3) {
			if (unseenItems.size() > 0) {
				int nextItem = rand.nextInt(0, unseenItems.size());
				Item choosenItem = unseenItems.get(nextItem);
				catalog.add(choosenItem);
				unseenItems.remove(choosenItem);
				counter++;
				} else {
					counter++;					
			}
		}
	}
	
	
	
	
	/**
	 * this method will rotate the market and print it out for the users
	 */
	public void goToMarket(Player player) {
		rotateMarketItems();

		int itemInput = scanner.nextInt();
		if (itemInput == 0) {
			return;
		} else {

			if (itemInput > catalog.size()) {
				System.out.println("Please pick a valid number");
				itemInput = scanner.nextInt();
			} 	
			player.setMoneyBalance(player.getMoneyBalance() - (catalog.get(itemInput - 1)).getItemPrice());
			
			while (catalog.size() > 0) {
			
			player.addItemToInventory(catalog.get(itemInput - 1));
			catalog.remove(catalog.get(itemInput - 1));
			
			System.out.println("\n\tTo purchase an item, enter it's numer or 0 to exit");
			System.out.println("\tYour balance is: $" + player.getMoneyBalance());
			itemInput = scanner.nextInt();
			
			if (itemInput > catalog.size()) {
				System.out.println("Please pick a valid number");
				itemInput = scanner.nextInt();
			} 
			
			if (catalog.size() == 1) {
				System.out.println("\n\tThe market is now empty\n");
				player.setMoneyBalance(player.getMoneyBalance() - (catalog.get(itemInput - 1)).getItemPrice());
				return;
			}	
			
			if (itemInput == 0) {
				return;
			}
			
			
			player.setMoneyBalance(player.getMoneyBalance() - (catalog.get(itemInput - 1)).getItemPrice());

			
			}
		}
	}
	
	
	/**
	 * This method returns a boolean based on if the players requested can be afforded. this verson is used if 
	 * @return
	 */
	public boolean reserveBuyPlayerAndMoneyUpdater(Player player, Athlete athlete, Team team) {
		
		if (player.getMoneyBalance() - athlete.getContractPrice(athlete) > 0) { // checks if player has enough money
			player.setMoneyBalance(player.getMoneyBalance() - athlete.getContractPrice(athlete)); // updates the new bank balance 
				 
			team.addReservePlayer(athlete); // adds to the startPlayers array list in the player class 
			wavierList.remove(athlete); // remove the players new athlete from the waiver list
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * This method returns a boolean based on if the players requested can be afforded. this verson is used if 
	 * 
	 * CALLUM: THESE TWO FUNCTIONS CAN BE COMBINED AND PUT INTO THE PURCHASABLE INTERFACE
	 * @return
	 */
	public boolean BuyPlayerAndMoneyUpdater(Player player, Athlete athlete, Team team) {
		
		if (player.getMoneyBalance() - athlete.getContractPrice(athlete) > 0) { // checks if player has enough money
			player.setMoneyBalance(player.getMoneyBalance() - athlete.getContractPrice(athlete)); // updates the new bank balance 
			
			team.addStartingPlayer(athlete); // adds to the startPlayers array list in the player class 
			wavierList.remove(athlete); // remove the players new athlete from the waiver list
			return true;
		} else {
			return false;
		}
	}
	
	public boolean BuyItemAndMoneyUpdater(Player player, Item item, Team team) {
		
		if (player.getMoneyBalance() - item.getItemPrice() > 0) { // checks if player has enough money
			player.setMoneyBalance(player.getMoneyBalance() - item.getItemPrice()); // updates the new bank balance 
			
			player.addItemToInventory(item); // adds to the startPlayers array list in the player class 
			return true;
		} else {
			return false;
		}
	}
			 
	
	/**
	 * this method is called in the game environment main loop in order to created all game items.
	 */
	public void createItems() {
		
		Item firstTeirBoots = new Item("First Teir Boots", 3, 2, 0, 1, 10);
		Item secondTeirBoots = new Item("Second Teir Boots", 6, 3, 0, 2, 50);
		Item thirdTeirBoots = new Item("Third Teir Boots", 10, 5, 0, 3, 100);
		addItemToUnseenItems(firstTeirBoots);
		addItemToUnseenItems(secondTeirBoots);
		addItemToUnseenItems(thirdTeirBoots);
		
		Item firstTeirShinPads = new Item("First Teir Shinpads", 2, 7, 0, 1, 10);
		Item secondTeirShinPads = new Item("Second Teir Shinpads", 4, 11, 0, 2, 50);
		Item thirdTeirShinPads = new Item("Third Teir Shinpads", 6, 15, 0, 3, 100);
		addItemToUnseenItems(firstTeirShinPads);
		addItemToUnseenItems(secondTeirShinPads);
		addItemToUnseenItems(thirdTeirShinPads);
		
		Item mildlySuspiciousSubstance = new Item("Mildly Suspicious Substance", 10, 10, 10, 2, 200);
		Item moderatlySuspiciousSubstance = new Item("Moderatly Suspicious Substance", 10, 10, 10, 2, 200);
		Item stronglySuspiciousSubstance = new Item("Strongly Suspicious Substance", 20, 20, 20, 3, 300);
		addItemToUnseenItems(mildlySuspiciousSubstance);
		addItemToUnseenItems(moderatlySuspiciousSubstance);
		addItemToUnseenItems(stronglySuspiciousSubstance);
		
		Item oranges = new Item("Oranges", 2, 2, 30, 2, 30);
		Item sweets = new Item("Sweets", 2, 2, 50, 1, 60);
		Item hydrationDrink = new Item("Hydration Drink", 2, 2, 50, 2, 60);
		addItemToUnseenItems(oranges);
		addItemToUnseenItems(sweets);
		addItemToUnseenItems(hydrationDrink);
		
		
		Item attackingTrainingDay  = new Item("Attacking Training Day", 15, 0, 0, 1, 50);
		Item defensiveTrainingDay = new Item("Defensive Training Day", 0, 15, 0, 1, 50);
		Item gymDay = new Item("Gym Day", 10, 10, 10, 1, 50);
		addItemToUnseenItems(attackingTrainingDay);
		addItemToUnseenItems(defensiveTrainingDay);
		addItemToUnseenItems(gymDay);
		
		initalMarketItems();
	}
	
	/**
	 * all necessary setters and getters to the class
	 * @return
	 */
	public ArrayList<Item> getCatalog() {
		return catalog;
	}
	
	public void setCatalog(ArrayList<Item> catalog) {
		this.catalog = catalog;
	}
	
	public ArrayList<Athlete> getWavierList() {
		return wavierList;
	}
	
	

	
	
}
