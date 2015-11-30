package fs.businessrules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fs.model.Flight;
import fs.model.FlightSearchResult;
import fs.model.Journey;
import fs.model.Passenger;

public class FlightSearcher {
	/*
	 * Flights store in a map with Journey as key. Each Journey has a list of its lists
	 */
	private final Map<Journey,List<Flight>> flightsPerJourney;	
	
	/*
	 * Flight cost calculator
	 */
	private final FlightCostCalculator costCalculation;
	
	/*
	 * Flights, airports and airlines are initialized in the constructor
	 */
	public FlightSearcher(List<Flight> flights, FlightCostCalculator flightCostCalculator) {
		this.flightsPerJourney = new HashMap<Journey,List<Flight>>();
		//Flights are stored using Journey as key
		for(Flight flight : flights){
			List<Flight> flightList = this.flightsPerJourney.get(flight.getJourney());
			if(flightList == null){
				flightsPerJourney.put(flight.getJourney(), new ArrayList<Flight>(Arrays.asList(new Flight[]{flight})));
			} else {
				flightList.add(flight);
				flightsPerJourney.put(flight.getJourney(), flightList);
			}
		}
		this.costCalculation = flightCostCalculator;	
	}
	
	/*
	 * Return list of flights available between the given airports, the given date returning cost of every flight found
	 * 
	 * @param journey journey of this flight
     * @param departure date of departure
     * @param adults number of adult passengers
     * @param childs number of child passengers
     * @param infants number of infant passengers
     * @return list of flight codes and costs that match with the input criteria
	 */
	public List<FlightSearchResult> searchFlight(Journey journey, Date departureDate, EnumMap<Passenger, Integer> numberOfPassegers) throws Exception {
		if(journey == null){
			throw new NullPointerException("journey is null");
		}	
		if(departureDate == null){
			throw new NullPointerException("departureDate is null");
		}
		if(numberOfPassegers == null){
			throw new NullPointerException("numberOfPassegers is null");
		}
		List<FlightSearchResult> flightResults = new ArrayList<FlightSearchResult>();
		List<Flight> flights = flightsPerJourney.get(journey);
		if(flights != null){
			for(Flight flight: flights){
				flightResults.add(new FlightSearchResult(flight.getCode(), costCalculation.calculateCost(flight, departureDate, numberOfPassegers)));
			}
		}
		return flightResults;
	}
}
