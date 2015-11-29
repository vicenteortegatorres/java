package fs.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;

import org.junit.Test;

public class DaysTest {
	@Test
	public void shouldBe15days() throws Exception {
		Date daysBefore = Days.ago(15);
		Date today = new Date();
		
		assertThat(Days.between(today, daysBefore), is(equalTo(15)));
	}
	
	@Test
	public void dateShouldBe15daysAgo() throws Exception {
		Date today = new Date();
		
		assertThat(Days.between(today, Days.ago(15)), is(equalTo(15)));
	}
}
