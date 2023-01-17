package statsVisualiser.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import analysisInfo.AnalysisTypeSubjectAndObserver;
import analysisInfo.CountrySubject;
import analysisInfo.ViewObserver;
import analysisInfo.YearObserver;
import selectionHandler.AnalysisType;
import selectionHandler.CountriesList;
import selectionHandler.View;
import selectionHandler.Years;
import viewFactory.ViewChart;
import viewFactory.ViewFactory;

public class MainUI extends JFrame implements ActionListener{
	private JPanel west;
	private AnalysisType analysisType;
	private View view;
	private Years years;
	private CountriesList countriesList;
	private ViewFactory vf;
	private CountrySubject countries;
	private AnalysisTypeSubjectAndObserver analysisTypeSNO;
	private YearObserver year;
	private ViewObserver views;
	private ArrayList<ViewChart> cpList;
	private JButton addView;
	private JButton removeView;
	
	private static final long serialVersionUID = 1L;

	private static MainUI instance;

	public static MainUI getInstance() {
		if (instance == null)
			instance = new MainUI();

		return instance;
	}

	private MainUI() {
		
		// Set window title
		super("Country Statistics");

		this.countries = new CountrySubject();
		this.analysisTypeSNO = new AnalysisTypeSubjectAndObserver(countries);
		this.year = new YearObserver(analysisTypeSNO);
		this.views = new ViewObserver(analysisTypeSNO);
		this.analysisTypeSNO.attach(year);
		this.analysisTypeSNO.attach(views);
		
		// Set top bar	
		this.countriesList = new CountriesList(countries);
		this.years = new Years(year);

		JPanel north = new JPanel();
		north.add(countriesList.getChooseCountryLabel());
		north.add(countriesList.getCountriesList());
		north.add(years.getFrom());
		north.add(years.getFromList());
		north.add(years.getTo());
		north.add(years.getToList());

		// Set bottom bar
		this.analysisType = new AnalysisType(analysisTypeSNO);
		this.view = new View(views);		
		addView = new JButton("+");
		removeView = new JButton("-");

		JPanel south = new JPanel();
		south.add(view.getViewsLabel());
		south.add(view.getViewsList());
		south.add(addView);
		south.add(removeView);

		south.add(analysisType.getMethodLabel());
		south.add(analysisType.getMethodsList());
		south.add(analysisType.getRecalculate());

		JPanel east = new JPanel();

		// Set charts region
		this.west = new JPanel();
		west.setLayout(new GridLayout(2, 0));
		//createCharts(west);
		this.vf = new ViewFactory();
		
		//ChartPanel cp =new ChartPanel();
		
		addView.addActionListener(this);
		removeView.addActionListener(this);

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(west, BorderLayout.WEST);
		
		cpList = new ArrayList<ViewChart>();
	}

	

//	public static void main(String[] args) {
//
//		JFrame frame = MainUI.getInstance();
//		frame.setPreferredSize(new Dimension(1230, 700));
//		frame.pack();
//		frame.setVisible(true);
//	}
	// TODO Auto-generated method stub

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addView) {
			cpList.add(vf.getView(west, view.getSelectedView(), analysisType.getSelectedAnalysisType(), years.getSelectedStartYear(), years.getSelectedEndYear(), analysisTypeSNO.getAnalysisTypeState()));
			west.revalidate();
			west.repaint();
		}else if(e.getSource() == removeView){
			int i = cpList.size()-1;
			if(i >= 0) {
				cpList.get(i).removePanel();
				cpList.remove(i);
				west.revalidate();
				west.repaint();
			}
		}	
	}
	
	public JButton getAddView() {
		return this.addView;
	}
	
	public JButton getRemoveView() {
		return this.removeView;
	}
	
	public ArrayList<ViewChart> getCpList(){
		return this.cpList;
	}
	
}
