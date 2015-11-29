package fs.model;

import java.math.BigDecimal;

/*
 * Enum with Airlines and its infantPrices
 */
public enum Airlines {
	IB(10.0), 
	BA(15.0),
	LH(7.0), 
	FR(20.0),
	VY(10.0), 
	TK(5.0),
	U2(19.9);
	
	private final BigDecimal infantPrice; 
	private Airlines(Double infantPrice) {
		this.infantPrice = BigDecimal.valueOf(infantPrice);
	}
	
	public BigDecimal getInfantPrice() {
		return infantPrice;
	}
}

