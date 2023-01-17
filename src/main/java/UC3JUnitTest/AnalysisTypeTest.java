package UC3JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import analysisInfo.AnalysisTypeSubjectAndObserver;
import analysisInfo.CountrySubject;
import analysisInfo.ViewObserver;
import analysisInfo.YearObserver;
import selectionHandler.AnalysisType;
import statBuilder.CountryStats;
import statBuilder.CountryStatsBuilder;

public class AnalysisTypeTest {

	@Test
	public void test1() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		AnalysisType at = new AnalysisType(atso);
		assertEquals("Recalculate", at.getRecalculate().getText());
	}
	
	@Test
	public void test2() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		AnalysisType at = new AnalysisType(atso);
		assertEquals("        Choose analysis method: ", at.getMethodLabel().getText());
	}
	
	@Test
	public void test3() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		AnalysisType at = new AnalysisType(atso);
		assertEquals("Energy Depletion/Population", at.getMethodsList().getItemAt(0));
		assertEquals("Energy use vs. CO2 intensity", at.getMethodsList().getItemAt(1));
		assertEquals("Methane emissions vs CO2 intensity", at.getMethodsList().getItemAt(2));
		assertEquals("Methane emissions vs Energy related methane emissions", at.getMethodsList().getItemAt(3));
		assertEquals("Energy Related Methane Emissions", at.getMethodsList().getItemAt(4));
		assertEquals("Energy Use", at.getMethodsList().getItemAt(5));
		assertEquals("CO2 intensity", at.getMethodsList().getItemAt(6));
		assertEquals("GDP/Energy", at.getMethodsList().getItemAt(7));	
	}
	
	@Test
	public void test4() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		AnalysisType at = new AnalysisType(atso);
		assertEquals("Energy Depletion/Population", at.getSelectedAnalysisType());
	}
	
	
	@Test
	public void test7() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		cs.selectCountry("Brazil");
		assertEquals("Brazil", atso.getCountryState());
	}

}
