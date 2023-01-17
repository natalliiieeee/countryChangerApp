package UC2JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import statBuilder.MethaneEmissionsInEnergySector;

public class MethaneEmissionsInEnergySectorTest {

	@Test
	public void test1() {
		MethaneEmissionsInEnergySector testObj = new MethaneEmissionsInEnergySector("Brazil");
		assertEquals("\"Methane emissions in energy sector (thousand metric tons of CO2 equivalent)\"", testObj.getIndicatorName());
	}
	@Test
	public void test2() {
		MethaneEmissionsInEnergySector testObj = new MethaneEmissionsInEnergySector("Brazil");
		assertEquals("\"thousand metric tons\"", testObj.getUnit());
	}
	@Test
	public void test3() {
		MethaneEmissionsInEnergySector testObj = new MethaneEmissionsInEnergySector("Brazil");
		assertEquals("10710", testObj.getStat().getAsJsonPrimitive("1990").getAsNumber().toString());
	}

}
