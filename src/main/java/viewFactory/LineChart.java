package viewFactory;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import statBuilder.CountryStats;

public class LineChart extends ViewChart{
	private ChartPanel chartPanel;
	private XYSeriesCollection dataset;
	
	public LineChart(JPanel west, String title, String sy, String ey, CountryStats data) {
		dataset = new XYSeriesCollection();
		if(title.equals("Energy Depletion/Population")) {
			XYSeries series = new XYSeries(title);
			for(int i = Integer.parseInt(sy); i <= Integer.parseInt(ey); i++) {
				series.add(i, data.executeStrategy(""+i));
			}
			dataset.addSeries(series);
		}else {
			for(int i = 0; i < data.getStates().size(); i++) {
				XYSeries series = new XYSeries(data.getStates().get(i).getIndicatorName());
				for(int j = Integer.parseInt(sy); j <= Integer.parseInt(ey); j++) {
					series.add(j, data.getStates().get(i).getStat().getAsJsonPrimitive(""+j).getAsNumber());
				}
				dataset.addSeries(series);
			}
		}	
		JFreeChart chart = ChartFactory.createXYLineChart(title, "Year", "", dataset, PlotOrientation.VERTICAL, true, true, false);
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		chart.getLegend().setFrame(BlockBorder.NONE);
		chart.setTitle(new TextTitle(title, new Font("Serif", java.awt.Font.BOLD, 18)));
		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
		this.west = west;
	}

	public void removePanel() {
		this.west.remove(chartPanel);
	}
	
	public XYSeriesCollection getDataset() {
		return this.dataset;
	}
	
}
