package statBuilder;

import dataProcessStrategy.DivisionStrategy;
import dataProcessStrategy.PieStrategy;

public class CountryStatsBuilder {
	
	public CountryStats build1stStats(String countryName) {
		CountryStats cs = new CountryStats(countryName);
		cs.addStat(new AdjustedSavingsEnergyDepletion(countryName));
		cs.addStat(new Population(countryName));
		cs.setStrategy(new DivisionStrategy());
		return cs;
	}
	
	public CountryStats build2ndStats(String countryName) {
		CountryStats cs = new CountryStats(countryName);
		cs.addStat(new EnergyUseCapita(countryName));
		cs.addStat(new Co2Intensity(countryName));
		return cs;
	}
	
	public CountryStats build3rdStats(String countryName) {
		CountryStats cs = new CountryStats(countryName);
		cs.addStat(new MethaneEmissionsInEnergySector(countryName));
		cs.addStat(new Co2Intensity(countryName));
		return cs;
	}
	
	public CountryStats build4thStats(String countryName) {
		CountryStats cs = new CountryStats(countryName);
		cs.addStat(new MethaneEmissionsInEnergySector(countryName));
		cs.addStat(new EnergyRelatedMethaneEmissions(countryName));
		return cs;
	}
	
	public CountryStats build5thStats(String countryName) {
		CountryStats cs = new CountryStats(countryName);
		cs.addStat(new EnergyRelatedMethaneEmissions(countryName));
		cs.setStrategy(new PieStrategy());
		return cs;
	}
	
	public CountryStats build6thStats(String countryName) {
		CountryStats cs = new CountryStats(countryName);
		cs.addStat(new EnergyUseCapita(countryName));
		return cs;
	}
	
	public CountryStats build7thStats(String countryName) {
		CountryStats cs = new CountryStats(countryName);
		cs.addStat(new Co2Intensity(countryName));
		return cs;
	}
	
	public CountryStats build8thStats(String countryName) {
		CountryStats cs = new CountryStats(countryName);
		cs.addStat(new GdpPerEnergy(countryName));
		return cs;
	}
	
}
