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
	
	 
	 public GameEnviroment() {
		 this.difficulty = chooseDifficulty(); 
		 this.choosenNumWeeks = chooseNumWeeks();
	 }
	 
	 
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
	 public int chooseNumWeeks() throws InputMismatchException {
		 
		 boolean isInputValid = false;
		 int finalWeekHolder = 0;
		 
		 while (!isInputValid) {
		 
			 System.out.println("Choose the number of desired weeks in your season! ");
			 
			 try {
				 int weeknums = scanner.nextInt();
				 if (weeknums > 0 && weeknums < 16) {
					 finalWeekHolder = weeknums;
					 isInputValid = true;
					 System.out.println("\n" + "Your choosen season length is " + finalWeekHolder + " weeks" + "\n");
				 } else {
					 throw new InputMismatchException();
				 }
				 
			 } catch(InputMismatchException e) {
		         System.out.println("Invalid input. Please enter an integer." + "\n");
		         scanner.nextLine();
	        
			 } 
		 
		}
		 return finalWeekHolder;
	 }
	 
	 
	 /**
	  * prompts user to pick the game difficulty, if input invalid will loop.
	  * 
	  */
	 public int chooseDifficulty() {
		 
		 boolean isInputValid = false;
			 
		 while (!isInputValid) {
		 
			 System.out.println("Choose Difficulty Below " + "\n" + "\n" + "Amateur: Higher Starting Balance (Enter 1)" + "\n" + "\n" + "Pro: Lower Starting Balance (Enter 2)");
			 
			 try { 
				 int difficulty = scanner.nextInt();
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
		 
		 return difficulty;
	 }
	 
	 
	 public void startGame(GameEnviroment game) {
		 
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
