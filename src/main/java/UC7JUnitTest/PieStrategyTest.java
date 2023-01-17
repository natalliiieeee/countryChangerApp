package UC7JUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dataProcessStrategy.PieStrategy;
import statBuilder.EnergyRelatedMethaneEmissions;
import statBuilder.Stat;

public class PieStrategyTest {

	@Test
	public void test() {
		ArrayList<Stat> s = new ArrayList<Stat>();
		s.add(new EnergyRelatedMethaneEmissions("Brazil"));
		PieStrategy ps = new PieStrategy();
		assertEquals(96.06722585798998, ps.doDataProcessing(s, "2000"));
	}

}
