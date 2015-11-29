package fs.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BookingAnticipationTest {
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldThrownAnExceptionIfRangeIsNotValid() throws Exception {
		thrown.expectMessage(startsWith("-10 is not a valid anticipation."));

		BookingAnticipation.fromDays(-10);
	}
	
	@Test
	public void listShouldVERYLATEif1DayBefore() throws Exception {
		BookingAnticipation bAnticipation = BookingAnticipation.fromDays(1);
		
		assertThat(bAnticipation, is(equalTo(BookingAnticipation.VERY_LATE)));
		assertThat(bAnticipation.getPriceProportion(), is(equalTo(BigDecimal.valueOf(1.5))));
	}
	
	@Test
	public void listShouldLATEif5DayBefore() throws Exception {
		BookingAnticipation bAnticipation = BookingAnticipation.fromDays(5);

		assertThat(bAnticipation, is(equalTo(BookingAnticipation.LATE)));
		assertThat(bAnticipation.getPriceProportion(), is(equalTo(BigDecimal.valueOf(1.2))));
	}
	
	@Test
	public void listShouldREGULARif16DayBefore() throws Exception {
		BookingAnticipation bAnticipation = BookingAnticipation.fromDays(16);

		assertThat(bAnticipation, is(equalTo(BookingAnticipation.REGULAR)));
		assertThat(bAnticipation.getPriceProportion(), is(equalTo(BigDecimal.valueOf(1.0))));
	}
	
	@Test
	public void listShouldEARLYif34DayBefore() throws Exception {
		BookingAnticipation bAnticipation = BookingAnticipation.fromDays(34);

		assertThat(bAnticipation, is(equalTo(BookingAnticipation.EARLY)));
		assertThat(bAnticipation.getPriceProportion(), is(equalTo(BigDecimal.valueOf(0.8))));
	}
}