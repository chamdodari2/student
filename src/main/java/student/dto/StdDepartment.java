package student.dto;

import java.util.List;

public class StdDepartment {
	private String deptCode;
	private String deptName;
	
	private List<StudentData> stdlist;//////////
	
	public StdDepartment(String deptCode) {
		this.deptCode = deptCode;
	}

	public StdDepartment(String deptCode, String deptName) {
		this.deptCode = deptCode;
		this.deptName = deptName;
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

	
	@Override
	public String toString() {
		return String.format("Department [deptCode=%s, deptName=%s]", deptCode, deptName);
	}
	

}
