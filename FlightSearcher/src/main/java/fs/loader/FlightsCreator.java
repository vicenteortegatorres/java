package fs.loader;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import fs.model.Flight;
import fs.model.Journey;

/*
 * Class to create flights using the input values 
 */
public class FlightsCreator {	
    /*
	 * Create a list of flights using the input values in the buffer
	 */
    public List<Flight> create(InputStream buffer) throws Exception{		
    	List<Flight> flights = new ArrayList<Flight>();	
    	BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(buffer));
			String line;
			String [] lineValues;
			while ((line = br.readLine()) != null) {
				lineValues = line.split(",");
				Flight f = new Flight(new Journey(lineValues[0], lineValues[1]), lineValues[2], new BigDecimal(lineValues[3]));
				flights.add(f);
			}        
		} catch (IOException  e) {
			throw new Exception("Problem reading the input buffer" + e.getStackTrace()); 
		} finally{ 
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	return flights;
    }
}
