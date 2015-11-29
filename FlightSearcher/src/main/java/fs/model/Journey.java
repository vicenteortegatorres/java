package fs.model;

/*
 * Immutable class to store origin and destination of a journey
 */
public class Journey {
	private final String originAirport;
	private final String  destinationAirport;
	public Journey(String originAirport, String  destinationAirport){
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;		
	}
	
	public String getOriginAirport() {
		return originAirport;
	}
	
	public String getDestinationAirport() {
		return destinationAirport;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destinationAirport == null) ? 0 : destinationAirport.hashCode());
		result = prime * result + ((originAirport == null) ? 0 : originAirport.hashCode());
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
		Journey other = (Journey) obj;
		if (destinationAirport == null) {
			if (other.destinationAirport != null)
				return false;
		} else if (!destinationAirport.equals(other.destinationAirport))
			return false;
		if (originAirport == null) {
			if (other.originAirport != null)
				return false;
		} else if (!originAirport.equals(other.originAirport))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return originAirport + " to " + destinationAirport;
	}
}
