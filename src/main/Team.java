package main;
import java.util.ArrayList;

public class Team {
	
	private String name;
	private ArrayList<Player> startingNames; 
	private ArrayList<Player> reserveNames;
	
	
	
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
	public ArrayList<Player> getStartingNames() {
		return startingNames;
	}
	public void setStartingNames(ArrayList<Player> startingNames) {
		this.startingNames = startingNames;
	}
	public ArrayList<Player> getReserveNames() {
		return reserveNames;
	}
	public void setReserveNames(ArrayList<Player> reserveNames) {
		this.reserveNames = reserveNames;
	}
	
	
}
