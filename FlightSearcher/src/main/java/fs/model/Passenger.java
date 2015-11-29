package fs.model;

import java.math.BigDecimal;
import java.util.EnumMap;

/*
 * Enum with the different kind of passengers
 */
public enum Passenger {	
	ADULT {
		@Override
		public BigDecimal price(BigDecimal fligthCost, String flightShortCode){
			return fligthCost;
		}
	},
	CHILD {
		@Override
		public BigDecimal price(BigDecimal fligthCost, String flightShortCode){
			return ADULT.price(fligthCost, flightShortCode).multiply(new BigDecimal(PROPORTION_PRICE_FOR_CHILDREN));
		}
	},
	INFANT {
		@Override
		public BigDecimal price(BigDecimal fligthCost, String flightShortCode){
			return Airlines.valueOf(flightShortCode).getInfantPrice();
		}
	};
	
	private final static double PROPORTION_PRICE_FOR_CHILDREN = 0.2;
	
	/*
	 * Calculates the price for this kind of passenger
	 * 	
	 * @param flight flight which cost is calculated
	 * @param departureDate date of departure
	 */
	public abstract BigDecimal price(BigDecimal fligthCost, String flightShortCode);
	
	/*
	 * Creates an enum map with the adults, children and infants for that flight
	 * 	
	 * @param adults number of adult passengers
     * @param children number of child passengers
     * @param infants number of infant passengers
     * @return enum map with the adults, children and infants for that flight
	 */
	public static EnumMap<Passenger,Integer> passegersCreator(int adults, int children, int infants){
		EnumMap<Passenger,Integer> numberOfPassegers = new EnumMap<Passenger, Integer>(Passenger.class);
		numberOfPassegers.put(Passenger.ADULT, adults);
		numberOfPassegers.put(Passenger.CHILD, children);
		numberOfPassegers.put(Passenger.INFANT, infants);
		return numberOfPassegers;
	}

}
