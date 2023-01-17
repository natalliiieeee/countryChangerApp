package UC2JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import statBuilder.EnergyUseCapita;

public class EnergyUseCapitaTest {

	@Test
	public void test1() {
		EnergyUseCapita testObj = new EnergyUseCapita("Brazil");
		assertEquals("\"Energy use (kg of oil equivalent per capita)\"", testObj.getIndicatorName());
	}
	@Test
	public void test2() {
		EnergyUseCapita testObj = new EnergyUseCapita("Brazil");
		assertEquals("\"kg\"", testObj.getUnit());
	}
	@Test
	public void test3() {
		EnergyUseCapita testObj = new EnergyUseCapita("Brazil");
		assertEquals("715.8406136508333", testObj.getStat().getAsJsonPrimitive("1971").getAsNumber().toString());
	}

}
