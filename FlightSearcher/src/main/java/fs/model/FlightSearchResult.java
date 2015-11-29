package fs.model;

/*
 * Immutable class to store result of a flight search
 */
public class FlightSearchResult {
	private final String code;
	private final Money money;
	
	public FlightSearchResult(String code, Money money){
		this.code = code;
		this.money = money;
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
	public Money getCost(){
		return money;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
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
		FlightSearchResult other = (FlightSearchResult) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Flight " + code + " which cost is " + money;
	}
}
