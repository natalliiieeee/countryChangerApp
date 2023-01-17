package selectionHandler;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import analysisInfo.ViewObserver;

public class View implements ItemListener{
	private JLabel viewsLabel;
	private JComboBox<String> viewsList;
	private ViewObserver view;
	private String selectedView;
	
	
	public View(ViewObserver v) {
		this.view = v;
		this.viewsLabel = new JLabel("Available Views: ");
		Vector<String> viewsNames = v.getViews();
		this.viewsList = new JComboBox<String>(viewsNames);
		this.selectedView = "Line Chart";
		this.viewsList.addItemListener(this);
	}
	
	public JLabel getViewsLabel() {
		return this.viewsLabel;
	}
	
	public JComboBox<String> getViewsList(){
		return this.viewsList;
	}
	
	public String getSelectedView() {
		return this.selectedView;
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			String v = (String) viewsList.getSelectedItem();
			if(this.view.selectView(v)) {
				selectedView = v;
			}else {
				JFrame frame = new JFrame("Error");
				JOptionPane.showMessageDialog(frame, "The view you selected is not available! Will create the view you selected previously.");
			}
		}
	}

}
