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
	 private int contractPrice;
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
		this.contractPrice = contractPrice;
		this.name = name;
		this.rarity = rarity;
	}
	
	public String toString() {
		return (name + "\n\tOffence Increase: " + offenceIncrease + "\n\tDefense Increase: " + defenceIncrease + "\n\tPrice: $" + contractPrice + "\n\tRarity: " + rarity);
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
		return rarity;
	}
	public void setRarity(int rarity) {
		rarity = rarity;
	}
	public int getSellBackPriceprivate() {
		return sellBackPriceprivate;
	}
	public void setSellBackPriceprivate(int sellBackPriceprivate) {
		this.sellBackPriceprivate = sellBackPriceprivate;
	}
	public int getContractPrice() {
		return contractPrice;
	}
	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	 
	
}
