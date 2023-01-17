package viewFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import statBuilder.CountryStats;
import statBuilder.Stat;

public class BarChart extends ViewChart{
	private ChartPanel chartPanel;
	private DefaultCategoryDataset dataset1;
	private DefaultCategoryDataset dataset2;
	private String unit;
	private boolean dataset2Flag;
	
	public BarChart(JPanel west, String title, String sy, String ey, CountryStats data) {
		this.dataset1 = new DefaultCategoryDataset();
		this.dataset2 = new DefaultCategoryDataset();
		double ruler = data.getStates().get(0).getStat().getAsJsonPrimitive(sy).getAsDouble();
		this.unit = data.getStates().get(0).getUnit();
		this.dataset2Flag = false;
		if(title.equals("Energy Depletion/Population")) {
			for(int i = Integer.parseInt(sy); i <= Integer.parseInt(ey); i++) {
				dataset1.setValue(data.executeStrategy(""+i), title, ""+i);
			}
		}else {
			for(int i = 0; i < data.getStates().size(); i++) {
				Stat o = data.getStates().get(i);
				if(i > 0 && (o.getStat().getAsJsonPrimitive(sy).getAsDouble() > 100*ruler || o.getStat().getAsJsonPrimitive(sy).getAsDouble()*100 < ruler)) {
					for(int j = Integer.parseInt(sy); j <= Integer.parseInt(ey); j++) {
						dataset2.setValue(o.getStat().getAsJsonPrimitive(""+j).getAsNumber(), o.getIndicatorName(), ""+j);
					}
					dataset2Flag = true;
				}else {
					for(int j = Integer.parseInt(sy); j <= Integer.parseInt(ey); j++) {
						dataset1.setValue(o.getStat().getAsJsonPrimitive(""+j).getAsNumber(), o.getIndicatorName(), ""+j);
					}
				}
			}
		}
		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();
		plot.setDataset(0, dataset1);
		plot.setRenderer(0, barrenderer1);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(unit));
		plot.mapDatasetToRangeAxis(0, 0);
		if(dataset2Flag) {
			BarRenderer barrenderer2 = new BarRenderer();
			plot.setDataset(1, dataset2);
			plot.setRenderer(1, barrenderer2);
			plot.setRangeAxis(1, new NumberAxis(""));
			plot.mapDatasetToRangeAxis(1, 1);
		}
		JFreeChart barChart = new JFreeChart(title, new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
		this.west = west;
	}
	
	public void removePanel() {
		this.west.remove(chartPanel);
	}
	
	public DefaultCategoryDataset getDataset1() {
		return this.dataset1;
	}
	
	public DefaultCategoryDataset getDataset2() {
		return this.dataset2;
	}
	
	public boolean getDataset2Flag() {
		return this.dataset2Flag;
	}

}
