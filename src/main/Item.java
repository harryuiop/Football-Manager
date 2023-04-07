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

	public String getItemAtributes() {
		return itemAtributes;
	}

	public void setItemAtributes(String itemAtributes) {
		this.itemAtributes = itemAtributes;
	}

	public String getRarity() {
		return Rarity;
	}

	public void setRarity(String rarity) {
		Rarity = rarity;
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
