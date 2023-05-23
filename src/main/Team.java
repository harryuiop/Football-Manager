package main;
import java.rmi.server.RemoteServer;
import java.util.ArrayList;

public class Team {
	
	private String name;
	private ArrayList<Athlete> startingNames; 
	private ArrayList<Athlete> reserveNames;
	
	
	Team(){
		startingNames = new ArrayList<Athlete>();
		reserveNames = new ArrayList<Athlete>();
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
		}
		
		if (startingNames.contains(athleteToPlay)) {
			athleteToPlayObject = athleteToPlay;
			
		} else if (reserveNames.contains(athleteToPlay)){
			athleteToPlayObject = athleteToPlay;
			
		} else {
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
		}
	}
	
	public boolean startingTeamHealthy(Team team) {
		//checks to see if everyone in the starting team is "healthy" (stamina is > 0)
		boolean isHealthy = true;
		for (Athlete ath : team.getStartingName()) {
			if (ath.getInjuryStatus() == true) {
				isHealthy = false;
			}
		}
		return isHealthy;
	}
	
	public boolean reserveTeamHealthy(Team team) {
		//checks to see if everyone in the starting team is "healthy" (stamina is > 0)
		boolean isHealthy = true;
		for (Athlete ath : team.getReserveName()) {
			if (ath.getInjuryStatus() == true) {
				isHealthy = false;
			}
		}
		return isHealthy;
	}
	
	public int howManyInjured(ArrayList<Athlete> teamList) {
		int injuredCount = 0;
		for (Athlete ath : teamList) {
			if (ath.getInjuryStatus() == true){
				injuredCount += 1;
			}
		}
		return injuredCount;
	}
	
	public void gamePlayedStamDecr(Team team) {
		//exhausts all starting players 
		for (Athlete ath : team.getStartingName()) {
			if (ath.getStamina() > 0) {
				ath.setStamina(ath.getStamina() - 10);
			}
		}
	}
	
	
	public void removeReservePlayer(int index) {
		reserveNames.remove(index);
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
