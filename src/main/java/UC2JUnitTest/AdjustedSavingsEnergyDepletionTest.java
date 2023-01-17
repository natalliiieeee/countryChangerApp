package UC2JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import statBuilder.AdjustedSavingsEnergyDepletion;

public class AdjustedSavingsEnergyDepletionTest {

	@Test
	public void test1() {
		AdjustedSavingsEnergyDepletion testObj = new AdjustedSavingsEnergyDepletion("Brazil");
		assertEquals("\"Adjusted savings: energy depletion (current US$)\"", testObj.getIndicatorName());
	}
	@Test
	public void test2() {
		AdjustedSavingsEnergyDepletion testObj = new AdjustedSavingsEnergyDepletion("Brazil");
		assertEquals("\"US$\"", testObj.getUnit());
	}
	@Test
	public void test3() {
		AdjustedSavingsEnergyDepletion testObj = new AdjustedSavingsEnergyDepletion("Brazil");
		assertEquals("30288056.0692624", testObj.getStat().getAsJsonPrimitive("1970").getAsNumber().toString());
	}

}
