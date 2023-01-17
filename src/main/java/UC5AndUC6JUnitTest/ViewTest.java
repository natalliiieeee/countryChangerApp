package UC5AndUC6JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import analysisInfo.AnalysisTypeSubjectAndObserver;
import analysisInfo.CountrySubject;
import analysisInfo.ViewObserver;
import analysisInfo.YearObserver;
import selectionHandler.View;

public class ViewTest {

	@Test
	public void test1() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		View v = new View(vo);
		assertEquals("Available Views: ", v.getViewsLabel().getText());
	}
	
	@Test
	public void test2() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		View v = new View(vo);
		assertEquals("Line Chart", v.getViewsList().getItemAt(0));
		assertEquals("Pie Chart", v.getViewsList().getItemAt(1));
		assertEquals("Bar Chart", v.getViewsList().getItemAt(2));
		assertEquals("Scatter Chart", v.getViewsList().getItemAt(3));
		assertEquals("Time Series Chart", v.getViewsList().getItemAt(4));
		assertEquals("Report", v.getViewsList().getItemAt(5));
	}

	@Test
	public void test3() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		View v = new View(vo);
		v.getViewsList().setSelectedItem("Report");
		assertEquals("Report", v.getSelectedView());
	}
	
	@Test
	public void test4() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		View v = new View(vo);
		v.getViewsList().setSelectedItem("Pie Chart");
		assertEquals("Line Chart", v.getSelectedView());
	}

}
