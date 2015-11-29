package fs.businessrules;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fs.model.Flight;
import fs.model.FlightSearchResult;
import fs.model.Journey;
import fs.model.Passenger;

public class FlightSearcherTest {
	private static FlightSearcher fS;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FlightCostCalculator costCalc = new DummyFlightCostCalculator();		
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight(new Journey("MAD","BCN"),"IB3223",BigDecimal.valueOf(100)));
		flights.add(new Flight(new Journey("MAD","BCN"),"IB5555",BigDecimal.valueOf(100)));
		
		fS = new FlightSearcher(flights, costCalc);
	}
	
	@Test
	public void shouldThrowsExceptionIfOriginIsNull() throws Exception {
		thrown.expectMessage(startsWith("journey is null"));
		
		fS.searchFlight(null, null, Passenger.passegersCreator(1, 0, 0));
	}
	
	@Test
	public void shouldThrowsExceptionIfDepartureDateIsNull() throws Exception {
		thrown.expectMessage(startsWith("departureDate is null"));

		fS.searchFlight(new Journey("MAD","BCN"), null, Passenger.passegersCreator(1, 0, 0));
	}
	
	@Test
	public void shouldThrowsExceptionIfNumberOfPassegersIsNull() throws Exception {
		thrown.expectMessage(startsWith("numberOfPassegers is null"));

		assertThat(fS.searchFlight(new Journey("CDG","FRA"), new Date(), null).size(), is(equalTo(0)));
	}
	
	@Test
	public void listShouldBeEmptyIfNoFlightsForThatAirports() throws Exception {

		assertThat(fS.searchFlight(new Journey("CDG","FRA"), new Date(), Passenger.passegersCreator(1, 0, 0)).size(), is(equalTo(0)));
	}
	
	@Test
	public void shouldReturnCorrectValuesWhenMADtoBCN() throws Exception {
		
		List<FlightSearchResult> fligthsResults = fS.searchFlight(new Journey("MAD","BCN"), new Date(), Passenger.passegersCreator(1, 1, 1));
		
		assertThat(fligthsResults.size(), is(equalTo(2)));
		assertThat(fligthsResults.get(0).getCode(), is(equalTo("IB3223")));
		assertThat(fligthsResults.get(0).getCost().getAmount(), is(equalTo(BigDecimal.valueOf(100.0))));
		assertThat(fligthsResults.get(1).getCode(), is(equalTo("IB5555")));
		assertThat(fligthsResults.get(1).getCost().getAmount(), is(equalTo(BigDecimal.valueOf(100.0))));
	}
}
