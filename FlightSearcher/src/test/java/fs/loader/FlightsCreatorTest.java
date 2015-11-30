package fs.loader;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.Test;

import fs.loader.FlightsCreator;
import fs.model.Flight;

public class FlightsCreatorTest {
	@Test
	public void listShouldBeEmptyIfEmpty() throws Exception {
		InputStream is = new ByteArrayInputStream("".getBytes());
				
		assertThat(new FlightsCreator().create(is).size(), is(equalTo(0)));
	}
	
	@Test
	public void listShoulReturnCorrectValuesIfBufferHasFligths() throws Exception {
		InputStream is = new ByteArrayInputStream("CPH,FRA,IB2818,186".getBytes());
		List<Flight> flights = new FlightsCreator().create(is);
		
		assertThat(flights.size(), is(equalTo(1)));		
		assertThat(flights.get(0).getJourney().getOriginAirport(), is(equalTo("CPH")));
		assertThat(flights.get(0).getJourney().getDestinationAirport(), is(equalTo("FRA")));
		assertThat(flights.get(0).getCode(), is(equalTo("IB2818")));
		assertThat(flights.get(0).getCost(), is(equalTo(new BigDecimal(186))));

	}
}
