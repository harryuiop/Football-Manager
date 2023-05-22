package main;
import java.util.ArrayList;
import java.util.Random;

public class Match {
	
	private ArrayList<Athlete> opposingAttackers;
	private ArrayList<Athlete> opposingDefenders;
	private ArrayList<Athlete> playersAttackers;
	private ArrayList<Athlete> playersMidfielders;
	private ArrayList<Athlete> playersDefenders;
	private int opposingScore;
	private int playersScore;
	
	
	Match(){
		opposingScore = 0;
		playersScore = 0;
	}
	/**
	 * The Main game-loop: Works by each players' starting athlete facing the opponents opposite and a 'point' is gained when 
	 * an attackers offence stat is greater than a defenders defence stat
	 * @param game
	 * @param player
	 * @param team
	 * @param opponent
	 * @return
	 */
	public String matchUp(GameEnviroment game, Player player, Team team, Athlete playersAth, Athlete oppsAth, String inPossesion){
		Random statRange = new Random();
		String matchUpResult = "Win";
		
		int playerOffStat = playersAth.getOffence();
		int oppOffStat = oppsAth.getOffence();
		
		int playerDefStat = playersAth.getDefence();
		int oppDefStat = playersAth.getDefence();
		
		int playerStat = statRange.nextInt(0,10);
		int playerPlusOrMinus = statRange.nextInt(0,1);
		
		int opponentStat = statRange.nextInt(0,10);
		int opponentPlusOrMinus = statRange.nextInt(0,1);
		

		
		
		switch(inPossesion) {
			case "player":
				
				switch(playerPlusOrMinus) {
				case 0:
					playerOffStat += playerStat;
					break;
				case 1:
					playerOffStat -= playerStat;
					break;
				}
				
				switch(opponentPlusOrMinus) {
				case 0:
					oppDefStat += opponentStat;
					break;
				case 1:
					oppDefStat -= opponentStat;
					break;
				}
				
				if (playerOffStat > oppDefStat) {
					setPlayersScore(getPlayersScore()+1);
					matchUpResult = "Won";
				}
				else if (playerOffStat < oppDefStat) {
					matchUpResult = "Lost";
				}
				else {
					matchUpResult = "Draw";
				}
				break;
			case "opp":
				
				switch(playerPlusOrMinus) {
				case 0:
					playerDefStat += playerStat;
					break;
				case 1:
					playerDefStat -= playerStat;
					break;
				}
				
				switch(opponentPlusOrMinus) {
				case 0:
					oppOffStat += opponentStat;
					break;
				case 1:
					oppOffStat -= opponentStat;
					break;
				}
				
				if (playerDefStat > oppOffStat) {
					matchUpResult = "Won";
				}
				else if (playerDefStat < oppOffStat){
					setOpposingScore(getOpposingScore()+1);
					matchUpResult = "Lost";
				}
				else {
					matchUpResult = "Draw";
				}
				break;
				
		}
		return matchUpResult;
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