package main.exceptions;



@SuppressWarnings("serial")
public class InvalidMaximumVelocityException extends Exception{

	/**
	 * This is the constructor of this exception.
	 * 
	 * @param filename The filename in which the invalid velocity was found
	 * @param line The line that the invalid velocity was found
	 */
	public InvalidMaximumVelocityException(String filename, int line){
		
		super("Error! The maximum velocity is not in the correct range"
				+ " (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
	
}
