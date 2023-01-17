package analysisInfo;

import java.util.Vector;

import statBuilder.Stat;

public class YearObserver extends Observer{
	private Vector<String> year;
	
	public YearObserver(AnalysisTypeSubjectAndObserver s) {
		super(s);
		this.subject.attach(this);
		this.year = new Vector<String>();
		for(int i = 2010; i >= 1995; i--) {
			this.year.add(""+i);
		}
	}
	
	public boolean selectYear(String year) {
		boolean isAllowed = true;
		for(Stat s : this.analysisTypeState.getStates()) {
			System.out.println(s.getIndicatorName());
			if(!s.getStat().has(year)) {
				isAllowed = false;
			}
		}
		return isAllowed;
	}
	
	public Vector<String> getYear(){
		return this.year;
	}
	
}
