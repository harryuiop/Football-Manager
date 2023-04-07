package main;

public class Item {
	
	 private String itemAtributes; 
	 private String Rarity;
	 private int sellBackPriceprivate ;
	 private int contractPrice;
	 private String description;
	 private int offenceIncrease;
	 private int defenceIncrease;
	 private int staminaIncrease;
	 
	 
	public Item(int defenceIncrease, int offenceIncrease, int staminaIncrease) {
		this.offenceIncrease = offenceIncrease;
		this.defenceIncrease = defenceIncrease;
		this.staminaIncrease = staminaIncrease;
	}

	public int getOffenceStat() {
		 return this.offenceIncrease;
	 }
	 
	 public int getDefenceStat() {
		 return this.defenceIncrease;
	 }
	 
	 public int getStaminaStat() {
		 return this.staminaIncrease;
	 }
	 
	 
	
}
