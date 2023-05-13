package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameEnviroment {
	
	 private int currentWeekNum; 
	 private int playerLeaguePoints; 
	 private int difficulty; 
	 private int chosenNumWeeks; 
	 private int currentInjuryCount;
	 private boolean starterStatus;  //checks to see if the player has selected their starting team
	 private int winAmount;
	 
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

		 
		 chooseTeamName(team); // allows player to input their team name 
		 potentialPlayers.createPlayers(game.chosenNumWeeks); // calls the method to create the players
		 setPlayersStartBalance(game, player); // sets the players start balance with respect to difficulty 
		 potentialPlayers.getAllPlayers(); // makes the method add players to waiver list accessible 
		 market.addPlayerToWavier(potentialPlayers); // creates the waiver list by adding from potential players to waiver list
		 market.createItems();
		 market.goToMarket();
		 
		 market.pickInitalTeam(market, team, player); // calls the main method for the logic behind creating the initial team
		 market.pickInitalReserves(market, team, player);
		 
		 System.out.println("\n\n\n\tNow Travelling to Club ....\n\n\n");
		 System.out.println(team.getName());
		 System.out.println("\tYour starting team is: ");
		 
		 team.printFullRoster(team);
		 int chooseToMakeSub = askToMakeSub();
		 
		 	if (chooseToMakeSub == 1) {
		 		requestSub(team, market);
		 	}
	 	
	 	market.goToMarket();
	 
	 	
		 while (currentWeekNum <= chosenNumWeeks) {
			 matchSelection(game, team, player);
			 game.currentWeekNum++;
		 }
		 
		gameEnd(player);
	 }
	 
	public void gameEnd(Player player) {
		System.out.println("You have finished the game with " + winAmount + " wins and " + "$" + player.getMoneyBalance());
	}
	

	public void matchSelection(GameEnviroment game, Team team, Player player) {
		 
		 PotentialPlayers opponent = new PotentialPlayers();
		 
		 Match match = new Match();

		 ArrayList<Athlete> easyOpponent = opponent.createOpposingTeam(game, 1);
		 ArrayList<Athlete> mediumOpponent = opponent.createOpposingTeam(game, 2);
		 ArrayList<Athlete> hardOpponent = opponent.createOpposingTeam(game, 3);
		 
		 
		 ArrayList<String> opponentName = new ArrayList<String>();
		 opponentName.add("Easy");
		 opponentName.add("Medium");
		 opponentName.add("Hard");
	
		 
		 ArrayList<ArrayList<Athlete>> opponentsLeft = new ArrayList<ArrayList<Athlete>>(); 
		 
		 opponentsLeft.add(easyOpponent);
		 opponentsLeft.add(mediumOpponent);
		 opponentsLeft.add(hardOpponent);
		 

		 Scanner scanner3 = new Scanner(System.in);

		 
		 while (opponentsLeft.size() > 0) {
			 System.out.println(matchSelectionString(game, team, player, opponentsLeft));
			 
			 int i = 1;
			 for(String opp: opponentName) {

				 System.out.println("\t" + i + ". " + opp);
				 i++;
			 }
			 
			 try {
				 
				 int opponentSelection = scanner3.nextInt();
				 
				 if (opponentSelection > 0 && opponentSelection <= opponentsLeft.size()) { 
					 String result = match.matchPlay(game, player, team, opponentsLeft.get(opponentSelection-1));
					 System.out.println(result);
					 opponentsLeft.remove(opponentSelection-1);
					 opponentName.remove(opponentSelection-1);
				 } else {
					 throw new InputMismatchException();
				 }
				 
				 }
			 catch(InputMismatchException e) {
				 System.out.println("Invalid input!" + "\n");
		         scanner.nextLine();
	        
			 } 
			

		 }
	 }
	 
		 
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
		 	
		  
 	 public void requestSub(Team team, Market market) {
 		 
 		int finishedSubs = 1;
 		 
 		while (finishedSubs == 1) {
	 		System.out.println("Which player would you like to take off? ");
	 		String playerToSubString = scanner3.nextLine();
	 		
	 		System.out.println("Which player would you like to put on? ");
	 		String playerToPlayString = scanner2.nextLine();
	 		
	 		team.makeSubstituion(playerToSubString, playerToPlayString, market);
	 		
	 		team.printFullRoster(team);
	 		
	 		System.out.println("Would you like to make another Sub?");
	 		
	 		System.out.println("\tEnter 1 for YES or Enter 2 for NO ");
	 		finishedSubs = scanner.nextInt();
	 		
	 		
	 	}
 	 }
		 
	 
	 public String matchSelectionString(GameEnviroment game, Team team, Player player, ArrayList<ArrayList<Athlete>> opponentsLeft) {
		 return team.getName() + "\t" + player.getMoneyBalance() + "\t" + currentWeekNum + "/" + chosenNumWeeks + " Weeks\nType the number of the opponent you want to play: \n";
	 }
	 
	
	 
	 /**
	  * Constructor for GameEnviroment
	  */
	 public GameEnviroment() {
		 this.difficulty = chooseDifficulty(); 
		 this.chosenNumWeeks = chooseNumWeeks();
		 this.starterStatus = true;
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
				 if(name.matches("[a-zA-Z\s]+") && name.length() <= 15 && name.length() >= 3){
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

}
