package UC8JUnitTest;

import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.junit.Test;

import statBuilder.CountryStats;
import statBuilder.CountryStatsBuilder;
import viewFactory.BarChart;
import viewFactory.LineChart;
import viewFactory.PieChart;
import viewFactory.Report;
import viewFactory.ScatterChart;
import viewFactory.TimeSeriesChart;
import viewFactory.ViewChart;
import viewFactory.ViewFactory;

public class ViewFactoryTest {

	@Test
	public void test1() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build5thStats("Brazil");
		ViewFactory vf = new ViewFactory();
		ViewChart fromfact = vf.getView(new JPanel(), "Pie Chart", "abc", "1998", "2008", cs);
		assertTrue(fromfact instanceof PieChart);
	}
	

	@Test
	public void test2() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build2ndStats("Brazil");
		ViewFactory vf = new ViewFactory();
		ViewChart fromfact = vf.getView(new JPanel(), "Line Chart", "abc", "1998", "2008", cs);
		assertTrue(fromfact instanceof LineChart);
	}
	

	@Test
	public void test3() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build3rdStats("Brazil");
		ViewFactory vf = new ViewFactory();
		ViewChart fromfact = vf.getView(new JPanel(), "Scatter Chart", "abc", "1998", "2008", cs);
		assertTrue(fromfact instanceof ScatterChart);
	}
	
	@Test
	public void test4() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build3rdStats("Brazil");
		ViewFactory vf = new ViewFactory();
		ViewChart fromfact = vf.getView(new JPanel(), "Bar Chart", "abc", "1998", "2008", cs);
		assertTrue(fromfact instanceof BarChart);
	}
	
	@Test
	public void test5() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build3rdStats("Brazil");
		ViewFactory vf = new ViewFactory();
		ViewChart fromfact = vf.getView(new JPanel(), "Time Series Chart", "abc", "1998", "2008", cs);
		assertTrue(fromfact instanceof TimeSeriesChart);
	}
	
	@Test
	public void test6() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build3rdStats("Brazil");
		ViewFactory vf = new ViewFactory();
		ViewChart fromfact = vf.getView(new JPanel(), "Report", "abc", "1998", "2008", cs);
		assertTrue(fromfact instanceof Report);
	}

}
