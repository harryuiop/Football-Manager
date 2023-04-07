package main;
import java.util.ArrayList;

public class Player {
	
	private ArrayList<Item> inventory;
	private int moneyBalance;
	
	public void useItem(Athlete athlete, Item item) {
		athlete.applyItemBuff(item);
		
	}

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
