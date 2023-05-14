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
	
	
	/**
	 * The Main game-loop: Works by each players' starting athlete facing the opponents opposite and a 'point' is gained when 
	 * an attackers offence stat is greater than a defenders defence stat
	 * @param game
	 * @param player
	 * @param team
	 * @param opponent
	 * @return
	 */
	public String matchPlay(GameEnviroment game, Player player, Team team, ArrayList<Athlete> opponent){
		String matchResult;
		
		setPlayersScore(0);
		setOpposingScore(0);
		
		for(int i = 0; i < 5; i++){
			Athlete opponentMatchUp = opponent.get(i);
			Athlete playerMatchUp = team.getStartingName().get(i);

			System.out.println(playerMatchUp.getName(playerMatchUp) + " is facing " + opponentMatchUp.getName(opponentMatchUp));
			if (i < 2){
				if (playerMatchUp.getOffence() > opponentMatchUp.getDefence()){
					playersScore++;
					System.out.println("You have scored!\nScore " + playersScore + ":" + opposingScore + "\n");

				} else {
					System.out.println("You have failed to score\n" + playerMatchUp.getName(playerMatchUp) + "has lost stamina\n");
					playerMatchUp.setStamina(playerMatchUp.getStamina() - 10);
				}
			} else {
				if (playerMatchUp.getDefence() > opponentMatchUp.getOffence()){
					System.out.println("You have successfully defended.\n");
				} else {
					opposingScore++;
					System.out.println("You have been scored on\nScore " + playersScore + ":" + opposingScore + "\n" + playerMatchUp.getName(playerMatchUp) + "has lost stamina\n");
					playerMatchUp.setStamina(playerMatchUp.getStamina() - 10);

				}
			}

		}
		
		for(Athlete ath: team.getStartingName()) {
			ath.setStamina(ath.getStamina() - 10);
		}
		
		if(playersScore > opposingScore){
			matchResult = "You Win";
		} else if(playersScore < opposingScore){
			matchResult = "You Lose";
		} else {
			matchResult = "Draw";
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