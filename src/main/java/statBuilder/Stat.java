package statBuilder;

import com.google.gson.JsonObject;

public abstract class Stat {

	protected String indicatorName;
	protected JsonObject stat;
	protected String unit;
	
	public String getIndicatorName() {
		return this.indicatorName;
	}
	public JsonObject getStat() {
		return this.stat;
	}
	public String getUnit() {
		return this.unit;
	}

}
