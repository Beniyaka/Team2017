package main.category;

import java.util.TreeMap;


public class TaxiTreeMap {
	
	private TreeMap<String, Taxi> taxis; //The TreeMap that contains the taxis

	public TaxiTreeMap(TreeMap<String, Taxi> taxis){
		
		this.taxis = taxis;
		
	}
}
