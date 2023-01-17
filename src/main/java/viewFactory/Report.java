package viewFactory;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import statBuilder.CountryStats;

public class Report extends ViewChart{
	private JScrollPane outputScrollPane;
	private JTextArea report;
	private String content;
	
	public Report(JPanel west, String title, String sy, String ey, CountryStats data) {
		report = new JTextArea();
		report.setEditable(false);
		report.setPreferredSize(new Dimension(400, 300));
		report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		report.setBackground(Color.white);
		this.content = title + "\n==============================\n";
		if(title.equals("Energy Depletion/Population")) {
			for(int i = Integer.parseInt(sy); i <= Integer.parseInt(ey); i++) {
				content += "Year " + i + ":\n";
				content += "\t" + title + "=>" 
						+ data.executeStrategy(""+i) + "\n";
			}
		}else {
			for(int i = Integer.parseInt(sy); i <= Integer.parseInt(ey); i++) {
				content += "Year " + i + ":\n";
				for(int j = 0; j < data.getStates().size(); j++) {
					content += "\t" + data.getStates().get(j).getIndicatorName() + "=>" 
									+ data.getStates().get(j).getStat().getAsJsonPrimitive(""+i).getAsNumber() + "\n";
				}
			}
		}	
		report.setText(content);
		this.outputScrollPane = new JScrollPane(report);
		west.add(outputScrollPane);
		this.west = west;
	}
	
	public void removePanel() {
		this.west.remove(outputScrollPane);
	}
	
	public JTextArea getReport() {
		return this.report;
	}

	public String getContent() {
		return this.content;
	}
}
