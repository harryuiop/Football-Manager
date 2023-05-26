package main.LOGIC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

import main.GUI.AthleteSelectionGUI;
import main.GUI.ClubGUI;
import main.GUI.GameEndGUI;
import main.GUI.MarketGUI;
import main.GUI.MatchSelectionGUI;
import main.GUI.SetupGUI;
import main.GUI.MatchGUI;


public class GameEnviroment {
	
	
	 private int currentWeekNum; 
	 private int playerLeaguePoints; 
	 private int difficulty; 
	 private int chosenNumWeeks; 
	 private boolean starterStatus;  //checks to see if the player has selected their starting team
	 private int winAmount;
	 
	
	 /**
	  * The main method to run the game, creating all the objects and making things run sequentially. 
	  * This method is call from the RunApp class
	  * @param game
	  */
	 public void startGame(GameEnviroment game) {
		 Team team = new Team(); // creates instance of the players team
		 PotentialPlayers potentialPlayers = new PotentialPlayers(); // create an instance to the player creations
		 Player player = new Player(); // creates instance of the player class
		 Market market = new Market(); // creates instance of the market class
		 currentWeekNum = 1;
		 winAmount = 0;
		 launchSetupGUI(team, game,  market, potentialPlayers, player);
	 }
	 
	 
	 /**
	  * Method to launch the Setup screen GUI
	  * @param team
	  * @param game
	  * @param market
	  * @param poplayers
	  * @param player
	  */
	 public void launchSetupGUI(Team team, GameEnviroment game, Market market, PotentialPlayers poplayers, Player player) {
		 SetupGUI setup = new SetupGUI(team, game, market, poplayers, player);
		 setup.frmSetupGUI.setVisible(true);
	 }
	 
	 
	 /**
	  * Method to close the Setup screen GUI
	  * @param team
	  * @param game
	  * @param setup
	  * @param market
	  * @param poplayers
	  * @param player
	  */
	 public void closeSetupGUI(Team team, GameEnviroment game, SetupGUI setup, Market market, PotentialPlayers poplayers, Player player){
		 setup.frmSetupGUI.dispose();
		 launchAthleteSelectionGUI(team, game, market, poplayers, player);
	 }
	 
	 
	 /**
	  * Method to launch the Athlete Selection screen GUI
	  * @param team
	  * @param game
	  * @param market
	  * @param poplayers
	  * @param player
	  */
	 public void launchAthleteSelectionGUI(Team team, GameEnviroment game, Market market, PotentialPlayers poplayers, Player player) {
		 poplayers.createPlayers(game.chosenNumWeeks); // calls the method to create the players
		 setPlayersStartBalance(game, player); // sets the players start balance with respect to difficulty 
		 poplayers.getAllPlayers(); // makes the method add players to waiver list accessible 
		 market.initalWavier(poplayers); // creates the waiver list by adding from potential players to waiver list
		 market.createItems(); 
		 AthleteSelectionGUI athsel = new AthleteSelectionGUI(team, game, market, player);
		 athsel.frmAthleteSelection.setVisible(true);
	 }
	 
	 
	 /**
	  * Method to close the Athlete Selection screen GUI
	  * @param team
	  * @param game
	  * @param athsel
	  * @param market
	  * @param player
	  */
	 public void closeAthleteSelectionGUI(Team team, GameEnviroment game, AthleteSelectionGUI athsel, Market market, Player player) {
		 athsel.frmAthleteSelection.dispose();
		 LaunchClubGUI(team, game, market, player);
	 }
	 
	 
	 /**
	  * Method to close the Club screen GUI
	  */
	 public void LaunchClubGUI(Team team, GameEnviroment game, Market market, Player player) {
		 ClubGUI club = new ClubGUI(team, game, market, player);
		 club.frmClub.setVisible(true);
	 }
	 
	 
	 /**
	  * Method to close the Club screen GUI
	  * @param clubGUI
	  */
	 public void closeClubGUI(ClubGUI clubGUI) {
		 clubGUI.frmClub.dispose();
	 }
	 
	 
	 /**
	  * Method to launch the Market screen GUI
	  * @param team 
	  * @param game
	  * @param marketobj
	  * @param player
	  */
	 public void LaunchMarketGUI(Team team, GameEnviroment game, Market marketobj, Player player) {
		 MarketGUI market = new MarketGUI(team, game, marketobj, player);
		 market.frmTheMarket.setVisible(true);
		 
	 }
	 
	 
	/**
	 * Method to launch the Match Selection screen GUI
	 * @param team
	 * @param game
	 * @param market
	 * @param player
	 * @param frmClub
	 * @param clubgui
	 * @return
	 */
	public MatchSelectionGUI LaunchMatchSelectionGUI(Team team, GameEnviroment game, Market market, Player player, JFrame frmClub, ClubGUI clubgui) {
		 MatchSelectionGUI matchSelect = new MatchSelectionGUI(team, game, market, player, frmClub, clubgui);
		 matchSelect.frmMatchSelect.setVisible(true);
		 return matchSelect;
	 }
	 
	
	/**
	 * Method to launch the Match game screen GUI
	 * @param team
	 * @param game
	 * @param player
	 * @param opposingTeam
	 * @param matchSelectionGUI
	 */
	 public void LaunchMatchGUI(Team team, GameEnviroment game, Player player, ArrayList<Athlete> opposingTeam, MatchSelectionGUI matchSelectionGUI) {
		 MatchGUI match = new MatchGUI(team, game, player, opposingTeam, matchSelectionGUI);
		 match.frmMatch.setVisible(true);
	 }
	 
	 
	 /**
	  * Method to launch the end game screen GUI
	  * @param game
	  * @param player
	  * @param team
	  */
	 	 public void LaunchGameEnd(GameEnviroment game, Player player, Team team) {
		 GameEndGUI gameEnd = new GameEndGUI(game, player, team);
		 gameEnd.frmGameEnd.setVisible(true);
	 }
	 
	 	 
	/**
	 * The game-end splash screen that prints out the player's win total and money amount
	 * @param player
	 */
	public void gameEnd(Player player) {
		System.out.println("You have finished the game with " + winAmount + " wins and " + "$" + player.getMoneyBalance());
	}
	
 
	/**
	 * Checks to see if the team name is within requirements 
	 * @param team
	 * @param name
	 * @return
	 * @throws InputMismatchException
	 */
	 public boolean chooseTeamName(Team team, String name) throws InputMismatchException {
		boolean isLegalName = false;
		 while(!isLegalName) {
			 try {
				 if(name.matches("[a-zA-Z\s]+") && name.length() <= 15 && name.length() >= 3){
					 team.setName(name);
					 isLegalName = true;
				 } else {
					 throw new InputMismatchException();
				 }

			 } catch(InputMismatchException e) {
				 return false;
			 }
		 }
		 return true;
	 }
	 	 
	 
	 /**
	  * This method sets the players start balance with respect to the game difficulty. 
	  * Amateur will start with $1000 and pro will start with $700  
	  * @param game
	  * @param player
	  */
	 public void setPlayersStartBalance(GameEnviroment game, Player player) {
		 if (game.difficulty == 1) {
			 player.setMoneyBalance(1800);
		 } else {
			 player.setMoneyBalance(1400);
		 }
	 }
	 
	 
	 /**
		 * all necessary setters and getters to the class
		 * 
		 */
	 public int getWinAmount() {
		return winAmount;
	}

	public void setWinAmount(int winAmount) {
		this.winAmount = winAmount;
	}
	 
	 public int getCurrentWeekNum() {
		return currentWeekNum;
	}
	 
	public void setCurrentWeekNum(int currentWeekNum) {
		this.currentWeekNum = currentWeekNum;
	}
	
	public int getPlayerLeaguePoints() {
		return playerLeaguePoints;
	}
	
	public void setPlayerLeaguePoints(int playerLeaguePoints) {
		this.playerLeaguePoints = playerLeaguePoints;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public int getChoosenNumWeeks() {
		return chosenNumWeeks;
	}
	
	public void setChoosenNumWeeks(int choosenNumWeeks) {
		this.chosenNumWeeks = choosenNumWeeks;
	}

	
	public boolean getStarterStatus() {
		return starterStatus;
	}
	
	public void setStarterStatus() {
		this.starterStatus = false;
	}
	
}
