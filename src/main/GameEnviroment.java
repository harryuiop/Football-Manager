package main;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameEnviroment {
	
	 private int currentWeekNum; 
	 private int playerLeaguePoints; 
	 private int difficulty; 
	 private int choosenNumWeeks; 
	 private int currentInjuryCount;
	 
	 
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
		 
		 chooseTeamName(team); // allows player to input their team name 
		 potentialPlayers.createPlayers(game.choosenNumWeeks); // calls the method to create the players
		 setPlayersStartBalance(game, player); // sets the players start balance with respect to difficulty 
		 potentialPlayers.getAllPlayerArray(); // makes the method add players to waiver list accessible 
		 market.addPlayerToWavier(potentialPlayers); // creates the waiver list by adding from potential players to waiver list
		 market.pickInitalTeam(market, team, player); // calls the main method for the logic behind creating the initial team
	 }
	 
	 
	/**
	 * creates a scanner method to invoke the Scanner Class to use user inputs
	 */
	 Scanner scanner = new Scanner(System.in);
	
	 
	 /**
	  * Constructor for GameEnviroment
	  */
	 public GameEnviroment() {
		 this.difficulty = chooseDifficulty(); 
		 this.choosenNumWeeks = chooseNumWeeks();
	 }
	 
	 
	/**
	 * prompts user to pick a team name then users setter in Team Class
	 * @param team
	 */
	 public void chooseTeamName(Team team) throws InputMismatchException {
		 
		 boolean isLegalName = false;
		 
		 Scanner scanner2 = new Scanner(System.in);
		 
		 while(!isLegalName) {
			 System.out.println("Choose your team name! \n");
			 try {
				 String name = scanner2.nextLine();
				 if(name.matches("[a-zA-Z]+") && name.length() <= 15 && name.length() >= 3){
					 team.setName(name);
					 isLegalName = true;
				 } else {
					 throw new InputMismatchException();
				 }

			 } catch(InputMismatchException e) {
				 System.out.println("Name has to be between 3-15 characters long and only regular letters" + "\n");
			 }
		 }

		 System.out.println("\n\t" + "Your choosen team name is " + team.getName() + "\n");
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
			 player.setMoneyBalance(600);
		 } else {
			 player.setMoneyBalance(400);
		 }
	 }
	 
	 
	 /**
		 * all necessary setters and getters to the class
		 * 
		 */
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
		return choosenNumWeeks;
	}
	public void setChoosenNumWeeks(int choosenNumWeeks) {
		this.choosenNumWeeks = choosenNumWeeks;
	}
	public int getCurrentInjuryCount() {
		return currentInjuryCount;
	}
	public void setCurrentInjuryCount(int currentInjuryCount) {
		this.currentInjuryCount = currentInjuryCount;
	}
	

}
