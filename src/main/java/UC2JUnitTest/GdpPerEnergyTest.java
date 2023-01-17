package UC2JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import statBuilder.GdpPerEnergy;

public class GdpPerEnergyTest {

	@Test
	public void test1() {
		GdpPerEnergy testObj = new GdpPerEnergy("Brazil");
		assertEquals("\"GDP per unit of energy use (PPP $ per kg of oil equivalent)\"", testObj.getIndicatorName());
	}
	@Test
	public void test2() {
		GdpPerEnergy testObj = new GdpPerEnergy("Brazil");
		assertEquals("\"US$\"", testObj.getUnit());
	}
	@Test
	public void test3() {
		GdpPerEnergy testObj = new GdpPerEnergy("Brazil");
		assertEquals("7.113534296377293", testObj.getStat().getAsJsonPrimitive("1990").getAsNumber().toString());
	}

}
