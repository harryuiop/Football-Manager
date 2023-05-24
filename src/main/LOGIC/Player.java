package main.LOGIC;
import java.util.ArrayList;

public class Player {
	
	private ArrayList<Item> inventory = new ArrayList<Item>();
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
	 * Add item to players inventory
	 * @param item
	 */
	public void addItemToInventory(Item item) {
		inventory.add(item);
	}
	
	
	/**
	 * removes item from inventory and updates players balance
	 * @param item
	 * @param index
	 */
	public void sellItem(Item item, int index) {
		int price = item.getSellBackPriceprivate();
		setMoneyBalance(getMoneyBalance() + price); 
		removeItem(index);
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
		return moneyBalance; // test
	}
	public void setMoneyBalance(int moneyBalance) {
		this.moneyBalance = moneyBalance;
	}
	public void removeItem(int index) {
		this.inventory.remove(index);
	}
	
}
