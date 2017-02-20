package main.exceptions;


@SuppressWarnings("serial")
public class DuplicateIDException extends Exception {

	/**
	 * This is the constructor of this exception.
	 * 
	 * @param filename The filename in which the duplicate id was found
	 * @param line The line that the duplicate id was found
	 */
	public DuplicateIDException(String filename, int line){
		
		super("Error! Duplicate item ID (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
	 
	
}
