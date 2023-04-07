package main;
import java.util.Scanner;

public class GameEnviroment {
	
	 public int currentWeekNum; 
	 public int playerLeaguePoints; 
	 public int difficulty; 
	 public int choosenNumGames; 
	 public int currentInjuryCount;
	 
	 Scanner scanner = new Scanner(System.in);
	
	 public void chooseTeamName(Team team) {
		 
		 System.out.println("Choose your team name! :");
		 String name = scanner.nextLine();
		 team.setName(name);
	 }
	
	 public static void main(String[] args) {
		 GameEnviroment game = new GameEnviroment();
		 Team team = new Team();
		 game.chooseTeamName(team);
		 
	 }
		 

}
