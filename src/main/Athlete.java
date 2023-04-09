package main;

public class Athlete {
	
	private String name;
	private int stamina;
	private int offence;
	private int defence;
	private int position;
	private int contractPrice;
	private int sellBackPrice;
	private String description;
	private int rarity;
	
	/**
	 * Athlete Constructor
	 * @param defence
	 * @param offence
	 * @param stamina
	 */
	public Athlete(int offence, int defence, int position, int rarity, String name) {
		
		this.name = name;
		this.offence = offence;
		this.defence = defence;
		this.position = position;
		this.contractPrice = generatePlayerContractPrice(defence, offence);
		this.sellBackPrice = generatePlayerSbPrice(contractPrice);
		this.description = generateDescription(defence, offence, name);
		this.rarity = rarity;
	}
	
	
	public int generatePlayerContractPrice(int defence, int attack) {
		return defence + attack;
		
	}
	
	public int generatePlayerSbPrice(int contractPrice) {
		return Math.floorDiv(contractPrice, 3/4);
		
	}
	
	public String generateDescription(int defence, int offence, String name) {
		return ("My name is " + name + ", my defence is " + defence + " and my attack is " + offence);

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
	 *		  2 - for defenders, 60 than 80 defending
	 *		      for attackers, 60 than 80 attacking
	 *		  
	 *		  3 - for defenders, 60 to 100
	 *		      for attackers, 60 to 100
	 * 		
	 */

	
	
}
