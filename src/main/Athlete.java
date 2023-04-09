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
	 * Athlete Constructuer
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
	
	
	public int generatePlayerContractPrice(int defence, int attack) {
		return defence + attack;
		
	}
	
	public int generatePlayerSbPrice(int contractPrice) {
		return Math.floorDiv(contractPrice, 2);
		
	}
	
	public String generateDescription(int defence, int offence, String name) {
		return ("My name is " + name + ", my defence is " + defence + " and my attack is " + offence);

	}
	
	
	public String toString() {
		return (" Name: " + name + " Offence: " + offence + " Defense: " + defence + " Position: " + position + " Contract Price: " + contractPrice + " Sell Back Price " + sellBackPrice + " Rarity " + rarity);
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
	

	
}
