package main.LOGIC;

import java.util.ArrayList;

public class Team {
	
	
	private String name;
	private ArrayList<Athlete> startingNames; 
	private ArrayList<Athlete> reserveNames;
	
	
	/**
	 * Constructor
	 */
	public Team(){
		startingNames = new ArrayList<Athlete>();
		reserveNames = new ArrayList<Athlete>();
	}
	
	/**
	 * First searches if player is in the starting or reserves, then stores it, these swaps them based off if logic
	 * @param athleteToSub
	 * @param athleteToPlay
	 */
	public void makeSubstituion(Athlete athleteToSub, Athlete athleteToPlay) {		
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
	
	
	/**
	 * checks to see if everyone in the starting team is "healthy" (stamina is > 0)
	 * @param team
	 * @return
	 */
	public boolean startingTeamHealthy(Team team) {
		boolean isHealthy = true;
		for (Athlete ath : team.getStartingName()) {
			if (ath.getInjuryStatus() == true) {
				isHealthy = false;
			}
		}
		return isHealthy;
	}
	
	
	/**
	 * Checks to see if everyone in the reserve team is "healthy" (stamina is > 0)
	 * @param team
	 * @return
	 */
	public boolean reserveTeamHealthy(Team team) {
		boolean isHealthy = true;
		for (Athlete ath : team.getReserveName()) {
			if (ath.getInjuryStatus() == true) {
				isHealthy = false;
			}
		}
		return isHealthy;
	}
	
	
	/**
	 * Counts how many players in the players team are injured 
	 * @param teamList
	 * @return
	 */
	public int howManyInjured(ArrayList<Athlete> teamList) {
		int injuredCount = 0;
		for (Athlete ath : teamList) {
			if (ath.getInjuryStatus() == true){
				injuredCount += 1;
			}
		}
		return injuredCount;
	}
	
	
	/**
	 * exhausts all starting players after a matchup by reducing stamina by 10
	 * @param team
	 */
	public void gamePlayedStamDecr(Team team) {
		for (Athlete ath : team.getStartingName()) {
			if (ath.getStamina() > 0) {
				ath.setStamina(ath.getStamina() - 10);
			}
		}
	}
	
	/**
	 * Regenerates a list of athletes back to 100
	 * @param teamList
	 */
	public void regenStam(ArrayList<Athlete> teamList) {
		for (Athlete Ath: teamList) {
			Ath.setStamina(100);
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
