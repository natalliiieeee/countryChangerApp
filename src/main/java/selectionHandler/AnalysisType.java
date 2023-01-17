package selectionHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import analysisInfo.AnalysisTypeSubjectAndObserver;

public class AnalysisType implements ItemListener{
	private JButton recalculate;
	private JLabel methodLabel;
	private JComboBox<String> methodsList;
	private AnalysisTypeSubjectAndObserver analysisType;
	private String selectedAnalysisType;

	public AnalysisType(AnalysisTypeSubjectAndObserver at) {
		this.analysisType = at;
		this.selectedAnalysisType = "Energy Depletion/Population";
		this.recalculate = new JButton("Recalculate");
		this.recalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				analysisType.selectAnalysisType(selectedAnalysisType);
			}
		});
		this.methodLabel = new JLabel("        Choose analysis method: ");
		Vector<String> methodsNames = analysisType.getAnalysisType();
		this.methodsList = new JComboBox<String>(methodsNames);
		this.methodsList.addItemListener(this);
	}

	public JButton getRecalculate() {
		return this.recalculate;
	}

	public JLabel getMethodLabel() {
		return this.methodLabel;
	}

	public JComboBox<String> getMethodsList(){
		return this.methodsList;
	}

	public String getSelectedAnalysisType() {
		return this.selectedAnalysisType;
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			String at = (String) this.methodsList.getSelectedItem();
			this.selectedAnalysisType = at;
			this.analysisType.selectAnalysisType(at);
		}

	}

}
