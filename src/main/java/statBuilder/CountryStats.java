package statBuilder;

import java.util.ArrayList;
import java.util.List;

import dataProcessStrategy.Strategy;

public class CountryStats{
	private String countryName;
	private List<Stat> stats;
	private Strategy strategy;
	
	public CountryStats(String cn) {
		this.countryName = cn;
		this.stats = new ArrayList<Stat>();
		strategy = null;
	}
	
	public void addStat(Stat stat) {
		this.stats.add(stat);
	}
	
	public String getCountryName() {
		return this.countryName;
	}
	
	public List<Stat> getStates() {
		return this.stats;
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public Number executeStrategy(String year) {
		return strategy.doDataProcessing(this.stats, year);
	}
}
