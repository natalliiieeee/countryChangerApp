package UC2JUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import statBuilder.Co2Intensity;

public class Co2IntensityTest {
	
	@Test
	public void test1() {
		Co2Intensity testObj = new Co2Intensity("Brazil");
		assertEquals("\"CO2 intensity (kg per kg of oil equivalent energy use)\"", testObj.getIndicatorName());
	}
	@Test
	public void test2() {
		Co2Intensity testObj = new Co2Intensity("Brazil");
		assertEquals("\"kg\"", testObj.getUnit());
	}
	@Test
	public void test3() {
		Co2Intensity testObj = new Co2Intensity("Brazil");
		assertEquals("1.470799224427293", testObj.getStat().getAsJsonPrimitive("1971").getAsNumber().toString());
	}
	
}
