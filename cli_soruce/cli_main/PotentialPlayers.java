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
	ArrayList<String> names = new ArrayList<>(Arrays.asList("hogan", "john", "robert", "michael", "william", "david",
			"richard", "joseph", "charles", "thomas", "christopher", "daniel", "matthew", "anthony", "donald", "mark",
			"paul", "george", "steven", "kenneth", "andrew", "edward", "joshua", "brian", "kevin", "ronald", "timothy", 
			"jason", "jeffrey", "frank", "larry", "scott", "eric", "stephen", "justin", "brandon", "gregory", "samuel",
			"benjamin", "patrick", "jack", "alexander", "tyler", "zachary", "ethan", "noah", "mason", "david", "carter",
			"owen", "luke", "adam", "connor", "dylan", "lucas", "adrian", "cameron", "nathan", "isaac", "isaiah", "levi",
			"jordan", "evan", "aaron", "blake", "cole", "derek", "gavin", "jesse", "jonah", "kyle", "marcus", "oliver",
			"peter", "ryan", "sean", "shane", "simon", "spencer", "theo", "troy", "wyatt", "zachary", "aidan", "anthony",
			"austin", "brayden", "caleb", "christian", "colin", "cooper", "dominic", "donovan", "easton", "elliot",
			"elijah", "finn", "gabriel", "harrison", "hunter", "ian", "jackson"));
		
	
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
		if (names.size() > 0) {
			int index = rand.nextInt(0, names.size());
			String choosenName = names.get(index);
			names.remove(index);
			return choosenName;
		} else {
			
			return ("Ran out of names in the nameGenerator method please fix");
			
		}
	}


	public ArrayList<Athlete> getAllPlayers() {
		return allPlayers;
	}


	public void setAllPlayers(ArrayList<Athlete> allPlayers) {
		this.allPlayers = allPlayers;
	}

}
