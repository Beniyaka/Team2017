package main.category;




public class Journey {

	private String taxiRegistrationNumber; //Taxi`s registration number
	private int destinationID; //Destination`s ID
	private int numberOfPassengers; //Number of passengers
	private double time; //Journey`s total duration
	private double maximumVelocity; //Journey`s maximum velocity

	
	public Journey(int destinationID, String taxiRegistrationNumber, 
			int numberOfPassengers, double time, double maximumVelocity){
			
		this.destinationID = destinationID;
		this.taxiRegistrationNumber = taxiRegistrationNumber;
		this.numberOfPassengers = numberOfPassengers;
		this.time = time;
		this.maximumVelocity = maximumVelocity;
		
	}
}
