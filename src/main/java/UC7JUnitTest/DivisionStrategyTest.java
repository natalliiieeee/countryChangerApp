package UC7JUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dataProcessStrategy.DivisionStrategy;
import statBuilder.Co2Intensity;
import statBuilder.Population;
import statBuilder.Stat;

public class DivisionStrategyTest {

	@Test
	public void test() {
		ArrayList<Stat> s = new ArrayList<Stat>();
		s.add(new Co2Intensity("Brazil"));
		s.add(new Population("Brazil"));
		DivisionStrategy ds = new DivisionStrategy();		
		assertEquals(9.543393763046275E-9, ds.doDataProcessing(s, "2000"));
	}

}
