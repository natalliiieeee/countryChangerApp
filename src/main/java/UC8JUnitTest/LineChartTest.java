package UC8JUnitTest;

import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.Test;

import statBuilder.CountryStats;
import statBuilder.CountryStatsBuilder;
import viewFactory.LineChart;

public class LineChartTest {

	@Test
	public void test1() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build6thStats("Brazil");
		LineChart chart = new LineChart(new JPanel(), "Energy Use", "1998", "2008", cs);
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries(cs.getStates().get(0).getIndicatorName());
		for(int i = 1998; i <= 2008; i++) {
			series.add(i, cs.getStates().get(0).getStat().getAsJsonPrimitive(""+i).getAsNumber());
		}
		dataset.addSeries(series);
		assertEquals(dataset, chart.getDataset());
	}
	
	@Test
	public void test2() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build2ndStats("Brazil");
		LineChart chart = new LineChart(new JPanel(), "Energy use vs. CO2 intensity", "1998", "2008", cs);
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries(cs.getStates().get(0).getIndicatorName());
		XYSeries series2 = new XYSeries(cs.getStates().get(1).getIndicatorName());
		for(int i = 1998; i <= 2008; i++) {
			series1.add(i, cs.getStates().get(0).getStat().getAsJsonPrimitive(""+i).getAsNumber());
			series2.add(i, cs.getStates().get(1).getStat().getAsJsonPrimitive(""+i).getAsNumber());
		}
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		assertEquals(dataset, chart.getDataset());
	}
	
	@Test
	public void test3() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build1stStats("Brazil");
		LineChart chart = new LineChart(new JPanel(), "Energy Depletion/Population", "1998", "2008", cs);
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("Energy Depletion/Population");
		for(int i = 1998; i <= 2008; i++) {
			series.add(i, cs.executeStrategy(""+i));
		}
		dataset.addSeries(series);
		assertEquals(dataset, chart.getDataset());
	}

}
