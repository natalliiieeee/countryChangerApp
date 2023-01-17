package UC8JUnitTest;

import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

import statBuilder.CountryStats;
import statBuilder.CountryStatsBuilder;
import viewFactory.PieChart;

public class PieChartTest {

	@Test
	public void test1() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build5thStats("Brazil");
		PieChart chart = new PieChart(new JPanel(), "Energy Depletion/Population", "2008", "2008", cs);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(cs.getStates().get(0).getStat().getAsJsonPrimitive("2008").getAsNumber(), cs.getStates().get(0).getIndicatorName(), "2008");
		dataset.addValue(cs.executeStrategy("2008"), "Not"+cs.getStates().get(0).getIndicatorName(), "2008");
		assertEquals(dataset, chart.getDataset());
	}
	
	@Test
	public void test2() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build5thStats("Brazil");
		PieChart chart = new PieChart(new JPanel(), "Energy Depletion/Population", "2006", "2008", cs);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(cs.getStates().get(0).getStat().getAsJsonPrimitive("2006").getAsNumber(), cs.getStates().get(0).getIndicatorName(), "2006");
		dataset.addValue(cs.executeStrategy("2006"), "Not"+cs.getStates().get(0).getIndicatorName(), "2006");
		dataset.addValue(cs.getStates().get(0).getStat().getAsJsonPrimitive("2008").getAsNumber(), cs.getStates().get(0).getIndicatorName(), "2008");
		dataset.addValue(cs.executeStrategy("2008"), "Not"+cs.getStates().get(0).getIndicatorName(), "2008");
		assertEquals(dataset, chart.getDataset());
	}

}
