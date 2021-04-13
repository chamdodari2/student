package student.dto;

public class StdState  { //기본정렬을 학번으로 한다는뜻 

	private String stateCode; // 학적코드
	private String stateName; // 학적구분
	
	
	
	
	
	public StdState() {
		// TODO Auto-generated constructor stub
	}





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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stateCode == null) ? 0 : stateCode.hashCode());
		result = prime * result + ((stateName == null) ? 0 : stateName.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StdState other = (StdState) obj;
		if (stateCode == null) {
			if (other.stateCode != null)
				return false;
		} else if (!stateCode.equals(other.stateCode))
			return false;
		if (stateName == null) {
			if (other.stateName != null)
				return false;
		} else if (!stateName.equals(other.stateName))
			return false;
		return true;
	}





	@Override
	public String toString() {
		if(stateCode!=null) {
		return String.format("%s(%s)",stateName,stateCode);
		}else {
			return String.format("");
		}
	}
	
	public String toString2() {
		return String.format("%s(%s)",stateName,stateCode);
	}

	


}
