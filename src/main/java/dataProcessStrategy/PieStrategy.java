package dataProcessStrategy;

import java.util.List;

import statBuilder.Stat;

public class PieStrategy implements Strategy{
	public Number doDataProcessing(List<Stat> s, String y) {
		double o = s.get(0).getStat().getAsJsonPrimitive(y).getAsDouble();
		return 100 - o;
	}
}
