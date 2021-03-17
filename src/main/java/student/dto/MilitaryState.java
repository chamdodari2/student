package student.dto;

public class MilitaryState {
	private String militaryCode;  //병역코드
	private String militaryName;  //병역구분
	
	
	public MilitaryState(String militaryCode) {
		this.militaryCode = militaryCode;
	}

	

	public MilitaryState(String militaryCode, String militaryName) {
		this.militaryCode = militaryCode;
		this.militaryName = militaryName;
	}


	public String getMilitaryCode() {
		return militaryCode;
	}

	public void setMilitaryCode(String militaryCode) {
		this.militaryCode = militaryCode;
	}

	public String getMilitaryName() {
		return militaryName;
	}

	public void setMilitaryName(String militaryName) {
		this.militaryName = militaryName;
	}

	@Override
	public String toString() {
		return String.format("MilitaryState [militaryCode=%s, militaryName=%s]", militaryCode, militaryName);
	}
	

}
