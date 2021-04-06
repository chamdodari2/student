package student.dto;

import java.util.List;

public class StdDepartment {
	private String deptCode;
	private String deptName;
	
	private List<StudentData> stdlist;//////////

	
	
	
	
	public StdDepartment(String deptCode) {
		this.deptCode = deptCode;
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
	public String toString() {
		return String.format("StdDepartment [deptCode=%s, deptName=%s, stdlist=%s]", deptCode, deptName, stdlist);
	}
	public String toString2() {
		return String.format("%s(%s)", deptName, deptCode);
	}
	

}
