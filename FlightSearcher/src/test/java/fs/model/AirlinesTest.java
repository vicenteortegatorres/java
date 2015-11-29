package fs.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class AirlinesTest {
	@Test
	public void IBshouldBe10() throws Exception {
		
		assertThat(Airlines.IB.getInfantPrice(), is(equalTo(BigDecimal.valueOf(10.0))));
	}
	
	@Test
	public void BAshouldBe15() throws Exception {
		
		assertThat(Airlines.BA.getInfantPrice(), is(equalTo(BigDecimal.valueOf(15.0))));
	}
	
	@Test
	public void LHshouldBe7() throws Exception {
		
		assertThat(Airlines.LH.getInfantPrice(), is(equalTo(BigDecimal.valueOf(7.0))));
	}
	
	@Test
	public void FRshouldBe20() throws Exception {
		
		assertThat(Airlines.FR.getInfantPrice(), is(equalTo(BigDecimal.valueOf(20.0))));
	}
	
	@Test
	public void VYshouldBe10() throws Exception {
		
		assertThat(Airlines.VY.getInfantPrice(), is(equalTo(BigDecimal.valueOf(10.0))));
	}
	
	@Test
	public void TKshouldBe5() throws Exception {
		
		assertThat(Airlines.TK.getInfantPrice(), is(equalTo(BigDecimal.valueOf(5.0))));
	}
	
	@Test
	public void U2YshouldBe1990() throws Exception {
		
		assertThat(Airlines.U2.getInfantPrice(), is(equalTo(BigDecimal.valueOf(19.90))));
	}
}
