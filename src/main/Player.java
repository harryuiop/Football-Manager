package main;
import java.util.ArrayList;

public class Player {
	
	private ArrayList<Item> inventory;
	private int moneyBalance;
	
	/**
	 * invokes the use item method from a specific item in players inventory
	 * @param athlete
	 * @param item
	 */
	public void useItem(Athlete athlete, Item item) {
		athlete.applyItemBuff(item);
		
	}

	
	/**
	 * all necessary setters and getters to the class
	 * @return
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	public int getMoneyBalance() {
		return moneyBalance;
	}
	public void setMoneyBalance(int moneyBalance) {
		this.moneyBalance = moneyBalance;
	}
	
	
}
