package UC4JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import analysisInfo.AnalysisTypeSubjectAndObserver;
import analysisInfo.CountrySubject;
import analysisInfo.ViewObserver;
import analysisInfo.YearObserver;

public class YearObserverTest {

	@Test
	public void test8() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		YearObserver yo = new YearObserver(atso);
		for(int i = 0; i < 15; i++) {
			assertEquals("Wrong year in index "+i, 2010-i+"" , yo.getYear().get(i));
		}
	}
	
	@Test
	public void test9() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		YearObserver yo = new YearObserver(atso);
		assertEquals(atso, yo.getSubject());
	}
	
	@Test
	public void test10() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		assertEquals("Wrong chart in index 0!", "Line Chart", vo.getViews().get(0));
		assertEquals("Wrong chart in index 1!", "Pie Chart", vo.getViews().get(1));
		assertEquals("Wrong chart in index 2!", "Bar Chart", vo.getViews().get(2));
		assertEquals("Wrong chart in index 3!", "Scatter Chart", vo.getViews().get(3));
		assertEquals("Wrong chart in index 4!", "Time Series Chart", vo.getViews().get(4));
		assertEquals("Wrong chart in index 5!", "Report", vo.getViews().get(5));
	}
	
	@Test
	public void test18() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		atso.selectAnalysisType("Energy Related Methane Emissions");
		assertFalse(yo.selectYear("2100"));
	}
	
	@Test
	public void test19() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		atso.selectAnalysisType("Energy Related Methane Emissions");
		assertTrue(yo.selectYear("2008"));
	}

}
