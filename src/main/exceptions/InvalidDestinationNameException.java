package main.exceptions;



@SuppressWarnings("serial")
public class InvalidDestinationNameException extends Exception{
	
	/**
	 * This is the constructor of this exception.
	 * 
	 * @param filename The filename in which the invalid destination name was found
	 * @param line The line that the invalid destination name was found
	 */
	public InvalidDestinationNameException(String filename, int line){
			
		super("Error! The name of the destination is invalid (in file " + filename + " in line: " + Integer.toString(line) + " ).");
			
	}
}
