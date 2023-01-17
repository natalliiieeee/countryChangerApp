package selectionHandler;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import analysisInfo.YearObserver;

public class Years implements ItemListener{
	private JLabel from;
	private JLabel to;
	private YearObserver year;
	private JComboBox<String> fromList;
	private JComboBox<String> toList;
	private String selectedStartYear;
	private String selectedEndYear;
	
	public Years(YearObserver year) {
		this.year = year;
		this.from = new JLabel("From");
		this.to = new JLabel("To");
		Vector<String> years = year.getYear();
		this.fromList = new JComboBox<String>(years);
		this.toList = new JComboBox<String>(years);
		this.fromList.addItemListener(this);
		this.toList.addItemListener(this);
		this.selectedStartYear = "2010";
		this.selectedEndYear = "2010";
	}
	
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED){
			if(e.getSource() == this.fromList) {
				String sy = (String) this.fromList.getSelectedItem();
				if(year.selectYear(sy) && Integer.parseInt(sy) <= Integer.parseInt(this.selectedEndYear)) {
					this.selectedStartYear = sy;
					System.out.println(this.selectedStartYear);
				}else {
					JFrame frame = new JFrame("Error");
					JOptionPane.showMessageDialog(frame, "The year you selected is not available!");;
				}
			}else if(e.getSource() == this.toList){
				String ey = (String) this.toList.getSelectedItem();
				if(year.selectYear(ey) && Integer.parseInt(ey) >= Integer.parseInt(this.selectedStartYear)) {
					this.selectedEndYear = ey;
					System.out.println(this.selectedEndYear);
				}else {
					JFrame frame = new JFrame("Error");
					JOptionPane.showMessageDialog(frame, "The year you selected is not available!");
				}
			}
		}
	}
	
	public JLabel getFrom() {
		return this.from;
	}
	
	public JLabel getTo() {
		return this.to;
	}
	
	public JComboBox<String> getFromList(){
		return this.fromList;
	}
	
	public JComboBox<String> getToList(){
		return this.toList;
	}
	
	public String getSelectedStartYear() {
		return this.selectedStartYear;
	}
	
	public String getSelectedEndYear() {
		return this.selectedEndYear;
	}
	
}
