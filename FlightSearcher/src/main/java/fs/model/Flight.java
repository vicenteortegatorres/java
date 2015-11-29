package fs.model;
import java.math.BigDecimal;

/*
 * Immutable class to store Flight properties
 */
public class Flight {
	private final Journey journey;
	private final String code;
	private final BigDecimal cost;
	
	public Flight(Journey journey, String code, BigDecimal cost){
		this.journey = journey;
		this.code = code;
		this.cost = cost;
	}
	
	/*
	 * Return flights journey
	 */
	public Journey getJourney(){
		return journey;
	}
	
	/*
	 * Return flights code
	 */
	public String getCode(){
		return code;
	}
	
	/*
	 * Return flight's cost
	 */
	public BigDecimal getCost(){
		return cost;
	}
	
	/*
	 * Return flight's short code
	 */
	public String getShortCode(){
		return code.substring(0, 2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((journey == null) ? 0 : journey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (journey == null) {
			if (other.journey != null)
				return false;
		} else if (!journey.equals(other.journey))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Flight [journey=" + journey + ", code=" + code + ", cost="
				+ cost + "]";
	}
}
