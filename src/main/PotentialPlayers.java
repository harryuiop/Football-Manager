package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PotentialPlayers {
	
	
	private ArrayList<Athlete> allPlayers = new ArrayList<Athlete>();
	private ArrayList<Athlete> PlayersTeam = new ArrayList<Athlete>();
	
	
	/**
	 * Hard coded names for the generateName() method to pull names from
	 */
	ArrayList<String> first_names = new ArrayList<>(Arrays.asList("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Hernandez",
			"Adams", "Anderson", "Thomas", "Jackson", "Harris", "Martin", "Thompson", "Garcia",
			"Garcia", "Robinson", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Evans")); 
	
	ArrayList<String> last_names = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X" ,"Y", "Z"));
	
	
	/**
	 * Creating an instance of Random
	 */
	Random rand = new Random();
	
	
	/**
	 * This creates a pool of all the needed players for the game and adds them to a single ArrayList called allPlayers
	 * 
	 * # Still to implement on this method
	 * 		this still needs to be able to create the "correct" amount of players based on how many teams are in the season.
	 */
	public void createPlayers(int numWeeks) {	
		
		for (int iteration = numWeeks; iteration > 0; iteration--) {
					
					//The format of the add method is = Offense (Integer), Defense (Integer), Position (Integer), Rarity (Integer), Name (String).
			
			
					// #Rarity: 1 #Attacker
					allPlayers.add(new Athlete(rand.nextInt(0, 40), rand.nextInt(0, 20), 1, 1, nameGenerator())); 
					
					
					// #Rarity: 2 #Attacker
					allPlayers.add(new Athlete(rand.nextInt(40, 70), rand.nextInt(20, 40), 1, 2, nameGenerator()));

					
					// #Rarity: 3 #Attacker
					allPlayers.add(new Athlete(rand.nextInt(70, 100), rand.nextInt(40, 75), 1, 3, nameGenerator()));

					
					// #Rarity: 1 #Defender
					allPlayers.add(new Athlete(rand.nextInt(0, 20), rand.nextInt(0, 40), 2, 1, nameGenerator()));
					
					
					// #Rarity: 2 #Defender
					allPlayers.add(new Athlete(rand.nextInt(20, 40), rand.nextInt(40, 70), 2, 2, nameGenerator()));
					
					
					// #Rarity: 3 #Defender
					allPlayers.add(new Athlete(rand.nextInt(40, 75), rand.nextInt(70, 100), 2, 3, nameGenerator()));				
		}
	}
	
	
	/**
	 * 
	 */
	public ArrayList<Athlete> createOpposingTeam(GameEnviroment game, int level) {
		
		
		ArrayList<Athlete> opposingTeam = new ArrayList<Athlete>();
		
		switch (level) {
		
			case 1:
				
				// #Rarity: 1 #Attacker
				opposingTeam.add(new Athlete(rand.nextInt(0, 40), rand.nextInt(0, 20), 1, 2, nameGenerator()));
				
				// #Rarity: 1 #Attacker
				opposingTeam.add(new Athlete(rand.nextInt(0, 40), rand.nextInt(0, 20), 1, 3, nameGenerator()));
				
				// #Rarity: 1 #Defender
				opposingTeam.add(new Athlete(rand.nextInt(0, 20), rand.nextInt(0, 40), 2, 1, nameGenerator()));
			
				// #Rarity: 1 #Defender
				opposingTeam.add(new Athlete(rand.nextInt(0, 20), rand.nextInt(0, 40), 2, 2, nameGenerator()));
				
				// #Rarity: 1 #Defender
				opposingTeam.add(new Athlete(rand.nextInt(0, 20), rand.nextInt(0, 40), 2, 1, nameGenerator()));
				
				break;
				
			case 2:
				
				// #Rarity: 1 #Attacker
				opposingTeam.add(new Athlete(rand.nextInt(40, 70), rand.nextInt(20, 40), 1, 2, nameGenerator()));
				
				// #Rarity: 1 #Attacker
				opposingTeam.add(new Athlete(rand.nextInt(70, 100), rand.nextInt(40, 75), 1, 3, nameGenerator()));
				
				// #Rarity: 1 #Defender
				opposingTeam.add(new Athlete(rand.nextInt(0, 20), rand.nextInt(0, 40), 2, 1, nameGenerator()));
			
				// #Rarity: 1 #Defender
				opposingTeam.add(new Athlete(rand.nextInt(20, 40), rand.nextInt(40, 70), 2, 2, nameGenerator()));
				
				// #Rarity: 1 #Defender
				opposingTeam.add(new Athlete(rand.nextInt(0, 20), rand.nextInt(0, 40), 2, 1, nameGenerator()));
				
				break;
				
			case 3:
				
				// #Rarity: 1 #Attacker
				opposingTeam.add(new Athlete(rand.nextInt(40, 70), rand.nextInt(20, 40), 1, 2, nameGenerator()));
				
				// #Rarity: 1 #Attacker
				opposingTeam.add(new Athlete(rand.nextInt(70, 100), rand.nextInt(40, 75), 1, 3, nameGenerator()));
				
				// #Rarity: 1 #Defender
				opposingTeam.add(new Athlete(rand.nextInt(0, 20), rand.nextInt(0, 40), 2, 1, nameGenerator()));
			
				// #Rarity: 1 #Defender
				opposingTeam.add(new Athlete(rand.nextInt(20, 40), rand.nextInt(40, 70), 2, 2, nameGenerator()));
				
				// #Rarity: 1 #Defender
				opposingTeam.add(new Athlete(rand.nextInt(0, 20), rand.nextInt(0, 40), 2, 1, nameGenerator()));
				
				break;
		
		}
		return opposingTeam;
	}
	
	
	
	/**
	 * This method pulls a random name from the names ArrayList then removes that said name from the list to ensure each are unique.
	 * @return
	 */
	public String nameGenerator() {
		int first_index = rand.nextInt(0, first_names.size());
		int last_index = rand.nextInt(0, last_names.size());
		String choosenName = first_names.get(first_index) + " " + last_names.get(last_index);
		
		return choosenName;
	}
	
	public ArrayList<Athlete> getAllPlayerArray() {
		return allPlayers;
	}
}
