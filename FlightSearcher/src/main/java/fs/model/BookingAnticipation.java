package fs.model;

import java.math.BigDecimal;

/*
 * Enum with Booking anticipation ranges and the proportion of the price applied in each range according with the pricing rules
 * 
 * If days prior to the departure date:
 * - more than 30 then 80% % of the base price 
 * - 30 to 16 then 100% % of the base price 
 * - 15 to 3 then 120% % of the base price 
 * - less that 3 then 150% % of the base price 
 */
public enum BookingAnticipation {
	EARLY(31, Integer.MAX_VALUE, 0.8), 
	REGULAR(16, 30, 1), 
	LATE(3, 15, 1.2),
	VERY_LATE(0, 02 ,1.5);
	
	private final int minDays; 
	private final int maxDays;
	private final BigDecimal priceProportion;
	private BookingAnticipation(int minDays, int maxDays, double priceProportion) {
		this.minDays = minDays;
		this.maxDays = maxDays;
		this.priceProportion = BigDecimal.valueOf(priceProportion);
	}
	
	public BigDecimal getPriceProportion() {
		return priceProportion;
	}
	
	public static BookingAnticipation fromDays(int days){
		for(BookingAnticipation b : values()){
			if(b.isInRange(days)){
				return b;
			}
		}
		throw new IllegalArgumentException(days + " is not a valid anticipation.");		
	}
	
	private boolean isInRange(int days){
		return days >= minDays && days <= maxDays;
	}	
}
