package main;
import java.util.ArrayList;

public class Team {
	
	private String name;
	private ArrayList<Athlete> startingNames; 
	private ArrayList<Athlete> reserveNames;
	
	
	Team(){
		startingNames = new ArrayList<Athlete>();
		reserveNames = new ArrayList<Athlete>();
	}
	
	public void printFullRoster(Team team) {
		 for(Athlete ath: team.getStartingName()) {
			 System.out.println(ath + "\n ----------------");
		 }
		 
		 System.out.println("\n\tYour reserves are: ");
		 for(Athlete ath: team.getReserveName()) {
			 System.out.println(ath + "\n ----------------");
		 }
	}
	
	public Athlete findAthleteByNameInStartingNames(Market market, String name) {
		for (Athlete athlete : startingNames) {
	        if (athlete.getName(athlete).equals(name)) {
	            return athlete;
	        }
	    }
	    return null; // if no athlete with the given name is found
	}
	
	public Athlete findAthleteByNameInReserveNames(Market market, String name) {
		for (Athlete athlete : reserveNames) {
	        if (athlete.getName(athlete).equals(name)) {
	            return athlete;
	        }
	    }
	    return null; // if no athlete with the given name is found
	}
	
	public void makeSubstituion(Athlete athleteToSub, Athlete athleteToPlay) {
		
		// first we find if the player is starting or not, then we hold them in a variable
		
		Athlete athleteToPlayObject = null;
		Athlete athleteToSubObject = null;
		
		if (startingNames.contains(athleteToSub)) {
			athleteToSubObject = athleteToSub;
			
		} else if (reserveNames.contains(athleteToSub)){
			athleteToSubObject = athleteToSub;
			
		} else {
			System.out.println("No such athlete exists, please check your spelling");
		}
		
		if (startingNames.contains(athleteToPlay)) {
			athleteToPlayObject = athleteToPlay;
			
		} else if (reserveNames.contains(athleteToPlay)){
			athleteToPlayObject = athleteToPlay;
			
		} else {
			System.out.println("No such athlete exists, please check your spelling");
		}

		if (startingNames.contains(athleteToSubObject)) {
			
			startingNames.remove(athleteToSubObject);
			reserveNames.add(athleteToSubObject);
			
			reserveNames.remove(athleteToPlayObject);
			startingNames.add(athleteToPlayObject);
			
		} else if (reserveNames.contains(athleteToSubObject)) {
			
			reserveNames.remove(athleteToSubObject);
			startingNames.add(athleteToSubObject);
			
			startingNames.remove(athleteToPlayObject);
			reserveNames.add(athleteToPlayObject);
		
		} else {
			System.out.println("you fucked up");
		}
	}
	
	public boolean teamHealthy(Team team) {
		//checks to see if everyone in the starting team is "healthy" (stamina is > 0)
		boolean isHealthy = true;
		for (Athlete ath : team.getStartingName()) {
			if (ath.getInjuryStatus() == true) {
				isHealthy = false;
			}
		}
		return isHealthy;
	}
	
	public void weekPlayed(Team team) {
		//exhausts all starting players 
		for (Athlete ath : team.getStartingName()) {
			ath.setStamina(ath.getStamina() - 10);
		}
	}
	
	/**
	 * all necessary setters and getters to the class
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addStartingPlayer(Athlete athlete) {
		startingNames.add(athlete);
	}
	
	public void addReservePlayer(Athlete athlete) {
		reserveNames.add(athlete);
	}
	
	public ArrayList<Athlete> getStartingName() {
		return startingNames;
	}
	
	public ArrayList<Athlete> getReserveName() {
		return reserveNames;
	}
	
}
