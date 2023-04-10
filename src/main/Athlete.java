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
	 * @param offence
	 * @param defence
	 * @param position
	 * @param rarity
	 * @param name
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
	
	
	/**
	 * this method calculates the Athlete contract price for the Athlete Constructor.
	 * @param defence
	 * @param attack
	 * @return
	 */
	public int generatePlayerContractPrice(int defence, int attack) {
		return defence + attack;
	}
	
	
	/**
	 * this method calculates the Athlete Sell Back price for the Athlete Constructor.
	 *  
	 *  #NOT FINAL FORMULA 
	 *  
	 * @param contractPrice
	 * @return
	 */
	public int generatePlayerSbPrice(int contractPrice) {
		return Math.floorDiv(contractPrice, 2);
	}
	
	
	/**
	 * This method is a constructor for the description of each player object
	 * @param defence
	 * @param offence
	 * @param name
	 * @return
	 */
	public String generateDescription(int defence, int offence, String name) {
		return ("My name is " + name + ", my defence is " + defence + " and my attack is " + offence);
	}
	
	
	/**
	 * toString method to be able to print objects with human readable value
	 */
	public String toString() {
		return (name + "\n\tOffence: " + offence + "\n\tDefense: " + defence + "\n\tPosition: " + position + "\n\tContract Price: $" + contractPrice + "\n\tSell Back Price $" + sellBackPrice + "\n\tRarity " + rarity);
	}
		
	
	/**
	 * this method sets the statistics after being calling from in the player class
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
	
	public String getName(Athlete ath) {
		return ath.name;
	}
	
	public int getContractPrice(Athlete ath) {
		return ath.contractPrice;
	}

	
}
