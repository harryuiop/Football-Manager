package main;

public class Item {
	
	 private String name;
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private String itemAtributes; 
	 private int rarity;
	 private int sellBackPriceprivate ;
	 private int itemPrice;
	 private String description;
	 private int offenceIncrease;
	 private int defenceIncrease;
	 private int staminaIncrease;
	 
	/**
	 * Constructor for Item Class 
	 * @param defenceIncrease
	 * @param offenceIncrease
	 * @param staminaIncrease
	 */
	public Item(String name, int defenceIncrease, int offenceIncrease, int staminaIncrease, int rarity, int contractPrice) {
		this.offenceIncrease = offenceIncrease;
		this.defenceIncrease = defenceIncrease;
		this.staminaIncrease = staminaIncrease;
		this.itemPrice = contractPrice;
		this.name = name;
		this.rarity = rarity;
	}
	
	public String toString() {
		return getName() + "\n"; 
	}
	
	public String printForSelection() {
		return ("<html>" + name
				+ "<br><blockquote>\tOff Increase: " + offenceIncrease 
				+ "<br>Def Increase: " + defenceIncrease 
				+ "<br>Price: $" + itemPrice 
				+ "<br>Rarity: " + rarity
				+"</blockquote></html>");
	}

	
	/**
	 * all necessary setters and getters to the class
	 * @return
	 */
	public int getOffenceStat() {
		 return this.offenceIncrease;
	 } 
	 public int getDefenceStat() {
		 return this.defenceIncrease;
	}
	 public int getStaminaStat() {
		 return this.staminaIncrease;
	}
	public String getItemAtributes() {
		return itemAtributes;
	}
	public void setItemAtributes(String itemAtributes) {
		this.itemAtributes = itemAtributes;
	}
	public int getRarity() {
		return this.rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public int getSellBackPriceprivate() {
		return sellBackPriceprivate;
	}
	public void setSellBackPriceprivate(int sellBackPriceprivate) {
		this.sellBackPriceprivate = sellBackPriceprivate;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	 
	
}
