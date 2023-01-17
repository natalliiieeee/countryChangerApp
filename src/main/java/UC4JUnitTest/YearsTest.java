package UC4JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import analysisInfo.AnalysisTypeSubjectAndObserver;
import analysisInfo.CountrySubject;
import analysisInfo.ViewObserver;
import analysisInfo.YearObserver;
import selectionHandler.Years;

public class YearsTest {

	@Test
	public void test1() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		Years y = new Years(yo);
		assertEquals("From", y.getFrom().getText());
	}
	
	@Test
	public void test2() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		Years y = new Years(yo);
		assertEquals("To", y.getTo().getText());
	}
	
	@Test
	public void test3() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		Years y = new Years(yo);
		int j = 0;
		for(int i = 2010; i >= 1995; i--) {
			assertEquals(""+i, y.getFromList().getItemAt(j));
			assertEquals(""+i, y.getToList().getItemAt(j));
			j++;
		}
	}
	
	@Test
	public void test4() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		Years y = new Years(yo);
		y.getFromList().setSelectedItem("1998");
		assertEquals("1998", y.getSelectedStartYear());
	}
	
	@Test
	public void test5() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		ViewObserver vo = new ViewObserver(atso);
		YearObserver yo = new YearObserver(atso);
		Years y = new Years(yo);
		y.getFromList().setSelectedItem("2008");
		y.getToList().setSelectedItem("1999");
		assertEquals("2010", y.getSelectedEndYear());
	}

}
