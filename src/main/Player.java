package main;
import java.util.ArrayList;

public class Player {
	
	ArrayList<Item> inventory;
	int moneyBalance;
		
	public void useItem(Athlete athlete, Item item) {
		athlete.applyItemBuff(item);
		
	}
}
