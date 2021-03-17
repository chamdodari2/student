package student.dto;

public class StdState  { //기본정렬을 학번으로 한다는뜻 

	private String stateCode; // 학적코드
	private String stateName; // 학적구분
	
	
	
	
	
	public StdState(String stateCode) {
		this.stateCode = stateCode;
	}





	public StdState(String stateCode, String stateName) {
		this.stateCode = stateCode;
		this.stateName = stateName;
	}





	public String getStateCode() {
		return stateCode;
	}





	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}





	public String getStateName() {
		return stateName;
	}





	public void setStateName(String stateName) {
		this.stateName = stateName;
	}





	@Override
	public String toString() {
		return String.format("StdState [stateCode=%s, stateName=%s]", stateCode, stateName);
	}
	


	


}
