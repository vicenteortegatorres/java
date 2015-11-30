package fs.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class AirlinesTest {
	@Test
	public void IBshouldReturnInfantPriceEqualsAs10() throws Exception {
		
		assertThat(Airlines.IB.getInfantPrice(), is(equalTo(BigDecimal.valueOf(10.0))));
	}
	
	@Test
	public void BAshouldReturnInfantPriceEqualsAs15() throws Exception {
		
		assertThat(Airlines.BA.getInfantPrice(), is(equalTo(BigDecimal.valueOf(15.0))));
	}
	
	@Test
	public void LHshouldReturnInfantPriceEqualsAs7() throws Exception {
		
		assertThat(Airlines.LH.getInfantPrice(), is(equalTo(BigDecimal.valueOf(7.0))));
	}
	
	@Test
	public void FRshouldReturnInfantPriceEqualsAs20() throws Exception {
		
		assertThat(Airlines.FR.getInfantPrice(), is(equalTo(BigDecimal.valueOf(20.0))));
	}
	
	@Test
	public void VYshouldReturnInfantPriceEqualsAs10() throws Exception {
		
		assertThat(Airlines.VY.getInfantPrice(), is(equalTo(BigDecimal.valueOf(10.0))));
	}
	
	@Test
	public void TKshouldReturnInfantPriceEqualsAs5() throws Exception {
		
		assertThat(Airlines.TK.getInfantPrice(), is(equalTo(BigDecimal.valueOf(5.0))));
	}
	
	@Test
	public void ReturnInfantPriceEqualsAs() throws Exception {
		
		assertThat(Airlines.U2.getInfantPrice(), is(equalTo(BigDecimal.valueOf(19.90))));
	}
}
