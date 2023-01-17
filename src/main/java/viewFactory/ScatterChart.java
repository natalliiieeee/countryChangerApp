package viewFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

import com.google.gson.JsonObject;

import statBuilder.CountryStats;

public class ScatterChart extends ViewChart{
	private ChartPanel chartPanel;
	private TimeSeriesCollection dataset1;
	private TimeSeriesCollection dataset2;
	private boolean dataset2Flag;
	
	public ScatterChart(JPanel west, String title, String sy, String ey, CountryStats data) {
		this.dataset1 = new TimeSeriesCollection();
		this.dataset2 = new TimeSeriesCollection();
		double ruler = data.getStates().get(0).getStat().getAsJsonPrimitive(sy).getAsDouble();
		String unit = data.getStates().get(0).getUnit();
		this.dataset2Flag = false;
		if(title.equals("Energy Depletion/Population")) {
			TimeSeries series = new TimeSeries(title);
			for(int i = Integer.parseInt(sy); i <= Integer.parseInt(ey); i++) {
				series.add(new Year(i), data.executeStrategy(""+i));
			}
			dataset1.addSeries(series);
		}else {
			for(int i = 0; i < data.getStates().size(); i++) {
				JsonObject o = data.getStates().get(i).getStat();
				if(i > 0 && (o.getAsJsonPrimitive(sy).getAsDouble() > 100*ruler || o.getAsJsonPrimitive(sy).getAsDouble()*100 < ruler)) {
					TimeSeries series = new TimeSeries(data.getStates().get(i).getIndicatorName());
					for(int j = Integer.parseInt(sy); j <= Integer.parseInt(ey); j++) {
						series.add(new Year(j), o.getAsJsonPrimitive(""+j).getAsNumber());
					}
					dataset2.addSeries(series);
					dataset2Flag = true;
				}else {
					TimeSeries series = new TimeSeries(data.getStates().get(i).getIndicatorName());
					for(int j = Integer.parseInt(sy); j <= Integer.parseInt(ey); j++) {
						series.add(new Year(j), o.getAsJsonPrimitive(""+j).getAsNumber());
					}
					dataset1.addSeries(series);
				}
			}
		}
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		plot.setDataset(0, dataset1);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(unit));
		plot.mapDatasetToRangeAxis(0, 0);		
		if(dataset2Flag) {
			XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);
			plot.setDataset(1, dataset2);
			plot.setRenderer(1, itemrenderer2);
			plot.setRangeAxis(1, new NumberAxis(""));
			plot.mapDatasetToRangeAxis(1, 1);
		}
		JFreeChart scatterChart = new JFreeChart(title, new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
		this.west = west;
	}
	
	public void removePanel() {
		this.west.remove(chartPanel);
	}
	
	public TimeSeriesCollection getDataset1() {
		return this.dataset1;
	}
	
	public TimeSeriesCollection getDataset2() {
		return this.dataset2;
	}
	
	public boolean getDataset2Flag() {
		return this.dataset2Flag;
	}

}
