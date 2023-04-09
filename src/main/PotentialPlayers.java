package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PotentialPlayers {
	
	private ArrayList<Athlete> allPlayers;
	private ArrayList<Athlete> PlayersTeam;
	ArrayList<String> names = new ArrayList<>(Arrays.asList("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Hernandez",
															"Adams", "Anderson", "Thomas", "Jackson", "Harris", "Martin", "Thompson", "Garcia",
															"Garcia", "Robinson", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Evans"));
	
	
	Random rand = new Random();
	
	
	public void createPlayers() {	
				
		for (int iteration = 0; iteration < names.size(); iteration++) {
					
			
					// #Rarity: 1 #Attacker
					String name1 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(0, 40), rand.nextInt(0, 20), 1, 1, name1)); 
					
					// #Rarity: 2 #Attacker
					String name2 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(40, 70), rand.nextInt(20, 40), 1, 1, name2));

					
					// #Rarity: 3 #Attacker
					String name3 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(70, 100), rand.nextInt(40, 75), 1, 1, name3));

					
					// #Rarity: 1 #Defender
					String name4 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(0, 20), rand.nextInt(0, 40), 1, 1, name4));
					
					
					// #Rarity: 2 #Defender
					String name5 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(20, 40), rand.nextInt(40, 70), 1, 1, name5));
					
					
					// #Rarity: 3 #Defender
					String name6 = nameGenerator();
					allPlayers.add(new Athlete(rand.nextInt(40, 75), rand.nextInt(70, 100), 1, 1, name6));
						
		}
		
	}
	

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
	
	public static void main(String[] args) {
		PotentialPlayers test = new PotentialPlayers();
		String holder = test.nameGenerator();
		
		System.out.println(holder);
	}
}
