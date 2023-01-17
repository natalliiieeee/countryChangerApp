package analysisInfo;

import java.util.Vector;

public class CountrySubject {
	private Vector<String> countries;
	private String countryState;
	private AnalysisTypeSubjectAndObserver analysisType;
	
	public CountrySubject() {
		this.countries = new Vector<String>();
		this.countries.add("Brazil");
		this.countries.add("Canada");
		this.countries.add("Italy");
		this.countries.add("United States");
		this.countries.add("United Kingdom");
		this.countries.add("Frence");
		this.countryState = "Brazil";
		this.analysisType = null;
	}
	
	public boolean selectCountry(String c) {
		boolean isAllowed = true;
		if(c.equals("Frence")) {
			isAllowed = false;
		}else {
			this.countryState = c;
			this.notifyObserver();
		}
		return isAllowed;
	}
	
	public void setAnalysisType(AnalysisTypeSubjectAndObserver at) {
		this.analysisType = at;
	}
	
	public void notifyObserver() {
		this.analysisType.update(this.countryState);
	}
	
	public String getCountryState() {
		return this.countryState;
	}
	
	public Vector<String> getCountries(){
		return this.countries;
	}
	
	public AnalysisTypeSubjectAndObserver getAnalysisType() {
		return this.analysisType;
	}
	
}
