package main;

public class Athlete {
	
	private int stamina;
	private int offence;
	private int defence;
	
	/**
	 * Athlete Constructor
	 * @param defence
	 * @param offence
	 * @param stamina
	 */
	public Athlete(int defence, int offence, int stamina) {
		this.defence = defence;
		this.offence = offence;
		this.stamina = stamina;
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
