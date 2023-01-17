package UC7JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import analysisInfo.AnalysisTypeSubjectAndObserver;
import analysisInfo.CountrySubject;
import analysisInfo.ViewObserver;
import analysisInfo.YearObserver;
import selectionHandler.AnalysisType;
import statBuilder.CountryStats;
import statBuilder.CountryStatsBuilder;

public class AnalysisTypePerformedTest {

	@Test
	public void test5() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		AnalysisType at = new AnalysisType(atso);
		at.getMethodsList().setSelectedItem("Energy use vs. CO2 intensity");
		assertEquals("Energy use vs. CO2 intensity", at.getSelectedAnalysisType());
	}
	
	@Test
	public void test6() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		AnalysisType at = new AnalysisType(atso);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		CountryStatsBuilder csb = new CountryStatsBuilder();
		CountryStats css = csb.build2ndStats("Brazil");
		at.getMethodsList().setSelectedItem("Energy use vs. CO2 intensity");
		at.getRecalculate().doClick();
		assertEquals("\"Energy use (kg of oil equivalent per capita)\"", atso.getAnalysisTypeState().getStates().get(0).getIndicatorName());
	}
	


}
