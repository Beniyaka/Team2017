package main.exceptions;



@SuppressWarnings("serial")
public class InvalidDistanceException extends Exception{

	/**
	 * This is the constructor of this exception.
	 * 
	 * @param filename The filename in which the invalid distance was found
	 * @param line The line that the invalid distance was found
	 */
	public InvalidDistanceException(String filename, int line){
		
		super("Error! The distance is not in the correct range (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
}
