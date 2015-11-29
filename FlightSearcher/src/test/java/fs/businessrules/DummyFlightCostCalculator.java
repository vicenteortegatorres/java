package fs.businessrules;

import java.math.BigDecimal;
import java.util.Date;
import java.util.EnumMap;

import fs.model.Flight;
import fs.model.Money;
import fs.model.Passenger;

/*
 * Dummy implementation of FlightCostCalculator to be used in the FlightCostCalculator unit tests
 */
public class DummyFlightCostCalculator implements FlightCostCalculator {
	//Always returns 100 euros as flight cost
	public Money calculateCost(Flight flight, Date departureDate,
			EnumMap<Passenger, Integer> numberOfPassegers) {
		return new Money(BigDecimal.valueOf(100));
	}
}
