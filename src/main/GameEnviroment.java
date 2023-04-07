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
	 * creates a scanner method to invoke the Scanner Class to use user inputs
	 */
	 Scanner scanner = new Scanner(System.in);
	
	 
	/**
	 * prompts user to pick a team name then users setter in Team Class
	 * @param team
	 */
	 public void chooseTeamName(Team team) {
		 
		 System.out.println("Choose your team name! ");
		 String name = scanner.nextLine();
		 team.setName(name);
		 System.out.println("\n" + "Your choosen team name is " + team.getName() + "\n");
	 }
	 
	 
	 /**
	  * prompts user to pick the number of weeks desired in their season, if input invalid will loop.
	  * @param game
	  */
	 public void chooseNumWeeks(GameEnviroment game) {
		 
		 boolean isInputValid = false;
		 
		 while (!isInputValid) {
		 
			 System.out.println("Choose the number of desired weeks in your season! ");
			 
			 try {
				 int weeknums = scanner.nextInt();
				 game.setChoosenNumWeeks(weeknums);
				 isInputValid = true;
				 System.out.println("\n" + "Your choosen season length is " + game.choosenNumWeeks + " weeks" + "\n");
				 
			 } catch(InputMismatchException e) {
		         System.out.println("Invalid input. Please enter an integer." + "\n");
		         scanner.nextLine();
	        
			 } 
		 } 
	 }
	 
	 
	 /**
	  * prompts user to pick the game difficulty, if input invalid will loop.
	  * @param game
	  */
	 public void chooseDifficulty(GameEnviroment game) {
		 
		 boolean isInputValid = false;
			 
		 while (!isInputValid) {
		 
			 System.out.println("Choose Difficulty Below " + "\n" + "\n" + "Amateur: Higher Starting Balance (Enter 1)" + "\n" + "\n" + "Pro: Lower Starting Balance (Enter 2)" );
			 
			 try { 
				 int difficulty = scanner.nextInt();
				 game.setDifficulty(difficulty);
				 isInputValid = true;
				 
				 if (difficulty == 1) {
				 System.out.println("\n" + "Your choosen game difficulty is Amateur");
				 } else {
				 System.out.println("\n" + "Your choosen game difficulty is Pro");
				 }
				 
			 } catch(InputMismatchException e) {
				 System.out.println("Invalid input. Please enter an integer." + "\n");
		         scanner.nextLine();
	        
			 } 
		 } 
	 }
		 
		 
	 
	 
	 /**
		 * all necessary setters and getters to the class
		 * @return
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
	

	public static void main(String[] args) {
		 
		 GameEnviroment game = new GameEnviroment();
		 Team team = new Team();
		 Market market = new Market();
		 Player player = new Player();
		 
		 game.chooseTeamName(team);
		 game.chooseNumWeeks(game);
		 game.chooseDifficulty(game);
	 }
		 

}
