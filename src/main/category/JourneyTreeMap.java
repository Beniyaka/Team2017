package main.category;

import java.util.ArrayList;
import java.util.TreeMap;



public class JourneyTreeMap {
	
	private TreeMap<String, ArrayList<Journey>> journeys; //The TreeMap that contains all the journeys
	
	public JourneyTreeMap(TreeMap<String, ArrayList<Journey>> journeys){
		
		this.journeys = journeys;
		
	}
	
}