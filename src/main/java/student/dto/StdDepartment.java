package student.dto;

import java.util.List;

public class StdDepartment {
	private String deptCode;
	private String deptName;
	
	private List<StudentData> stdlist;//////////

	
	
	
	
	public StdDepartment() {
		
	}

	public StdDepartment(String deptCode) {
		this.deptCode = deptCode;
	}

	public StdDepartment(String deptCode, String deptName) {
		this.deptCode = deptCode;
		this.deptName = deptName;
	}

	public StdDepartment(String deptCode, String deptName, List<StudentData> stdlist) {
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.stdlist = stdlist;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<StudentData> getStdlist() {
		return stdlist;
	}

	public void setStdlist(List<StudentData> stdlist) {
		this.stdlist = stdlist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptCode == null) ? 0 : deptCode.hashCode());
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		result = prime * result + ((stdlist == null) ? 0 : stdlist.hashCode());
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
		StdDepartment other = (StdDepartment) obj;
		if (deptCode == null) {
			if (other.deptCode != null)
				return false;
		} else if (!deptCode.equals(other.deptCode))
			return false;
		if (deptName == null) {
			if (other.deptName != null)
				return false;
		} else if (!deptName.equals(other.deptName))
			return false;
		if (stdlist == null) {
			if (other.stdlist != null)
				return false;
		} else if (!stdlist.equals(other.stdlist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(deptCode != null) {
		return String.format("%s", deptName);
		}else { 
			return String.format("");
		}
	}
	public String toString2() {
		return String.format("%s(%s)", deptName, deptCode);
	}
	
	

}
