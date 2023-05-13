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
	
	public void makeSubstituion(String athleteToSub, String athleteToPlay, Market market) {
		
		// first we find if the player is starting or not, then we hold them in a variable
		
		Athlete athleteToPlayObject = null;
		Athlete athleteToSubObject = null;
		
		if (startingNames.contains(findAthleteByNameInStartingNames(market, athleteToSub))) {
			athleteToSubObject = findAthleteByNameInStartingNames(market, athleteToSub);
			
		} else if (reserveNames.contains(findAthleteByNameInReserveNames(market, athleteToSub))){
			athleteToSubObject = findAthleteByNameInReserveNames(market, athleteToSub);
			
		} else {
			System.out.println("No such athlete exists, please check your spelling");
		}
		
		if (startingNames.contains(findAthleteByNameInStartingNames(market, athleteToPlay))) {
			athleteToPlayObject = findAthleteByNameInStartingNames(market, athleteToPlay);
			
		} else if (reserveNames.contains(findAthleteByNameInReserveNames(market, athleteToPlay))){
			athleteToPlayObject = findAthleteByNameInReserveNames(market, athleteToPlay);
			
		} else {
			System.out.println("No such athlete exists, please check your spelling");
		}
		
		System.out.println(athleteToPlayObject);
		System.out.println(athleteToSubObject);


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
		System.out.println("\n" + athlete.getName(athlete) + " Has been added to your team!");
	}
	
	public void addReservePlayer(Athlete athlete) {
		reserveNames.add(athlete);
		System.out.println("\n" + athlete.getName(athlete) + " Has been added to your team!");
	}
	
	public ArrayList<Athlete> getStartingName() {
		return startingNames;
	}
	
	public ArrayList<Athlete> getReserveName() {
		return reserveNames;
	}
	
}
