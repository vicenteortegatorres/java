package fs.businessrules;

import java.util.Date;
import java.util.EnumMap;
import java.math.BigDecimal;

import fs.model.BookingAnticipation;
import fs.model.Flight;
import fs.model.Money;
import fs.util.Days;
import fs.model.Passenger;

/*
 * Class used to calculate the cost of a flight
 */
public class DefaultFlightCostCalculator implements FlightCostCalculator {
	/*
	 * Calculates the cost of the flight for that date according with the pricing rules
	 * 	
	 * @param flight flight which cost is calculated
	 * @param departureDate date of departure
     *
	 */
	private BigDecimal fligthCostAccordingPricingRules(Flight flight, Date departureDate) {
		int daysTillDepartureDate = Days.between(new Date(), departureDate);
		return flight.getCost().multiply(BookingAnticipation.fromDays(daysTillDepartureDate).getPriceProportion());
	}
	
	/*
	 * Calculates the cost of the flight for that departure date and number of adults, children, infants
	 *  
     * @param flight flight which cost is calculated
     * @param departureDate date of departure
     * @param numberOfPassegers number of adult, child and infant passengers
     * @return list of flight codes and costs that match with the input criteria
	 */
	public Money calculateCost(Flight flight, Date departureDate, EnumMap<Passenger, Integer> numberOfPassegers){
		BigDecimal fligthCost = fligthCostAccordingPricingRules(flight, departureDate);
		BigDecimal totalFligthCost = BigDecimal.ZERO;
		for(Passenger passenger: Passenger.values()){
			totalFligthCost = totalFligthCost.add(BigDecimal.valueOf(numberOfPassegers.get(passenger)).multiply(passenger.price(fligthCost, flight.getShortCode())));
		}	
		return new Money(totalFligthCost);
	}
	
	
}
