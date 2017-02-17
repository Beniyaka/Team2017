package main.exceptions;



@SuppressWarnings("serial")
public class InvalidNumberOfPassengersException extends Exception{

	/**
	 * This is the constructor of this exception.
	 * 
	 * @param filename The filename in which the invalid number of passengers was found
	 * @param line The line that the invalid number of passengers was found
	 */
	public InvalidNumberOfPassengersException(String filename, int line){
		
		super("Error! The number of passengers is not correct (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
	
}
