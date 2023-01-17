package UC2JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import analysisInfo.AnalysisTypeSubjectAndObserver;
import analysisInfo.CountrySubject;

public class CountrySubjectTest {

	@Test
	public void test1() {
		CountrySubject cs = new CountrySubject();
		assertEquals("Wrong country in index 0!", "Brazil", cs.getCountries().get(0));
		assertEquals("Wrong country in index 1!", "Canada", cs.getCountries().get(1));
		assertEquals("Wrong country in index 2!", "Italy", cs.getCountries().get(2));
		assertEquals("Wrong country in index 3!", "United States", cs.getCountries().get(3));
		assertEquals("Wrong country in index 4!", "United Kingdom", cs.getCountries().get(4));
		assertEquals("Wrong country in index 5!", "Frence", cs.getCountries().get(5));
	}
	
	@Test
	public void test2() {
		CountrySubject cs = new CountrySubject();
		assertEquals("Brazil", cs.getCountryState());
	}
	
	@Test
	public void test3() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		assertEquals(cs, atso.getCountry());
	}
	
	@Test
	public void test4() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		assertEquals(atso, cs.getAnalysisType());
	}
	
	@Test
	public void test5() {
		CountrySubject cs = new CountrySubject();
		assertFalse(cs.selectCountry("Frence"));
	}
	
	@Test
	public void test6() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		cs.selectCountry("Italy");
		assertEquals("Italy", cs.getCountryState());
	}
	


}
