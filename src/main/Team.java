package main;
import java.util.ArrayList;

public class Team {
	
	private String name;
	private ArrayList<Athlete> startingNames = new ArrayList<Athlete>(); 
	private ArrayList<Athlete> reserveNames = new ArrayList<Athlete>();
	
	
	
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
		System.out.println(athlete.getName(athlete) + " Has been added to your team!");
	}
	
	public ArrayList<Athlete> getStartingName() {
		return startingNames;
	}
	
}
