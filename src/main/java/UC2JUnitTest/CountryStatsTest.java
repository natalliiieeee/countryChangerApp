package UC2JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dataProcessStrategy.DivisionStrategy;
import dataProcessStrategy.PieStrategy;
import statBuilder.Co2Intensity;
import statBuilder.CountryStats;
import statBuilder.EnergyRelatedMethaneEmissions;
import statBuilder.Population;

public class CountryStatsTest {

	@Test
	public void test1() {
		CountryStats obj = new CountryStats("Brazil");
		assertEquals("Brazil", obj.getCountryName());
	}
	@Test
	public void test2() {
		CountryStats obj = new CountryStats("Brazil");
		assertEquals(0, obj.getStates().size());
	}
	@Test
	public void test3() {
		CountryStats obj = new CountryStats("Brazil");
		obj.addStat(new Co2Intensity(obj.getCountryName()));
		assertEquals(1, obj.getStates().size());
	}
	@Test
	public void test4() {
		CountryStats obj = new CountryStats("Brazil");
		obj.addStat(new Co2Intensity(obj.getCountryName()));
		assertEquals("\"CO2 intensity (kg per kg of oil equivalent energy use)\"", obj.getStates().get(0).getIndicatorName());
	}
	@Test
	public void test5() {
		CountryStats obj = new CountryStats("Brazil");
		obj.addStat(new Co2Intensity(obj.getCountryName()));
		obj.addStat(new Population(obj.getCountryName()));
		obj.setStrategy(new DivisionStrategy());
		assertEquals(9.252678429156269E-9, obj.executeStrategy("1995"));
	}
	@Test
	public void test6() {
		CountryStats obj = new CountryStats("Brazil");
		obj.addStat(new EnergyRelatedMethaneEmissions(obj.getCountryName()));
		obj.setStrategy(new PieStrategy());
		assertEquals(96.19964692665704, obj.executeStrategy("1995"));
	}

}
