package UC2JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import statBuilder.CountryStats;
import statBuilder.CountryStatsBuilder;

public class CountryStatsBuilderTest {

	@Test
	public void test1() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build1stStats("Brazil");
		assertEquals(2, obj.getStates().size());
	}
	@Test
	public void test2() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build1stStats("Brazil");
		assertEquals("Wrong Indicator_Nmae in 1st stat", "\"Adjusted savings: energy depletion (current US$)\"", obj.getStates().get(0).getIndicatorName());
		assertEquals("Wrong Indicator_Nmae in 2nd stat", "\"Population, total\"", obj.getStates().get(1).getIndicatorName());
	}
	@Test
	public void test3() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build1stStats("Brazil");
		assertEquals(12.939830819022225, obj.executeStrategy("1995"));
	}
	
	@Test
	public void test4() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build2ndStats("Brazil");
		assertEquals(2, obj.getStates().size());
	}
	@Test
	public void test5() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build2ndStats("Brazil");
		assertEquals("Wrong Indicator_Nmae in 1st stat", "\"Energy use (kg of oil equivalent per capita)\"", obj.getStates().get(0).getIndicatorName());
		assertEquals("Wrong Indicator_Nmae in 2nd stat", "\"CO2 intensity (kg per kg of oil equivalent energy use)\"", obj.getStates().get(1).getIndicatorName());
	}
	
	@Test
	public void test6() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build3rdStats("Brazil");
		assertEquals(2, obj.getStates().size());
	}
	@Test
	public void test7() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build3rdStats("Brazil");
		assertEquals("Wrong Indicator_Nmae in 1st stat", "\"Methane emissions in energy sector (thousand metric tons of CO2 equivalent)\"", obj.getStates().get(0).getIndicatorName());
		assertEquals("Wrong Indicator_Nmae in 2nd stat", "\"CO2 intensity (kg per kg of oil equivalent energy use)\"", obj.getStates().get(1).getIndicatorName());
	}
	
	@Test
	public void test8() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build4thStats("Brazil");
		assertEquals(2, obj.getStates().size());
	}
	@Test
	public void test9() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build4thStats("Brazil");
		assertEquals("Wrong Indicator_Nmae in 1st stat", "\"Methane emissions in energy sector (thousand metric tons of CO2 equivalent)\"", obj.getStates().get(0).getIndicatorName());
		assertEquals("Wrong Indicator_Nmae in 2nd stat", "\"Energy related methane emissions (% of total)\"", obj.getStates().get(1).getIndicatorName());
	}
	
	@Test
	public void test10() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build5thStats("Brazil");
		assertEquals(1, obj.getStates().size());
	}
	@Test
	public void test11() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build5thStats("Brazil");
		assertEquals(95.95554420030659, obj.executeStrategy("2008"));
	}
	
	@Test
	public void test12() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build6thStats("Brazil");
		assertEquals(1, obj.getStates().size());
	}
	@Test
	public void test13() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build6thStats("Brazil");
		assertEquals("\"Energy use (kg of oil equivalent per capita)\"", obj.getStates().get(0).getIndicatorName());
	}
	
	@Test
	public void test14() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build7thStats("Brazil");
		assertEquals(1, obj.getStates().size());
	}
	@Test
	public void test15() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build7thStats("Brazil");
		assertEquals("\"CO2 intensity (kg per kg of oil equivalent energy use)\"", obj.getStates().get(0).getIndicatorName());
	}
	
	@Test
	public void test16() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build8thStats("Brazil");
		assertEquals(1, obj.getStates().size());
	}
	@Test
	public void test17() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats obj = csb.build8thStats("Brazil");
		assertEquals("\"GDP per unit of energy use (PPP $ per kg of oil equivalent)\"", obj.getStates().get(0).getIndicatorName());
	}
	
}
