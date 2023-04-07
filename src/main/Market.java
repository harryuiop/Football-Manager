package main;
import java.util.ArrayList;

public class Market {
	
	private ArrayList<Item> catalog;
	private ArrayList<Athlete> wavierList;
	
	
	/**
	 * all necessary setters and getters to the class
	 * @return
	 */
	public ArrayList<Item> getCatalog() {
		return catalog;
	}
	public void setCatalog(ArrayList<Item> catalog) {
		this.catalog = catalog;
	}
	public ArrayList<Athlete> getWavierList() {
		return wavierList;
	}
	public void setWavierList(ArrayList<Athlete> wavierList) {
		this.wavierList = wavierList;
	}
	
	
	
}
