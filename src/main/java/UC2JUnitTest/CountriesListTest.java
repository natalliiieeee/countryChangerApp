package UC2JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import analysisInfo.AnalysisTypeSubjectAndObserver;
import analysisInfo.CountrySubject;
import selectionHandler.CountriesList;

public class CountriesListTest {

	@Test
	public void test1() {
		CountrySubject cs = new CountrySubject();
		CountriesList cl = new CountriesList(cs);
		String str = "Choose a country: ";
		assertEquals(str, cl.getChooseCountryLabel().getText());
	}
	
	@Test
	public void test2() {
		CountrySubject cs = new CountrySubject();
		CountriesList cl = new CountriesList(cs);
		assertEquals("Brazil", cl.getCountriesList().getItemAt(0));
		assertEquals("Canada", cl.getCountriesList().getItemAt(1));
		assertEquals("Italy", cl.getCountriesList().getItemAt(2));
		assertEquals("United States", cl.getCountriesList().getItemAt(3));
		assertEquals("United Kingdom", cl.getCountriesList().getItemAt(4));
		assertEquals("Frence", cl.getCountriesList().getItemAt(5));
	}
	
	@Test
	public void test3() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		CountriesList cl = new CountriesList(cs);
		assertEquals("Brazil", cl.getSelectedCountry());
	}
	
	@Test
	public void test4() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		CountriesList cl = new CountriesList(cs);
		cl.getCountriesList().setSelectedItem("Canada");
		assertEquals("Canada", cl.getSelectedCountry());
	}
	
	@Test
	public void test5() {
		CountrySubject cs = new CountrySubject();
		AnalysisTypeSubjectAndObserver atso = new AnalysisTypeSubjectAndObserver(cs);
		CountriesList cl = new CountriesList(cs);
		cl.getCountriesList().setSelectedItem("Frence");
		assertEquals("Brazil", cl.getSelectedCountry());
	}
	
	

}
