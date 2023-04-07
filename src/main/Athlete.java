package main;

enum Position {
	Attacker,
	Defender
}

public class Athlete {
	
	private int stamina;
	private int offence;
	private int defence;
	private int Position;
	private int contractPrice;
	private int sellBackPrice;
	private String description;
	private int Rarity;
	
	/**
	 * Athlete Constructor
	 * @param defence
	 * @param offence
	 * @param stamina
	 */
	public Athlete(int stamina, int offence, int defence, int position, int contractPrice, int sellBackPrice,
			String description, int rarity) {
		
		this.stamina = stamina;
		this.offence = offence;
		this.defence = defence;
		Position = position;
		this.contractPrice = contractPrice;
		this.sellBackPrice = sellBackPrice;
		this.description = description;
		this.Rarity = rarity;
	}

	
	/**
	 * this method sets the stats after being calling from in the player class
	 * @param item
	 */
	public void applyItemBuff(Item item) {
		this.defence += item.getDefenceStat();
		this.offence += item.getOffenceStat();
		this.stamina += item.getStaminaStat();
	}
	
	
	/**
	 * all necessary setters and getters to the class
	 * @return
	 */
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getOffence() {
		return offence;
	}
	public void setOffence(int offence) {
		this.offence = offence;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	/**
	 * This holds the object creation of all possible athlete within the league
	 * 
	 * Attacker is held as an Int for simplicity.   1 = Attacker     2 = Defender
	 * 
	 * Rarity is set from 1 - 3. 1 being the most common. 3 being the most rare
	 * 
	 * Rarity stat breakdown
	 * 		  1 - for defenders, no more than 40 defending
	 * 			  for attackers, no more than 40 attacking
	 * 
	 *		  2 - for defenders, no more than 80 defending
	 *		      for attackers, no more than 80 attacking
	 *		  
	 *		  3 - for defenders, no limit
	 *		      for attackers, no limit
	 * 		
	 * 		
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Athlete Ben = new Athlete(100, 60, 20, 1, 100, 90, "This", 1);
		Athlete Sam = new Athlete(100, 60, 20, 1, 100, 90, "is", 2);
		Athlete Harry = new Athlete(100, 60, 20, 1, 100, 90, "just", 3);
		Athlete Pat = new Athlete(100, 60, 20, 1, 100, 90, "for", 1);
		Athlete Liam = new Athlete(100, 60, 20, 1, 100, 90, "testing", 2);
		Athlete Callum = new Athlete(100, 60, 20, 2, 100, 90, "prupose", 3);
		Athlete Te = new Athlete(100, 60, 20, 2, 100, 90, "will", 2);
		Athlete Connell = new Athlete(100, 60, 20, 2, 100, 90, "change", 2);
		Athlete Marcus = new Athlete(100, 60, 20, 2, 100, 90, "this", 1);
		Athlete James = new Athlete(100, 60, 20, 2, 100, 90, "later", 3);
	}
	
	
	
}
