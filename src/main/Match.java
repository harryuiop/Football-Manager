package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Match {
	
	private ArrayList<Athlete> opposingAttackers;
	private ArrayList<Athlete> opposingDefenders;
	private ArrayList<Athlete> playersAttackers;
	private ArrayList<Athlete> playersMidfielders;
	private ArrayList<Athlete> playersDefenders;
	private int opposingScore;
	private int playersScore;
	private Random random = new Random();
	
	public Boolean coinFlip() {
		return random.nextBoolean();
	}
	
	public Athlete playerSelection(Team team) {
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
	
	public String gamePlay(Player player, Team team, ArrayList<Athlete> opponent, Boolean startingPlayer) {
		String matchResult;
		int progCounter = 0;
		boolean playerPossession = startingPlayer;
		
		
		if (playerPossession == true) {
			Athlete chosenPlayer = playerSelection(team);
		}
		
		for (int i = 20; i > 0; i--) {
			
		}
		
		
		return matchResult;
	}
	
	
	
	
	/**
	 * all necessary setters and getters to the class
	 * @return
	 */
	public ArrayList<Athlete> getOpposingAttackers() {
		return opposingAttackers;
	}
	public void setOpposingAttackers(ArrayList<Athlete> opposingAttackers) {
		this.opposingAttackers = opposingAttackers;
	}
	public ArrayList<Athlete> getOpposingDefenders() {
		return opposingDefenders;
	}
	public void setOpposingDefenders(ArrayList<Athlete> opposingDefenders) {
		this.opposingDefenders = opposingDefenders;
	}
	public ArrayList<Athlete> getPlayersAttackers() {
		return playersAttackers;
	}
	public void setPlayersAttackers(ArrayList<Athlete> playersAttackers) {
		this.playersAttackers = playersAttackers;
	}
	public ArrayList<Athlete> getPlayersMidfielders() {
		return playersMidfielders;
	}
	public void setPlayersMidfielders(ArrayList<Athlete> playersMidfielders) {
		this.playersMidfielders = playersMidfielders;
	}
	public ArrayList<Athlete> getPlayersDefenders() {
		return playersDefenders;
	}	
	public void setPlayersDefenders(ArrayList<Athlete> playersDefenders) {
		this.playersDefenders = playersDefenders;
	}	
	public int getOpposingScore() {
		return opposingScore;
	}	
	public void setOpposingScore(int opposingScore) {
		this.opposingScore = opposingScore;
	}
	public int getPlayersScore() {
		return playersScore;
	}
	public void setPlayersScore(int playersScore) {
		this.playersScore = playersScore;
	}
	
	
	
}