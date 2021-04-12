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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((militaryCode == null) ? 0 : militaryCode.hashCode());
		result = prime * result + ((militaryName == null) ? 0 : militaryName.hashCode());
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
		MilitaryState other = (MilitaryState) obj;
		if (militaryCode == null) {
			if (other.militaryCode != null)
				return false;
		} else if (!militaryCode.equals(other.militaryCode))
			return false;
		if (militaryName == null) {
			if (other.militaryName != null)
				return false;
		} else if (!militaryName.equals(other.militaryName))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return String.format("%s(%s)", militaryName, militaryCode);
	}
	public String toString2() {
		return String.format("%s(%s)", militaryName, militaryCode);
	}

}
