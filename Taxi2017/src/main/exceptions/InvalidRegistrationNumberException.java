package main.exceptions;




@SuppressWarnings("serial")
public class InvalidRegistrationNumberException extends Exception{

	/**
	 * This is the constructor of this exception.
	 * 
	 * @param filename The filename in which the invalid registration number was found
	 * @param line The line that the invalid registration number was found
	 */
	public InvalidRegistrationNumberException(String filename, int line){
		
		super("Error! Wrong registration number (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
	
}
