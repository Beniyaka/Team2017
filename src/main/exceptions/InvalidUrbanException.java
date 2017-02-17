package main.exceptions;



@SuppressWarnings("serial")
public class InvalidUrbanException extends Exception {

	/**
	 * This is the constructor of this exception.
	 * 
	 * @param filename The filename in which the invalid urban identifier was found
	 * @param line The line that the invalid urban identifier was found
	 */
	public InvalidUrbanException (String filename, int line){
  
		super("Error! Wrong urban area (in file " + filename + " in line: " + Integer.toString(line) + " ).");
  
	}
}