package fs.businessrules;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import fs.businessrules.DefaultFlightCostCalculator;
import fs.businessrules.FlightCostCalculator;
import fs.businessrules.FlightSearcher;
import fs.loader.FlightsCreator;
import fs.model.Flight;
import fs.model.FlightSearchResult;
import fs.model.Journey;
import fs.model.Passenger;
import fs.util.Days;

public class FlightSearcherIntegrationTest {	
	/*
	 * File name that contains flight test values for testing
	 */
	private static final String FLIGHTS_FILE_NAME = "Flights.csv";	
	
	private static FlightSearcher fS;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FlightCostCalculator costCalc = new DefaultFlightCostCalculator();		
		List<Flight> flights = new FlightsCreator()
			.create(new BufferedInputStream(new FileInputStream(FLIGHTS_FILE_NAME)));
		
		fS = new FlightSearcher(flights, costCalc);
	}
	
	@Test
	public void correctValuesWhenIsSearchAMStoFRA() throws Exception {
		List<FlightSearchResult> fligthsResults = fS.searchFlight(new Journey("AMS","FRA"), Days.ago(32), Passenger.passegersCreator(1, 0, 0));	
		
		assertThat(fligthsResults.size(), is(equalTo(3)));
		assertThat(fligthsResults.get(0).getCode(), is(equalTo("TK2372")));
		assertThat(fligthsResults.get(0).getCost().getAmount(), is(equalTo(BigDecimal.valueOf(157.6))));
		assertThat(fligthsResults.get(1).getCode(), is(equalTo("TK2659")));
		assertThat(fligthsResults.get(1).getCost().getAmount(), is(equalTo(BigDecimal.valueOf(198.4))));
		assertThat(fligthsResults.get(2).getCode(), is(equalTo("LH5909")));
		assertThat(fligthsResults.get(2).getCost().getAmount(), is(equalTo(BigDecimal.valueOf(90.4))));

	}
	
	@Test
	public void correctValuesWhenIsSearchLHRtoIST() throws Exception {
		List<FlightSearchResult> fligthsResults = fS.searchFlight(new Journey("LHR","IST"), Days.ago(15), Passenger.passegersCreator(2, 1, 1));	
		
		assertThat(fligthsResults.size(), is(equalTo(2)));
		assertThat(fligthsResults.get(0).getCode(), is(equalTo("TK8891")));
		assertThat(fligthsResults.get(0).getCost().getAmount(), is(equalTo(BigDecimal.valueOf(665.0))));
		assertThat(fligthsResults.get(1).getCode(), is(equalTo("LH1085")));
		assertThat(fligthsResults.get(1).getCost().getAmount(), is(equalTo(BigDecimal.valueOf(397.7))));
	}
	
	@Test
	public void correctValuesWhenIsSearchBCNtoMAD() throws Exception {
		List<FlightSearchResult> fligthsResults = fS.searchFlight(new Journey("BCN","MAD"), Days.ago(2), Passenger.passegersCreator(1, 2, 0));	
		
		assertThat(fligthsResults.size(), is(equalTo(2)));
		assertThat(fligthsResults.get(0).getCode(), is(equalTo("IB2171")));
		assertThat(fligthsResults.get(0).getCost().getAmount(), is(equalTo(BigDecimal.valueOf(543.9))));
		assertThat(fligthsResults.get(1).getCode(), is(equalTo("LH5496")));
		assertThat(fligthsResults.get(1).getCost().getAmount(), is(equalTo(BigDecimal.valueOf(615.3))));
	}
	
	@Test
	public void correctValuesWhenIsSearchMADtoBCN() throws Exception {
		List<FlightSearchResult> fligthsResults = fS.searchFlight(new Journey("MAD","BCN"), Days.ago(7), Passenger.passegersCreator(1, 1, 1));	
		
		assertThat(fligthsResults.size(), is(equalTo(1)));
		assertThat(fligthsResults.get(0).getCode(), is(equalTo("BA9569")));
		assertThat(fligthsResults.get(0).getCost().getAmount(), is(equalTo(BigDecimal.valueOf(349.0))));
	}
}
