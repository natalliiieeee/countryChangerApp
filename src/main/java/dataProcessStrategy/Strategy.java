package dataProcessStrategy;

import java.util.List;

import statBuilder.Stat;

public interface Strategy {
	
	public abstract Number doDataProcessing(List<Stat> s, String y);
}
