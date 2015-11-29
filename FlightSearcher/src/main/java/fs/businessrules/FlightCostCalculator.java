package fs.businessrules;

import java.util.Date;
import java.util.EnumMap;

import fs.model.Flight;
import fs.model.Money;
import fs.model.Passenger;

public interface FlightCostCalculator {
	public Money calculateCost(Flight flight, Date departureDate, EnumMap<Passenger, Integer> numberOfPassegers);
}