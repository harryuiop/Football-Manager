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
	
	public void waiverPrintFormatting(Market market) {
		for (Athlete ath : market.getWavierList()) {
			System.out.println(ath);
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
		
		System.out.println("Your current balance is $" + player.getMoneyBalance());
		int pickNumber = 0; // runs a counter of player picks that can be made (max 4)
				
		while (pickNumber < 5) {
						
			System.out.println("Type in the players name the add to add to your team" + "\n" + ""); // give information to the player on game state
			String pickName = scanner.nextLine(); // gets the players input on player requested
			
			if (wavierList.contains(findAthleteByName(market, pickName))) { // checks the players input against the waiver list to see if the player exists 
				
				for (Athlete ath : wavierList) { // runs a loop on the whole list to get access to the requested player
					if (ath.getName(ath).equals(pickName)) { // stops the loop on the requested player
						
						team.addStartingPlayer(ath); // adds to the startPlayers array list in the player class 
						market.wavierList.remove(ath); // remove the players new athlete from the waiver list
						pickNumber++; // increments the counter to specify that a valid pick has been made and executed 
						break;		
					} 
				}
			}
		}
		System.out.println("Your starting team is \n");
		System.out.println(team.getStartingName());
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
