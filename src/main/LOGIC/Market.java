package main.LOGIC;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Market {
	
	
	private ArrayList<Item> unseenItems = new ArrayList<Item>();
	private ArrayList<Item> seenItems = new ArrayList<Item>();
	private ArrayList<Item> holder = new ArrayList<Item>();
	private ArrayList<Item> catalog = new ArrayList<Item>();
	
	public ArrayList<Athlete> unSeenPlayers = new ArrayList<Athlete>();
	private ArrayList<Athlete> wavierList = new ArrayList<Athlete>();
	public ArrayList<Athlete> seenPlayers = new ArrayList<Athlete>();
	
	
	/**
	 * Creating an instance of Random
	 */
	Random rand = new Random();
	
	
	/**
	 * Adds an item to unseen items
	 * @param item
	 */
	public void addItemToUnseenItems(Item item) {
		unseenItems.add(item);
	}
	
	
	/**
	 * Removes an athlete from the wavier list
	 * @param ath
	 */
	public void removeAthelte(Athlete ath) {
		wavierList.remove(ath);
	}
	
	
	/**
	 * Adds a player to unseen players
	 * @param ath
	 */
	public void addPlayersToUnseenPlayers(Athlete ath) {
		unSeenPlayers.add(ath);
	}
	 
	
	/**
	 * This method will get called once at the start of the program to set the first market rotation of items
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
	 * creates the intial wavier list starting with 20 athletes, called from game enviroment
	 * @param athlete 
	 */
	public void initalWavier(PotentialPlayers potentialplayers) {
		unSeenPlayers = potentialplayers.getAllPlayers(); // pulls all the randomly generated players from potentialplayers class
		int counter = 0;
		while (counter < 20) {
			int nextPlayer = rand.nextInt(0, unSeenPlayers.size());
			Athlete chooseAth = unSeenPlayers.get(nextPlayer);
			wavierList.add(chooseAth);
			unSeenPlayers.remove(chooseAth);
			counter++;
			}
		}
	
	
	/**
	 * rotates the wavierlist to refresh all new athletes
	 * first if statment checks to see if there are enough players in the unseen list, else, reset the whole list
	 * then adds 12 new athletes that havent been seen yet
	 */
	public void rotateWavier() {
		if (unSeenPlayers.size() < 12) {
			for(Athlete ath: seenPlayers) {
				unSeenPlayers.add(ath);
				holder.remove(ath);
			}
		}
		wavierList.clear();
		int counter = 0;
		while (counter < 12) {
			if (unSeenPlayers.size() > 0) {
				int nextPlayer = rand.nextInt(0, unSeenPlayers.size());
				Athlete choosenPlayer = unSeenPlayers.get(nextPlayer);
				wavierList.add(choosenPlayer);
				unSeenPlayers.remove(choosenPlayer);
				counter++;
				} else {
					counter++;
				}	
			}
		}

	
	/**
	 * rotates the wavierlist to refresh all new items
	 * first if statment checks to see if there are enough items in the unseen list, else, reset the whole list
	 * then adds 3 new athletes that havent been seen yet
	 */
	public void rotateMarketItems() {
		if (unseenItems.size() < 5) {
			unseenItems.addAll(seenItems);
			seenItems.clear();
		}
		catalog.clear();
		int counter = 0;
		while (counter < 3) {
			if (unseenItems.size() > 0) {
				int nextItem = rand.nextInt(0, unseenItems.size());
				Item choosenItem = unseenItems.get(nextItem);
				catalog.add(choosenItem);
				unseenItems.remove(choosenItem);
				seenItems.add(choosenItem);
				counter++;
				} else {
					counter++;					
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
	public boolean SellPlayerAndMoneyUpdater(Player player, Athlete athlete, Team team) {
		
		player.setMoneyBalance(player.getMoneyBalance() + athlete.getContractPrice(athlete)); // updates the new bank balance 
		
		if (team.getStartingName().contains(athlete)) {
			team.getStartingName().remove(athlete);
		}
		else {
			team.getReserveName().remove(athlete);
		}
		return true;
	}
	
	
	/**
	 * adds athlete to the starting team and updates balance
	 * @param player
	 * @param athlete
	 * @param team
	 * @param startingFull
	 * @return
	 */
	public boolean BuyPlayerAndMoneyUpdater(Player player, Athlete athlete, Team team, Boolean startingFull) {
		if (player.getMoneyBalance() - athlete.getContractPrice(athlete) > 0) { // checks if player has enough money
			player.setMoneyBalance(player.getMoneyBalance() - athlete.getContractPrice(athlete)); // updates the new bank balance 
			if (startingFull == false) {
				team.addStartingPlayer(athlete); // adds to the startPlayers array list in the player class 
			}
			else {
				team.addReservePlayer(athlete); // adds to the reservePlayers array list in the player class 
			}
			wavierList.remove(athlete); // remove the players new athlete from the waiver list
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * adds item to inventory and updates balance
	 * @param player
	 * @param item
	 * @param team
	 * @return
	 */
	public boolean BuyItemAndMoneyUpdater(Player player, Item item, Team team) {
		
		if (player.getMoneyBalance() - item.getItemPrice() > 0) { // checks if player has enough money
			player.setMoneyBalance(player.getMoneyBalance() - item.getItemPrice()); // updates the new bank balance 
			
			player.addItemToInventory(item); // adds to the startPlayers array list in the player class 
			catalog.remove(item);
			unseenItems.add(item);
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
	
	public ArrayList<Item> getUnseenItems(){
		return unseenItems;
	}
	
	

	
	
}
