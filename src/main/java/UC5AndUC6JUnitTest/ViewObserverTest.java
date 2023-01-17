package UC5AndUC6JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import analysisInfo.AnalysisTypeSubjectAndObserver;
import analysisInfo.CountrySubject;
import analysisInfo.ViewObserver;
import analysisInfo.YearObserver;

public class ViewObserverTest {

	@Test
	public void test11() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		assertEquals(atso, vo.getSubject());
	}
	
	@Test
	public void test12() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		atso.selectAnalysisType("Energy use vs. CO2 intensity");
		assertEquals("ViewObserver analysisTypeState doesn't synchronize with AnalysisTypeSubjectAndObserver analysisTypeState",atso.getAnalysisTypeState(), vo.getAnalysisTypeState());
		assertEquals("Yearbserver analysisTypeState doesn't synchronize with AnalysisTypeSubjectAndObserver analysisTypeState",atso.getAnalysisTypeState(), yo.getAnalysisTypeState());
	}
	
	@Test
	public void test13() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		atso.selectAnalysisType("Energy use vs. CO2 intensity");
		assertFalse(vo.selectView("Pie Chart"));
	}
	
	@Test
	public void test14() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		atso.selectAnalysisType("GDP/Energy");
		assertFalse(vo.selectView("Pie Chart"));
	}
	
	@Test
	public void test15() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		atso.selectAnalysisType("Energy Related Methane Emissions");
		assertTrue(vo.selectView("Pie Chart"));
	}
	
	@Test
	public void test16() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		atso.selectAnalysisType("Methane emissions vs CO2 intensity");
		assertFalse("Bar chart doesn't accept stats with different unit", vo.selectView("Bar Chart"));
		assertFalse("Scatter chart doesn't accept stats with different unit", vo.selectView("Scatter Chart"));
		assertFalse("Time series chart doesn't accept stats with different unit", vo.selectView("Time Series Chart"));
	}
	
	@Test
	public void test17() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		atso.selectAnalysisType("Methane emissions vs CO2 intensity");
		assertTrue(vo.selectView("Line Chart"));
		assertTrue(vo.selectView("Report"));
	}

}
