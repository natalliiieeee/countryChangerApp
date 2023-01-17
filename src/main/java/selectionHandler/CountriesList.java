package selectionHandler;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import analysisInfo.CountrySubject;

public class CountriesList implements ItemListener{
	private CountrySubject countries;
	private JLabel chooseCountryLabel;
	private JComboBox<String> countriesList;
	private String selectedCountry;

	public CountriesList(CountrySubject countries) {
		this.countries = countries;
		this.chooseCountryLabel = new JLabel("Choose a country: ");
		Vector<String> countriesNames = this.countries.getCountries();
		this.countriesList = new JComboBox<String>(countriesNames);
		this.countriesList.addItemListener(this);
		this.selectedCountry = "Brazil";
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			String str = (String) this.countriesList.getSelectedItem();
			if(countries.selectCountry(str)) {
				this.selectedCountry = str;
			}else {
				JFrame frame = new JFrame("Error");
				JOptionPane.showMessageDialog(frame, "The country you selected is not available!");
			}
		}
	}

	public JLabel getChooseCountryLabel() {
		return this.chooseCountryLabel;
	}

	public JComboBox<String> getCountriesList(){
		return this.countriesList;
	}
	
	public String getSelectedCountry() {
		return this.selectedCountry;
	}

}
