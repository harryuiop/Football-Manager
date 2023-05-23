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
	ArrayList<String> names = new ArrayList<>(Arrays.asList("Hogan", "John", "Robert", "Michael", "William",
			"David", "Richard", "Joseph", "Charles", "Thomas", "Christopher", "Daniel", "Matthew", "Anthony",
			"Donald", "Mark", "Paul", "George", "Steven", "Kenneth", "Andrew", "Edward", "Joshua", "Brian",
			"Kevin", "Ronald", "Timothy", "Jason", "Jeffrey", "Frank", "Larry", "Scott", "Eric", "Stephen",
			"Justin", "Brandon", "Gregory", "Samuel", "Benjamin", "Patrick", "Jack", "Alexander", "Tyler",
			"Zachary", "Ethan", "Noah", "Mason", "David", "Carter", "Owen", "Luke", "Adam", "Connor", "Dylan",
			"Lucas", "Adrian", "Cameron", "Nathan", "Isaac", "Isaiah", "Levi", "Jordan", "Evan", "Aaron", "Blake",
			"Cole", "Derek", "Gavin", "Jesse", "Jonah", "Kyle", "Marcus", "Oliver", "Peter", "Ryan", "Sean", "Shane",
			"Simon", "Spencer", "Theo", "Troy", "Wyatt", "Zachary", "Aidan", "Anthony", "Austin", "Brayden", "Caleb",
			"Christian", "Colin", "Cooper", "Dominic", "Donovan", "Easton", "Elliot", "Elijah", "Finn", "Gabriel",
			"Harrison", "Hunter", "Ian", "Jackson", "Jasper", "Julian", "Liam", "Mason", "Max", "Micah", "Miles",
			"Nathaniel", "Nolan", "Oscar", "Preston", "Raymond", "Roman", "Sawyer", "Silas", "Theo", "Isaac", "Ivan", 
			"Victor", "Felix", "Hugo", "Luca", "Maxime", "Maxence", "Mathis", "Louis", "Théo", "Gabriel", "Clément",
			"Jules", "Paul", "Antoine", "Augustin", "Arthur", "Romain", "Édouard", "Alexandre", "Valentin", "Pierre",
			"Félix", "Alexis", "Adrien", "Victor", "Hugo", "Eliott", "Simon", "Basile", "Quentin", "Baptiste", "Rémi",
			"Axel", "Lucas", "Noah", "Martin", "Mathéo", "Hugo", "Tom", "Clément", "Enzo", "Mathieu", "Quentin", 
			"Nicolas", "Jonathan", "Thibault", "Clément", "Jordan", "Gaëtan", "Valentin", "Kévin", "Damien",
			"Antoine", "Édouard", "Benjamin", "Morgan", "Maxime", "Alexandre", "Florian", "Nicolas", "Julien", 
			"Mathieu", "Thomas", "Anthony", "Hugo", "Maxime", "Paul", "Louis", "Antoine", "Victor", "Benjamin", 
			"Clément", "Romain", "Jules", "Julien", "Valentin", "Alexis", "Mathieu", "Lucas", "Quentin", "Pierre",
			"Théo", "Gabriel", "Adrien", "Enzo", "Tom", "Mathis", "Simon", "Rémi", "Alexandre", "Axel", "Eliott",
			"Martin", "Noah", "Basile", "Nathan", "Hugo", "Ethan", "Timéo", "Maxence", "Mathéo", "Arthur", "Arthur",
			"Mathis", "Nathan", "Tom", "Noé", "Oscar", "Yanis", "Samuel", "Léo", "Victor", "Théo", "Enzo", "Émilien",
			"Raphaël", "Maxence", "Clément", "Pierre", "Matéo"));
		
	
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
		
		for (int iteration = numWeeks*2; iteration > 0; iteration--) {
					
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
