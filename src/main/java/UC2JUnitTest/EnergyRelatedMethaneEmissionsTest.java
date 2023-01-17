package UC2JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import statBuilder.EnergyRelatedMethaneEmissions;

public class EnergyRelatedMethaneEmissionsTest {

	@Test
	public void test1() {
		EnergyRelatedMethaneEmissions testObj = new EnergyRelatedMethaneEmissions("Brazil");
		assertEquals("\"Energy related methane emissions (% of total)\"", testObj.getIndicatorName());
	}
	@Test
	public void test2() {
		EnergyRelatedMethaneEmissions testObj = new EnergyRelatedMethaneEmissions("Brazil");
		assertEquals("\"%\"", testObj.getUnit());
	}
	@Test
	public void test3() {
		EnergyRelatedMethaneEmissions testObj = new EnergyRelatedMethaneEmissions("Brazil");
		assertEquals("8.512244654326587", testObj.getStat().getAsJsonPrimitive("1971").getAsNumber().toString());
	}


}
