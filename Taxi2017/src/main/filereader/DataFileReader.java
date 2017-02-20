package main.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import main.exceptions.InvalidBrandNameException;
import main.exceptions.InvalidIDException;
import main.exceptions.InvalidInputArgumentsException;
import main.exceptions.InvalidMaximumVelocityException;
import main.exceptions.InvalidNumberOfPassengersException;
import main.exceptions.InvalidRegistrationNumberException;
import main.exceptions.InvalidTaxiNameException;
import main.exceptions.InvalidTimeException;
import main.category.*;
/**
 * 
 * @author Beni Iyaka
 * 
 * DataFileReader is a public class that reads the data from three files
 * <taxis.txt>, <journeys.txt>, and <destination.txt>, 
 * then checks if the file is in the wright format, checks if those values exist (not empty),
 * make some converts and finally store them to the appropriate data structure. 
 **/

public class DataFileReader {
 
	public static final String DATA_SEPERATOR = ",";
	public static final String FILE_NAME_FOLDER = "inputFiles/";
	public static final String FILE_NAME_JOURNEYS = "journeys.txt";
	public static final String FILE_NAME_TAXIS = "taxis.txt";
	public static final String FILE_NAME_DESTINATIONS = "destination.txt";
	public static int line_counter = 0;

	
	/**
	 * loadJourney read the <journey.txt> file, checks its structure as to the number of words 
	 * separated by DATA_SEPERATOR (instance variable), then checks if those words are not empty,
	 * and after some converts use Journey's constructor for each valid line and add this
	 * journey object to a TreeMap. 
	 * 
	 * @return an object of JourneyTreeMap, which is a TreeMap of all journeys.  
	 */
	public JourneyTreeMap loadJourney() {


		TreeMap<String,ArrayList<Journey>> temporaryTreeMap = new TreeMap<>();
		JourneyTreeMap journeyTreeMap = new JourneyTreeMap(temporaryTreeMap);


		FileReader fd_journeys = null;

		int id = 0;
		int numOfPassengers = 0;
		double time = 0.0;
		double maxVelocity = 0.0;

		try {

			// Open the file that contains the journeys. 
			fd_journeys = new FileReader( FILE_NAME_FOLDER + FILE_NAME_JOURNEYS );
			BufferedReader journey_reader = new BufferedReader(fd_journeys);

			String line;
			String[] journey_info;
			line_counter = 0;		// Initializes the line counter. 

			// Read it line-by-line
			while ((line = journey_reader.readLine()) != null) {

				line_counter++;		// specify the line of the file
				journey_info = line.split(DATA_SEPERATOR, -1);		// split the line using the given separator

				try {

					if( journey_info.length != 5 ){		// check if this line has exactly five words
														// if not throw an exception
						
						throw new InvalidInputArgumentsException(FILE_NAME_JOURNEYS, line_counter);
					}

					// Then check if any of those five words are an empty string
					// and if this happens  for any of those strings, throw the appropriate exception
					
					if ( journey_info[0].isEmpty() || journey_info[0].length() == 0 || journey_info[0] == null ) {

						throw new InvalidIDException( FILE_NAME_DESTINATION, line_counter );
					}
					
					id = Integer.parseInt( journey_info[0] );		// Converts Journey's id to integer.


					if ( journey_info[1].trim().isEmpty() || journey_info[1].trim().length() == 0 || journey_info[1] == null ) {

						throw new InvalidRegistrationNumberException(FILE_NAME_TAXIS, line_counter);
					}


					if ( journey_info[2].isEmpty() || journey_info[2].length() == 0 || journey_info[2] == null ) {

						throw new InvalidNumberOfPassengersException( FILE_NAME_DESTINATION, line_counter );
					}

					numOfPassengers = Integer.parseInt( journey_info[2] );		// Converts Number of Passenger of this journey to integer.



					if ( journey_info[3].trim().isEmpty() || journey_info[3].trim().length() == 0 || journey_info[3].trim() == null ) {

						throw new InvalidTimeException( FILE_NAME_DESTINATION, line_counter );
					}

					time = Double.parseDouble(journey_info[3]);		// Converts the time needed for this journey to double.



					if ( journey_info[4].trim().isEmpty() || journey_info[4].trim().length() == 0 || journey_info[4].trim() == null ) {

						throw new InvalidMaximumVelocityException( FILE_NAME_DESTINATION, line_counter );
					}

					maxVelocity = Double.parseDouble(journey_info[4]);		// Converts maximum velocity of this journey to double.



					// Creates a Journey Object 
					Journey jrn = new Journey( id, journey_info[1], numOfPassengers, time, maxVelocity );



					if ( jrn != null ) {	// if the object has been created normally

						
						journeyTreeMap.addJourney(jrn);		// add this Journey to the JourneyTreeMap
															// -- which is a TreeMap of ArrayLists of Journey's objects --
															// using the addJourney public method of the
															// JourneyTreeMap class.					
					}


				} catch ( InvalidInputArgumentsException | InvalidIDException | InvalidMaximumVelocityException |
						  InvalidRegistrationNumberException | InvalidTimeException | InvalidNumberOfPassengersException | NumberFormatException e ) {

					System.out.println(e.getMessage());

				} catch (ArrayIndexOutOfBoundsException e){

					System.out.println("\t --Reading process in file " + FILE_NAME_JOURNEYS + " failed... [ " + e.getMessage() + " ]." );

				}

			}

		} catch (IOException e) {

			System.out.println("\t --File: " + FILE_NAME_JOURNEYS + " failed to open. [ " + e.getMessage() + " ].");
		}
		finally {

			try {
					
				fd_journeys.close();	// Close the file reader.

			} catch (IOException e) {

				System.out.println( "\t --File: " + FILE_NAME_JOURNEYS + " failed to close. [ " + e.getMessage() + " ]." );

			}
		}


		return journeyTreeMap;
	}

