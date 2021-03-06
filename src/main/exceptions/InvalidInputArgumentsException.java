package main.exceptions;



@SuppressWarnings("serial")
public class InvalidInputArgumentsException extends Exception{

	/**
	 * This is the constructor of this exception.
	 * 
	 * @param filename The filename in which the invalid record was found
	 * @param line The line that the invalid record was found
	 */
	public InvalidInputArgumentsException(String filename, int line){
		
		super("Error! The input arguements are invalid (in file " + filename + " in line: " + Integer.toString(line) + " ).");
		
	}
}
