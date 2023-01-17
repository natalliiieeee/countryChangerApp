package analysisInfo;

import java.util.Vector;

public class ViewObserver extends Observer{
	private Vector<String> views;
	
	public ViewObserver(AnalysisTypeSubjectAndObserver s) {
		super(s);
		this.subject.attach(this);
		this.views = new Vector<String>();
		this.views.add("Line Chart");
		this.views.add("Pie Chart");
		this.views.add("Bar Chart");
		this.views.add("Scatter Chart");
		this.views.add("Time Series Chart");
		this.views.add("Report");
	}
	
	public boolean selectView(String v) {
		boolean isAllowed = true;
		String unit = "";
		if(v.equals(this.views.get(1))) {
			if(this.analysisTypeState.getStates().size() > 1 || !this.analysisTypeState.getStates().get(0).getUnit().equals("\"%\"")) {
				isAllowed = false;
			}
		}else if(v.equals(this.views.get(2)) || v.equals(this.views.get(3)) || v.equals(this.views.get(4))){
			for(int i = 0; i < this.analysisTypeState.getStates().size(); i++) {
				if(i == 0) {
					unit = this.analysisTypeState.getStates().get(i).getUnit();
				}else {
					if(!unit.equals(this.analysisTypeState.getStates().get(i).getUnit())){
						isAllowed = false;
					}
				}
			}
		}
		return isAllowed;
	}
	
	public Vector<String> getViews(){
		return this.views;
	}
}
