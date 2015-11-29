package fs.businessrules;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import fs.businessrules.DefaultFlightCostCalculator;
import fs.model.Flight;
import fs.model.Journey;
import fs.model.Passenger;
import fs.util.Days;

public class DefaultFlightCostCalculatorTest {
	private static DefaultFlightCostCalculator fC = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fC = new DefaultFlightCostCalculator();
	}
	
	@Test
	public void shouldReturnCorrectValueWhenIsToday() throws Exception {
		Flight f = new Flight(new Journey("MAD", "BCN"), "IB1232", BigDecimal.valueOf(20));
		Date today = new Date();

		assertThat(fC.calculateCost(f, today, Passenger.passegersCreator(1, 1, 1)).getAmount(), is(equalTo(BigDecimal.valueOf(46.0))));
	}
	
	@Test
	public void shouldReturnCorrectValueWhenIs14daysAgo() throws Exception {
		Flight f = new Flight(new Journey("MAD", "BCN"), "IB1232", BigDecimal.valueOf(20));
		Date days = Days.ago(14);

		assertThat(fC.calculateCost(f, days, Passenger.passegersCreator(1, 1, 1)).getAmount(), is(equalTo(BigDecimal.valueOf(38.8))));
	}
	
	@Test
	public void shouldReturnCorrectValueWhenIs37daysAgo() throws Exception {
		Flight f = new Flight(new Journey("MAD", "BCN"), "IB1232", BigDecimal.valueOf(20));
		Date days = Days.ago(37);

		assertThat(fC.calculateCost(f, days, Passenger.passegersCreator(1, 1, 1)).getAmount(), is(equalTo(BigDecimal.valueOf(29.2))));
	}
}
