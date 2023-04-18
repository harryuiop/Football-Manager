package main;
import java.util.ArrayList;
import java.util.Scanner;

public class Market {
	
	
	private ArrayList<Item> catalog;
	private ArrayList<Athlete> wavierList = new ArrayList<Athlete>();
	
	
	/**
	 * creates a scanner method to invoke the Scanner Class to use user inputs
	 */
	 Scanner scanner = new Scanner(System.in);
	
	 
	/**
	 * adds athlete to wavierList being called from Athlete Class
	 * @param athlete
	 */
	public void addPlayerToWavier(PotentialPlayers potentialplayers) {
		ArrayList<Athlete> getAllPlayers = potentialplayers.getAllPlayerArray();
		for (Athlete ath: getAllPlayers) {
			wavierList.add(ath);
		}
	}
	
	
	/**
	 * 
	 * @param market
	 */
	public void waiverPrintFormatting(Market market) {
		for (Athlete ath : market.getWavierList()) {
			System.out.println(ath.getName(ath) + ": " + ath.getOffence() + "/" + ath.getDefence() + " (ATK/DEF) " + "(Rarity:" + ath.getRarity() + ") " + "$" + ath.getContractPrice(ath) + "\n");
		}
	}	
		
		
	/**
	 * This method is called whenever an athlete is to be accessed by name. 
	 * @param market
	 * @param name
	 * @return
	 */
	public Athlete findAthleteByName(Market market, String name) {
		for (Athlete athlete : wavierList) {
	        if (athlete.getName(athlete).equals(name)) {
	            return athlete;
	        }
	    }
	    return null; // if no athlete with the given name is found
	}
	
	
	/**
	 *  This method runs the logic for the initial team pick. There must only be 4 player picked and the player must be able to afford all of them.
	 * @param market
	 * @param team
	 */
	public void pickInitalTeam(Market market, Team team, Player player, GameEnviroment game) {
		
		market.waiverPrintFormatting(market); 
		
		int pickNumber = 0; // runs a counter of player picks that can be made (max 4)
				
		while (pickNumber < 5) {
						
			System.out.println("\n" + "Current Balance: $" +  player.getMoneyBalance()+ "\nType a players name to add to your team" + ""); // give information to the player on game state
			String pickName = scanner.nextLine(); // gets the players input on player requested
			
			if (!wavierList.contains(findAthleteByName(market, pickName))) { // checks the players input against the waiver list to see if the player exists 
				System.out.println("Invalid Player Name"); // hits else if no name was matched
				continue;
			}
			for (Athlete athlete : wavierList) { // runs a loop on the whole list to get access to the requested player
				if (athlete.getName(athlete).equals(pickName)) { // stops the loop on the requested player
					if (buyPlayerAndMoneyUpdater(player, athlete, team, game)) { 
						pickNumber++; 
						break;	
					} else {
						System.out.println("Sorry, you cannot afford this player"); 
					}
				} 
			}
		}
		
		
		if(game.getStarterStatus() == true) {
			System.out.println("\n" + "Your starting team is \n"); // after whole team has been chosen, prints off starting team
			for (Athlete athlete : team.getStartingName()) {
		        System.out.println(athlete + "\n");		
			}
			game.setStarterStatus();
			System.out.println("Now select your Reserves");
			
		} else {
			System.out.println("\n" + "Your full team is \n"); // after whole team has been chosen, prints off the entire team
			
			System.out.println("Starters:\n");
			for (Athlete athlete : team.getStartingName()) {
		        System.out.println("\t" + athlete + "\n");	
			}
			
			System.out.println("Reserves:\n");
			for (Athlete athlete : team.getReserveName()) {
		        System.out.println("\t" + athlete + "\n");	
			}
		}
	}
	
	
	/**
	 * This method returns a boolean based on if the players requested can be afforded.
	 * @return
	 */
	public boolean buyPlayerAndMoneyUpdater(Player player, Athlete athlete, Team team, GameEnviroment game) {
		
		if (player.getMoneyBalance() - athlete.getContractPrice(athlete) > 0) { // checks if player has enough money
			player.setMoneyBalance(player.getMoneyBalance() - athlete.getContractPrice(athlete)); // updates the new bank balance 
			
			if(game.getStarterStatus() == true) {
				team.addStartingPlayer(athlete); // adds to the startPlayers array list in the player class 
			
			} else {
				team.addReservePlayer(athlete); // adds to the reservePlayers array list in the player class
			}

			wavierList.remove(athlete); // remove the players new athlete from the waiver list
			return true;
		} else {
			return false;
		}
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
