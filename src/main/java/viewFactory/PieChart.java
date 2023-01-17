package viewFactory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;

import statBuilder.CountryStats;
import statBuilder.Stat;

public class PieChart extends ViewChart{
	private ChartPanel chartPanel;
	private DefaultCategoryDataset dataset;
	
	public PieChart(JPanel west, String title, String sy, String ey, CountryStats data) {
		this.dataset = new DefaultCategoryDataset();
		Stat o = data.getStates().get(0);
		dataset.addValue(o.getStat().getAsJsonPrimitive(sy).getAsNumber(), o.getIndicatorName(), sy);
		dataset.addValue(data.executeStrategy(sy), "Not"+o.getIndicatorName(), sy);
		if(!sy.equals(ey)) {dataset.addValue(o.getStat().getAsJsonPrimitive(sy).getAsNumber(), o.getIndicatorName(), sy);
			dataset.addValue(o.getStat().getAsJsonPrimitive(ey).getAsNumber(), o.getIndicatorName(), ey);
			dataset.addValue(data.executeStrategy(ey), "Not"+o.getIndicatorName(), ey);
		}
		JFreeChart pieChart = ChartFactory.createMultiplePieChart(title, dataset, TableOrder.BY_COLUMN, true, true, false);
		chartPanel = new ChartPanel(pieChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
		this.west = west;
	}
	
	public void removePanel() {
		this.west.remove(chartPanel);
	}
	
	public DefaultCategoryDataset getDataset() {
		return this.dataset;
	}
	
}
