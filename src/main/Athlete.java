package main;

public class Athlete {
	
	private int stamina;
	private int offence;
	private int defence;
	
	public Athlete(int defence, int offence, int stamina) {
		this.defence = defence;
		this.offence = offence;
		this.stamina = stamina;
	}
	
	public void applyItemBuff(Item item) {
		this.defence += item.getDefenceStat();
		this.offence += item.getOffenceStat();
		this.stamina += item.getStaminaStat();
	}

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
