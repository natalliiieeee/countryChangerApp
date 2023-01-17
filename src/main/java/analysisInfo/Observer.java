package analysisInfo;

import statBuilder.CountryStats;

public class Observer {
	protected AnalysisTypeSubjectAndObserver subject;
	protected CountryStats analysisTypeState;
	
	public Observer(AnalysisTypeSubjectAndObserver s) {
		this.subject = s;
		this.analysisTypeState = s.getAnalysisTypeState();
	}
	
	public void update(CountryStats ats) {
		this.analysisTypeState = ats;
	}
	
	public AnalysisTypeSubjectAndObserver getSubject() {
		return this.subject;
	}
	
	public CountryStats getAnalysisTypeState() {
		return this.analysisTypeState;
	}
}
