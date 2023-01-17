package UC2JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import statBuilder.Population;

public class PopulationTest {

	@Test
	public void test1() {
		Population testObj = new Population("Brazil");
		assertEquals("\"Population, total\"", testObj.getIndicatorName());
	}
	@Test
	public void test2() {
		Population testObj = new Population("Brazil");
		assertEquals(null, testObj.getUnit());
	}
	@Test
	public void test3() {
		Population testObj = new Population("Brazil");
		assertEquals("162019889", testObj.getStat().getAsJsonPrimitive("1995").getAsNumber().toString());
	}

}
