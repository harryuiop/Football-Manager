package main;
import java.util.ArrayList;

public class Match {
	
	private ArrayList<Athlete> opposingAttackers;
	private ArrayList<Athlete> opposingDefenders;
	private ArrayList<Athlete> playersAttackers;
	private ArrayList<Athlete> playersMidfielders;
	private ArrayList<Athlete> playersDefenders;
	private int opposingScore;
	private int playersScore;
	
	
	
	
	
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