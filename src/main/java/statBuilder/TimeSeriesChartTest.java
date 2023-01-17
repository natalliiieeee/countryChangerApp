package statBuilder;

import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.junit.Test;

import viewFactory.TimeSeriesChart;

public class TimeSeriesChartTest {

	@Test
	public void test1() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build6thStats("Brazil");
		TimeSeriesChart chart = new TimeSeriesChart(new JPanel(), "Energy Use", "1998", "2008", cs);
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		TimeSeries series = new TimeSeries(cs.getStates().get(0).getIndicatorName());
		for(int i = 1998; i <= 2008; i++) {
			series.add(new Year(i), cs.getStates().get(0).getStat().getAsJsonPrimitive(""+i).getAsNumber());
		}
		dataset.addSeries(series);
		assertEquals(dataset, chart.getDataset1());
	}
	
	@Test
	public void test2() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build2ndStats("Brazil");
		TimeSeriesChart chart = new TimeSeriesChart(new JPanel(), "Energy use vs. CO2 intensity", "1998", "2008", cs);
		assertTrue(chart.getDataset2Flag());
	}
	
	@Test
	public void test3() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build2ndStats("Brazil");
		TimeSeriesChart chart = new TimeSeriesChart(new JPanel(), "Energy use vs. CO2 intensity", "1998", "2008", cs);
		TimeSeriesCollection dataset1 = new TimeSeriesCollection();
		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		TimeSeries series1 = new TimeSeries(cs.getStates().get(0).getIndicatorName());
		TimeSeries series2 = new TimeSeries(cs.getStates().get(1).getIndicatorName());
		for(int i = 1998; i <= 2008; i++) {
			series1.add(new Year(i), cs.getStates().get(0).getStat().getAsJsonPrimitive(""+i).getAsNumber());
			series2.add(new Year(i), cs.getStates().get(1).getStat().getAsJsonPrimitive(""+i).getAsNumber());
			
		}
		dataset1.addSeries(series1);
		dataset2.addSeries(series2);
		assertEquals("dataset1s are not equal", dataset1, chart.getDataset1());
		assertEquals("dataset2s are not equal", dataset2, chart.getDataset2());
	}
	
	@Test
	public void test4() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build1stStats("Brazil");
		TimeSeriesChart chart = new TimeSeriesChart(new JPanel(), "Energy Depletion/Population", "1998", "2008", cs);
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		TimeSeries series = new TimeSeries("Energy Depletion/Population");
		for(int i = 1998; i <= 2008; i++) {
			series.add(new Year(i), cs.executeStrategy(""+i));
		}
		dataset.addSeries(series);
		assertEquals(dataset, chart.getDataset1());
	}

}
