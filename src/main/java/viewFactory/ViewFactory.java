package viewFactory;

import javax.swing.JPanel;

import statBuilder.CountryStats;

public class ViewFactory {

	public ViewChart getView(JPanel west, String v, String title, String sy, String ey, CountryStats data) {
		ViewChart toReturn = null;
		if(v.equals("Pie Chart")) {
			toReturn = new PieChart(west, title, sy, ey, data);
		}else if(v.equals("Line Chart")) {
			toReturn = new LineChart(west,title, sy, ey, data);
		}else if(v.equals("Bar Chart")) {
			toReturn = new BarChart(west, title, sy, ey, data);
		}else if(v.equals("Scatter Chart")) {
			toReturn = new ScatterChart(west, title, sy, ey, data);
		}else if(v.equals("Time Series Chart")) {
			toReturn = new TimeSeriesChart(west, title, sy, ey, data);
		}else {
			toReturn = new Report(west, title, sy, ey, data);
		}
		return toReturn;
	}
	
}
