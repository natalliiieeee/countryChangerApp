package UC8JUnitTest;

import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

import statBuilder.CountryStats;
import statBuilder.CountryStatsBuilder;
import viewFactory.BarChart;

public class BarChartTest {

	@Test
	public void test1() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build6thStats("Brazil");
		BarChart chart = new BarChart(new JPanel(), "Energy Use", "1998", "2008", cs);
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		for(int i = 1998; i <= 2008; i++) {
			dataset1.setValue(cs.getStates().get(0).getStat().getAsJsonPrimitive(""+i).getAsNumber(), cs.getStates().get(0).getIndicatorName(), ""+i);
		}
		assertEquals(dataset1, chart.getDataset1());
	}

	@Test
	public void test2() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build2ndStats("Brazil");
		BarChart chart = new BarChart(new JPanel(), "Energy use vs. CO2 intensity", "1998", "2008", cs);
		assertTrue(chart.getDataset2Flag());
	}
	
	@Test
	public void test3() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build2ndStats("Brazil");
		BarChart chart = new BarChart(new JPanel(), "Energy use vs. CO2 intensity", "1998", "2008", cs);
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
		for(int i = 1998; i <= 2008; i++) {
			dataset1.setValue(cs.getStates().get(0).getStat().getAsJsonPrimitive(""+i).getAsNumber(), cs.getStates().get(0).getIndicatorName(), ""+i);
		}
		for(int i = 1998; i <= 2008; i++) {
			dataset2.setValue(cs.getStates().get(1).getStat().getAsJsonPrimitive(""+i).getAsNumber(), cs.getStates().get(1).getIndicatorName(), ""+i);
		}
		assertEquals("dataset1s are not equal", dataset1, chart.getDataset1());
		assertEquals("dataset2s are not equal", dataset2, chart.getDataset2());
	}
	
	@Test
	public void test4() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build1stStats("Brazil");
		BarChart chart = new BarChart(new JPanel(), "Energy Depletion/Population", "1998", "2008", cs);
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		for(int i = 1998; i <= 2008; i++) {
			dataset1.setValue(cs.executeStrategy(""+i), "Energy Depletion/Population", ""+i);
		}
		assertEquals(dataset1, chart.getDataset1());
	}

}
