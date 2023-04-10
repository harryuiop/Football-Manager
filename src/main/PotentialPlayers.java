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
	ArrayList<String> names = new ArrayList<>(Arrays.asList("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Hernandez",
			"Adams", "Anderson", "Thomas", "Jackson", "Harris", "Martin", "Thompson", "Garcia",
			"Garcia", "Robinson", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Evans")); 
	
	
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
					String name1 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(0, 40), rand.nextInt(0, 20), 1, 1, name1)); 
					
					// #Rarity: 2 #Attacker
					String name2 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(40, 70), rand.nextInt(20, 40), 1, 2, name2));

					
					// #Rarity: 3 #Attacker
					String name3 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(70, 100), rand.nextInt(40, 75), 1, 3, name3));

					
					// #Rarity: 1 #Defender
					String name4 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(0, 20), rand.nextInt(0, 40), 2, 1, name4));
					
					
					// #Rarity: 2 #Defender
					String name5 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(20, 40), rand.nextInt(40, 70), 2, 2, name5));
					
					
					// #Rarity: 3 #Defender
					String name6 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(40, 75), rand.nextInt(70, 100), 2, 3, name6));				
		}
	}
	
	
	/**
	 * This method pulls a random name from the names ArrayList then removes that said name from the list to ensure each are unique.
	 * @return
	 */
	public String nameGenerator() {
		if (names.size() > 0) {
			int index = rand.nextInt(0, names.size());
			String choosenName = names.get(index);
			names.remove(index);
			return choosenName;
		} else {
			
			return ("Ran out of names in the nameGenerator method please fix");
			
		}
	}
	
	public ArrayList<Athlete> getAllPlayerArray() {
		return allPlayers;
	}
}
