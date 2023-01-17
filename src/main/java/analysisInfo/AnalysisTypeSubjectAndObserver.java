package analysisInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import statBuilder.CountryStats;
import statBuilder.CountryStatsBuilder;

public class AnalysisTypeSubjectAndObserver {
	private Vector<String> analysisType;
	private List<Observer> observers;
	private CountryStats analysisTypeState;
	private String countryState;
	private CountryStatsBuilder csb;
	private CountrySubject country;
	
	public AnalysisTypeSubjectAndObserver(CountrySubject c) {
		this.analysisType = new Vector<String>();
		this.analysisType.add("Energy Depletion/Population");
		this.analysisType.add("Energy use vs. CO2 intensity");
		this.analysisType.add("Methane emissions vs CO2 intensity");
		this.analysisType.add("Methane emissions vs Energy related methane emissions");
		this.analysisType.add("Energy Related Methane Emissions");
		this.analysisType.add("Energy Use");
		this.analysisType.add("CO2 intensity");
		this.analysisType.add("GDP/Energy");
		this.observers = new ArrayList<Observer>();
		this.country = c;
		this.countryState = this.country.getCountryState();
		this.csb = new CountryStatsBuilder();
		this.analysisTypeState = csb.build1stStats(this.countryState);
		this.country.setAnalysisType(this);
	}
	
	public void selectAnalysisType(String at) {
		if(at.equals(this.analysisType.get(0))) {
			this.analysisTypeState = csb.build1stStats(this.countryState);
		}else if(at.equals(this.analysisType.get(1))) {
			this.analysisTypeState = csb.build2ndStats(this.countryState);
		}else if(at.equals(this.analysisType.get(2))) {
			this.analysisTypeState = csb.build3rdStats(this.countryState);
		}else if(at.equals(this.analysisType.get(3))) {
			this.analysisTypeState = csb.build4thStats(this.countryState);
		}else if(at.equals(this.analysisType.get(4))) {
			this.analysisTypeState = csb.build5thStats(this.countryState);
		}else if(at.equals(this.analysisType.get(5))) {
			this.analysisTypeState = csb.build6thStats(this.countryState);
		}else if(at.equals(this.analysisType.get(6))) {
			this.analysisTypeState = csb.build7thStats(this.countryState);
		}else if(at.equals(this.analysisType.get(7))) {
			this.analysisTypeState = csb.build8thStats(this.countryState);
		}
		this.notifyAllObservers();
	}
	
	public void notifyAllObservers() {
		for(Observer o : observers) {
			o.update(this.analysisTypeState);
		}
	}
	
	public void attach(Observer o) {
		this.observers.add(o);
	}
	
	public CountryStats getAnalysisTypeState() {
		return this.analysisTypeState;
	}
	
	public void update(String cs) {
		this.countryState = cs;
	}
	
	public Vector<String> getAnalysisType(){
		return this.analysisType;
	}
	
	public CountrySubject getCountry() {
		return this.country;
	}
	
	public String getCountryState() {
		return this.countryState;
	}
	
}
