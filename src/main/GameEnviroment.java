package main;
import java.util.Scanner;

public class GameEnviroment {
	
	 public int currentWeekNum; 
	 public int playerLeaguePoints; 
	 public int difficulty; 
	 public int choosenNumGames; 
	 public int currentInjuryCount;
	 
	 
	/**
	 * creates a scanner method to invoke the Scanner Class to use user inputs
	 */
	 Scanner scanner = new Scanner(System.in);
	
	 
	/**
	 * prompts user to pick a team name then users setter in Team Class
	 * @param team
	 */
	 public void chooseTeamName(Team team) {
		 
		 System.out.println("Choose your team name! :");
		 String name = scanner.nextLine();
		 team.setName(name);
	 }
	
	 
	 public static void main(String[] args) {
		 
		 GameEnviroment game = new GameEnviroment();
		 Team team = new Team();
		 Market market = new Market();
		 Player player = new Player();
		 
		 game.chooseTeamName(team);
		 System.out.println(team.getName());
	 }
		 

}
