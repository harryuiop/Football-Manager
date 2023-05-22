package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

public class GameEnviroment {
	
	 private int currentWeekNum; 
	 private int playerLeaguePoints; 
	 private int difficulty; 
	 private int chosenNumWeeks; 
	 private int currentInjuryCount;
	 private boolean starterStatus;  //checks to see if the player has selected their starting team
	 private int winAmount;
	 private int weeklyWinAmount;
	 
	 /**
		 * 	  creates a scanner method to invoke the Scanner Class to use user inputs
		 */
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Scanner scanner3 = new Scanner(System.in);

	
	
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
		 weeklyWinAmount = 0;
		 winAmount = 0;
		 
		 launchSetupGUI(team, game,  market, potentialPlayers, player);
		 
		 //market.pickInitalTeam(market, team, player); // calls the main method for the logic behind creating the initial team
		 //market.pickInitalReserves(market, team, player);
		 		 
		 //int chooseToMakeSub = askToMakeSub();
		 
		 	//if (chooseToMakeSub == 1) {
		 		//equestSub(team, market);
		 	//}
	 	
	 	//market.goToMarket(player);
	 
	 	//Main game-loop which sends the player to match selection which loops until the last week is hit
//		 while (currentWeekNum <= chosenNumWeeks) {
//			 matchSelection(game, team, player, market); //Game Selection screen 
//			 game.currentWeekNum++; //Go to the next week
//		 }
//		gameEnd(player);
	 }
	 
	 
	 public void launchSetupGUI(Team team, GameEnviroment game, Market market, PotentialPlayers poplayers, Player player) {
		 SetupGUI setup = new SetupGUI(team, game, market, poplayers, player);
		 setup.frmSetupGUI.setVisible(true);
	 }
	 
	 public void closeSetupGUI(Team team, GameEnviroment game, SetupGUI setup, Market market, PotentialPlayers poplayers, Player player){
		 setup.frmSetupGUI.dispose();
		 launchAthleteSelectionGUI(team, game, market, poplayers, player);
	 }
	 
	 public void launchAthleteSelectionGUI(Team team, GameEnviroment game, Market market, PotentialPlayers poplayers, Player player) {
		 poplayers.createPlayers(game.chosenNumWeeks); // calls the method to create the players
		 setPlayersStartBalance(game, player); // sets the players start balance with respect to difficulty 
		 poplayers.getAllPlayers(); // makes the method add players to waiver list accessible 
		 
		 market.initalWavier(poplayers); // creates the waiver list by adding from potential players to waiver list

		 
		 market.createItems(); 

	
		 
		 AthleteSelectionGUI athsel = new AthleteSelectionGUI(team, game, market, player);
		 athsel.frmAthleteSelection.setVisible(true);
	 }
	 
	 public void closeAthleteSelectionGUI(Team team, GameEnviroment game, AthleteSelectionGUI athsel, Market market, Player player) {
		 athsel.frmAthleteSelection.dispose();
		 LaunchClubGUI(team, game, market, player);
		 
	 }
	 
	 public void LaunchClubGUI(Team team, GameEnviroment game, Market market, Player player) {
		 ClubGUI club = new ClubGUI(team, game, market, player);
		 club.frmClub.setVisible(true);
		 
	 }
	 
	 public void closeClubGUI(ClubGUI clubGUI) {
		 clubGUI.frmClub.dispose();
	 }
	 
	 public void LaunchMarketGUI(Team team, GameEnviroment game, Market marketobj, Player player) {
		 MarketGUI market = new MarketGUI(team, game, marketobj, player);
		 market.frmTheMarket.setVisible(true);
		 
	 }

	public MatchSelectionGUI LaunchMatchSelectionGUI(Team team, GameEnviroment game, Market market, Player player, JFrame frmClub, ClubGUI clubgui) {
		 MatchSelectionGUI matchSelect = new MatchSelectionGUI(team, game, market, player, frmClub, clubgui);
		 matchSelect.frmMatchSelect.setVisible(true);
		 return matchSelect;
	 }
	 
	 public void LaunchMatchGUI(Team team, GameEnviroment game, Player player, ArrayList<Athlete> opposingTeam, MatchSelectionGUI matchSelectionGUI) {
		 MatchGUI match = new MatchGUI(team, game, player, opposingTeam, matchSelectionGUI);
		 match.frmMatch.setVisible(true);
	 }
	 
	 	 public void LaunchGameEnd(GameEnviroment game, Player player) {
		 GameEndGUI gameEnd = new GameEndGUI(game, player);
		 gameEnd.frmGameEnd.setVisible(true);
	 }
	 


	 
	 
	 
	/**
	 * The game-end splash screen that prints out the players' win total and money amount
	 * @param player
	 */
	public void gameEnd(Player player) {
		System.out.println("You have finished the game with " + winAmount + " wins and " + "$" + player.getMoneyBalance());
	}
	
	//String splash for the match selection
	 public String matchSelectionString(GameEnviroment game, Team team, Player player, ArrayList<ArrayList<Athlete>> opponentsLeft) {
		 return team.getName() + "\t" + player.getMoneyBalance() + "\t" + currentWeekNum + "/" + chosenNumWeeks + " Weeks\nType the number of the opponent you want to play: \n";
	 }
	
	
	/**
	 * Function is called to allow the player to select a match between three opponents. Function is stopped when the 3 opponents have been played.
	 * @param game
	 * @param team
	 * @param player
	 */
	
	 
		 
	 public int askToMakeSub() {
		 boolean isInputValid = false;
		 int yesOrNo = 0;
		 while (!isInputValid) {
			 
			 System.out.println("Would you like to make substituions?\n\n Enter 1 for YES or Enter 2 for NO ");
			 
			 try {
				 int chooseToMakeSub = scanner.nextInt();
				 if (chooseToMakeSub == 1) {
					 isInputValid = true;
					 yesOrNo = 1;
				 } else if (chooseToMakeSub == 2) {
					 isInputValid = true;
					 yesOrNo = 2;
				 } else {
					 throw new InputMismatchException();
				 }
				 
			 } catch(InputMismatchException e) {
				 System.out.println("Invalid input. Please enter 1 or 2." + "\n");
				 scanner.nextLine();
			 }  
		 }
		 
		 return yesOrNo;
	 }
		 	
	
	 		
	 	

	 
	/**
	 * prompts user to pick a team name then users setter in Team Class
	 * @param team
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
	  * prompts user to pick the number of weeks desired in their season, if input invalid will loop.
	  * @param game
	  */
	 public int chooseNumWeeks() throws InputMismatchException {
		 
		 boolean isInputValid = false;
		 int finalWeekHolder = 0;
		 
		 while (!isInputValid) {
		 
			 System.out.println("Choose your season length (5-15 weeks) \n");
			 
			 try {
				 int weeknums = scanner.nextInt();
				 if (weeknums >= 5 && weeknums <= 15) {
					 finalWeekHolder = weeknums;
					 isInputValid = true;
					 System.out.println("\n\t" + "Your choosen season length is " + finalWeekHolder + " weeks" + "\n");
				 } else {
					 throw new InputMismatchException();
				 }
				 
			 } catch(InputMismatchException e) {
		         System.out.println("Invalid input. Please enter a valid integer." + "\n");
		         scanner.nextLine();
	        
			 } 
		 
		}
		 return finalWeekHolder;
	 }
	 
	 
	 /**
	  * prompts user to pick the game difficulty, if input invalid will loop.
	  * 
	  */
	 public int chooseDifficulty() throws InputMismatchException {
		 
		 boolean isInputValid = false;
			 
		 while (!isInputValid) {
		 
			 System.out.println("Choose Difficulty Below " + "\n\t" + "Amateur: Higher Starting Balance (Enter 1)" + "\n\t" + "Pro: Lower Starting Balance (Enter 2)" + "\n");
			 
			 try { 
				 int difficulty = scanner.nextInt();
				 
				 if (difficulty == 1) {
				 System.out.println("\n\t" + "Your choosen game difficulty is Amateur\n");
				 isInputValid = true;
				 } 
				 
				 else if (difficulty == 2) {
				 System.out.println("\n\t" + "Your choosen game difficulty is Pro\n");
				 isInputValid = true;
				 }

				 
			 } catch(InputMismatchException e) {
				 System.out.println("Invalid input. Please enter an integer." + "\n");
		         scanner.nextLine();
	        
			 } 
		 }
		 
		 return difficulty;
	 }
	 
	 
	 /**
	  * This method sets the players start balance with respect to the game difficulty. 
	  * Amateur will start with $1000 and pro will start with $700  
	  * @param game
	  * @param player
	  */
	 public void setPlayersStartBalance(GameEnviroment game, Player player) {
		 if (game.difficulty == 1) {
			 player.setMoneyBalance(6000);
		 } else {
			 player.setMoneyBalance(4000);
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
	public int getCurrentInjuryCount() {
		return currentInjuryCount;
	}
	public void setCurrentInjuryCount(int currentInjuryCount) {
		this.currentInjuryCount = currentInjuryCount;
	}
	public boolean getStarterStatus() {
		return starterStatus;
	}
	public void setStarterStatus() {
		this.starterStatus = false;
	}
	public int getWeeklyWinAmount() {
		return weeklyWinAmount;
	}
	public void setWeeklyAmount(int win) {
		this.weeklyWinAmount = win;
	}

}
