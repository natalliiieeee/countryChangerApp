package dataProcessStrategy;

import java.util.List;

import statBuilder.Stat;

public class DivisionStrategy implements Strategy{
	
	public Number doDataProcessing(List<Stat> s, String y) {
		double o1 = s.get(0).getStat().getAsJsonPrimitive(y).getAsDouble();
		double o2 = s.get(1).getStat().getAsJsonPrimitive(y).getAsDouble();
		return o1/o2;
	}
	
}
