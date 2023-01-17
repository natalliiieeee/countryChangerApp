package UC8JUnitTest;

import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.junit.Test;

import statBuilder.CountryStats;
import statBuilder.CountryStatsBuilder;
import viewFactory.Report;

public class ReportTest {

	@Test
	public void test1() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build2ndStats("Brazil");
		Report chart = new Report(new JPanel(), "Energy use vs. CO2 intensity", "1998", "2008", cs);
		String content = "Energy use vs. CO2 intensity" + "\n==============================\n";
		for(int i = 1998; i <= 2008; i++) {
			content += "Year " + i + ":\n";
			for(int j = 0; j < cs.getStates().size(); j++) {
				content += "\t" + cs.getStates().get(j).getIndicatorName() + "=>" 
						+ cs.getStates().get(j).getStat().getAsJsonPrimitive(""+i).getAsNumber() + "\n";
			}
		}
		assertEquals(content, chart.getContent());
	}
	
	@Test
	public void test2() {
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats cs = csb.build1stStats("Brazil");
		Report chart = new Report(new JPanel(), "Energy Depletion/Population", "1998", "2008", cs);
		String content = "Energy Depletion/Population" + "\n==============================\n";
		for(int i = 1998; i <= 2008; i++) {
			content += "Year " + i + ":\n";
			content += "\t" + "Energy Depletion/Population" + "=>" 
						+ cs.executeStrategy(""+i) + "\n";
		}
		assertEquals(content, chart.getContent());
	}

}