	/**
	 * loadTaxis read the <taxis.txt> file, checks its structure as to the number of words 
	 * separated by DATA_SEPERATOR (instance variable), then checks if those words are not empty,
	 * and for each valid line add this taxi object to a taxiTreeMap.
	 *  
	 * @return an object of taxiTreeMap, which is a TreeMap of all taxis.  
	 */
	public TaxiTreeMap loadTaxis() {



		TreeMap<String,Taxi> temporaryTreeMap = new TreeMap<>();
		TaxiTreeMap taxiTreeMap = new TaxiTreeMap(temporaryTreeMap);

		FileReader fd_taxis = null;

		try {

			// Open the file that contains the taxis. 
			fd_taxis = new FileReader(FILE_NAME_FOLDER + FILE_NAME_TAXIS);
			BufferedReader taxis_reader = new BufferedReader(fd_taxis);

			String line;
			String[] taxi_info;
			String [] nameComponents;
			line_counter = 0;		// Initializes the line counter. 

			// Read it line-by-line
			while ((line = taxis_reader.readLine()) != null) {

				line_counter++;		// specify the line of the file
				taxi_info = line.split(DATA_SEPERATOR, -1);		// split the line using the given separator.
				nameComponents = taxi_info[1].split(" ");		// slit the driver's name (first name, last name).

				try {

					if(taxi_info.length != 3){		// check if this line has exactly three words
													// if not throw an exception

						throw new InvalidInputArgumentsException(FILE_NAME_TAXIS, line_counter);
					}

					// Then check if any of those three words are an empty string
					// and if this happens for any of those strings, throw the appropriate exception
					
					if (taxi_info[0].trim().isEmpty() || taxi_info[0].trim().length() == 0 || taxi_info[0] == null) {

						throw new InvalidRegistrationNumberException(FILE_NAME_TAXIS, line_counter);
					}

					if (taxi_info[1].isEmpty() || taxi_info[1].length() == 0 || taxi_info[1] == null || nameComponents[0].length() == 0 || nameComponents[1].length() == 0 ) {

						throw new InvalidTaxiNameException(FILE_NAME_TAXIS, line_counter);
					}

					if (taxi_info[2].trim().isEmpty() || taxi_info[2].trim().length() == 0 || taxi_info[2] == null) {

						throw new InvalidBrandNameException(FILE_NAME_TAXIS, line_counter);
					}


					// Creates a Taxi Object 
					Taxi tx = new Taxi(taxi_info[0].trim(), taxi_info[1], taxi_info[2].trim());

					
					if ( tx != null ) {		// if the object has been created normally

						taxiTreeMap.addTaxi(tx);	// add this Taxi to the TaxiTreeMap
													// -- which is a TreeMap of Taxi's objects --
													// using the addTaxi public method of the
													// TaxiTreeMap class.
						
					}


				} catch ( InvalidRegistrationNumberException | InvalidTaxiNameException | InvalidBrandNameException | InvalidInputArgumentsException e ) {

					System.out.println("\t --File: " + FILE_NAME_TAXIS + " failed to open. [ " + e.getMessage() + " ].");

				} catch (ArrayIndexOutOfBoundsException e){

					System.out.println("\t --Reading process in file " + FILE_NAME_TAXIS + " failed... [ " + e.getMessage() + " ]." );

				}

			}

		} catch (IOException e) {

			System.out.println("\t --File: " + FILE_NAME_TAXIS + " failed to open. [ " + e.getMessage() + " ].");

		}
		finally {

			try {

				fd_taxis.close();		// Close the file descriptor. 

			} catch (IOException e) {

				System.out.println("\t --File: " + FILE_NAME_TAXIS + " failed to close. [ " + e.getMessage() + " ].");

			}
		}

		return taxiTreeMap;
	}


}