package main;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Market {
	
	
	private ArrayList<Item> catalog = new ArrayList<Item>();
	private ArrayList<Athlete> wavierList = new ArrayList<Athlete>();
	private ArrayList<Item> seenItems = new ArrayList<Item>();
	private ArrayList<Item> unseenItems = new ArrayList<Item>();
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
	 * adds athlete to wavierList being called from Athlete Class
	 * @param athlete
	 */
	public void addPlayerToWavier(PotentialPlayers potentialplayers) {
		ArrayList<Athlete> getAllPlayers = potentialplayers.getAllPlayers();
		for (Athlete ath: getAllPlayers) {
			wavierList.add(ath);
		}
	}
	/**
	 * Adds item to catalog
	 * @param item
	 */
	public void addItemToUnseenItems(Item item) {
		unseenItems.add(item);
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
			System.out.println(unseenItems.size());
			if (unseenItems.size() > 0) {
				int nextItem = rand.nextInt(0, unseenItems.size());
				System.out.println("checkpoint 1");
				Item choosenItem = unseenItems.get(nextItem);
				catalog.add(choosenItem);
				unseenItems.remove(choosenItem);
				counter++;
				}
		}
		
	}

	
	/**
	 * this method will rotate the market and print it out for the users
	 */
	public void goToMarket() {
		rotateMarketItems();
		catalogPrintFormatting();
	}
	
	/**
	 * used for the CLI to formating the printing
	 */
	public void catalogPrintFormatting() {
		for (Item item : catalog) {
			System.out.println(item);
		}
	}	
	
	
	/**
	 * 
	 * @param market
	 */
	public void waiverPrintFormatting(Market market) {
		for (Athlete ath : market.getWavierList()) {
			System.out.println(ath + "\n");
		}
	}	
		
		
	/**
	 * This method is called whenever an athlete is to be accessed by name. 
	 * @param marketYou can use any single capital letter as a non-terminal; S is the start symbol. Any lower-case letter and any digit is a terminal. An underscore _ denotes the empty string ε. There must be exactly one line for each non-terminal. A bar | is used to separate the choices on the right-hand side. Right-hand sides must not be empty; at least one option must be given. Each choice in a right-hand side must not be empty; it may be _ for ε. Productions must not contain spacing. In summary, every production must conform to the following Python regular expressio
	 * @param name
	 * @return
	 */
	public Athlete findAthleteByNameInWavier(Market market, String name) {
		for (Athlete athlete : wavierList) {
	        if (athlete.getName(athlete).equals(name)) {
	            return athlete;
	        }
	    }
		System.out.println("No player with the name " + name + " exists");
	    return null; // if no athlete with the given name is found
	}
	
	
	/**
	 *  This method runs the logic for the initial team pick. There must only be 4 player picked and the player must be able to afford all of them.
	 * @param market
	 * @param team
	 */
	public void pickInitalTeam(Market market, Team team, Player player) {
		
		market.waiverPrintFormatting(market); 
		
		System.out.println("Your current balance is $" + player.getMoneyBalance() + "\n");
		int pickNumber = 0; // runs a counter of player picks that can be made (max 4)
				
		while (pickNumber < 5) {
						
			System.out.println("Type in the players name the add to add to your team" + "\n" + ""); // give information to the player on game state
			String pickName = scanner.nextLine(); // gets the players input on player requested
			
			if (!wavierList.contains(findAthleteByNameInWavier(market, pickName))) { // checks the players input against the waiver list to see if the player exists 
				System.out.println("Invalid Player Name"); // hits else if no name was matched
				continue;
			}
			for (Athlete athlete : wavierList) { // runs a loop on the whole list to get access to the requested player
				if (athlete.getName(athlete).equals(pickName)) { // stops the loop on the requested player
					if (startingBuyPlayerAndMoneyUpdater(player, athlete, team)) { 
						pickNumber++; 
						System.out.println("\tYou remaining Balance: $" + player.getMoneyBalance());
						break;	
					} else {
						System.out.println("Sorry, you cannot afford this playe ----------------\n"
								+ "adam\n"
								+ "	Offence: 29\n"
								+ "	Defense: 62\n"
								+ "	Position: 2\n"
								+ "	Contract Price: $91\n"
								+ "	Sell Back Price $45\n"
								+ "	Rarity 2r"); 
					}
				} 
			}
		}
		System.out.println("\n" + "Your starting team is \n"); // after whole team has been choosen, prints off starting team
		for (Athlete athlete : team.getStartingName()) {
	        System.out.println(athlete);
	    System.out.println("-----------------------------------------");
		}
	}
	
	/**
	 *  This method runs the logic for the initial team pick. There must only be 4 player picked and the player must be able to afford all of them.
	 * @param market
	 * @param team
	 */
	public void pickInitalReserves(Market market, Team team, Player player) {
		
		System.out.println("\n\n\tNow pick your reserves");
		
		market.waiverPrintFormatting(market); 
		
		System.out.println("Your current balance is $" + player.getMoneyBalance() + "\n");
		int pickNumber = 0; // runs a counter of player picks that can be made (max 4)
				
		while (pickNumber < 3) {
						
			System.out.println("Now, type in the players name the add to add to your reserves" + "\n" + ""); // give information to the player on game state
			String pickName = scanner.nextLine(); // gets the players input on player requested
			
			if (!wavierList.contains(findAthleteByNameInWavier(market, pickName))) { // checks the players input against the waiver list to see if the player exists 
				System.out.println("Invalid Player Name"); // hits else if no name was matched
				continue;
			}
			for (Athlete athlete : wavierList) { // runs a loop on the whole list to get access to the requested player
				if (athlete.getName(athlete).equals(pickName)) { // stops the loop on the requested player
					if (reserveBuyPlayerAndMoneyUpdater(player, athlete, team)) { 
						pickNumber++; 
						System.out.println("\tYou remaining Balance: $" + player.getMoneyBalance());
						break;	
					} else {
						System.out.println("Sorry, you cannot afford this player"); 
					}
				} 
			}
		}
		System.out.println("\n" + "Your reserves are \n"); // after whole team has been choosen, prints off starting team
		for (Athlete athlete : team.getReserveName()) {
	        System.out.println(athlete);
        System.out.println("-----------------------------------------");
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
		 * This method returns a boolean based on if the players requested can be afforded.
		 * @return
		 */
	public boolean startingBuyPlayerAndMoneyUpdater(Player player, Athlete athlete, Team team) {
			
			if (player.getMoneyBalance() - athlete.getContractPrice(athlete) > 0) { // checks if player has enough money
				player.setMoneyBalance(player.getMoneyBalance() - athlete.getContractPrice(athlete)); // updates the new bank balance 
				
						 
				team.addStartingPlayer(athlete); // adds to the startPlayers array list in the player class 
				
				wavierList.remove(athlete); // remove the players new athlete from the waiver list
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
