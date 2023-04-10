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
			System.out.println(ath + "\n");
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
	public void pickInitalTeam(Market market, Team team, Player player) {
		
		market.waiverPrintFormatting(market); 
		
		System.out.println("Your current balance is $" + player.getMoneyBalance() + "\n");
		int pickNumber = 0; // runs a counter of player picks that can be made (max 4)
				
		while (pickNumber < 5) {
						
			System.out.println("Type in the players name the add to add to your team" + "\n" + ""); // give information to the player on game state
			String pickName = scanner.nextLine(); // gets the players input on player requested
			
			if (!wavierList.contains(findAthleteByName(market, pickName))) { // checks the players input against the waiver list to see if the player exists 
				System.out.println("Invalid Player Name"); // hits else if no name was matched
				continue;
			}
			for (Athlete athlete : wavierList) { // runs a loop on the whole list to get access to the requested player
				if (athlete.getName(athlete).equals(pickName)) { // stops the loop on the requested player
					if (player.getMoneyBalance() - athlete.getContractPrice(athlete) > 0) { 
						player.setMoneyBalance(player.getMoneyBalance() - athlete.getContractPrice(athlete));
						team.addStartingPlayer(athlete); // adds to the startPlayers array list in the player class 
						wavierList.remove(athlete); // remove the players new athlete from the waiver list
						pickNumber++; 
						System.out.println("\tYou remaining Balance: $" + player.getMoneyBalance());
						break;	
					} else {
						System.out.println("Sorry, you cannot afford this player");
					}
				} 
			}
		}
		System.out.println("\n" + "Your starting team is \n"); // after whole team has been choosen, prints off starting team
		for (Athlete athlete : team.getStartingName()) {
	        System.out.println(athlete);
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
