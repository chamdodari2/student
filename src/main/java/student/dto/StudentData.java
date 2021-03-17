package student.dto;

import java.util.List;

public class StudentData {  //////여기에 점수도 들어가있어야한다!!!! 한꺼번에 3과목이어야하니까 배열이나 리스트로 받아오기!!!!!!!!!!!!!!
	private int stdNo; //학번
	private String stdName; //이름
	private StdDepartment deptCode;  //학과이름
	private int grade;  //학년
	private StdState stateCode;  //학적코드(재학 등)	
//	private StdState stateName;  //학적구분
	private MilitaryState militaryCode; //병역코드(미필 등)
//	private MilitaryState militaryName; //병역구분(미필 등)
	
	private String idNo;	//주민번호
	private String hpNo;	//휴대폰번호
	private String dayNighShift;	//주야
	
//수정중
	private  List<StudentScore> studentScore;  //성적(과목 1,2,3)
	private  List<GradeConvertion> gradeConvertion;
	//end
	
	
	
	
	
	public StudentData(int stdNo) {
		this.stdNo = stdNo;
	}
	
	
	
	
	public StudentData(String dayNighShift) {
		this.dayNighShift = dayNighShift;
	}




	public StudentData(int stdNo, String stdName, StdState stateCode) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stateCode = stateCode;
	}




	public StudentData(int stdNo, String stdName, StdDepartment deptCode, int grade, StdState stateCode,
			MilitaryState militaryCode, String idNo, String hpNo, String dayNighShift, List<StudentScore> studentScore,
			List<GradeConvertion> gradeConvertion) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.deptCode = deptCode;
		this.grade = grade;
		this.stateCode = stateCode;
		this.militaryCode = militaryCode;
		this.idNo = idNo;
		this.hpNo = hpNo;
		this.dayNighShift = dayNighShift;
		this.studentScore = studentScore;
		this.gradeConvertion = gradeConvertion;
	}




	public int getStdNo() {
		return stdNo;
	}




	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}




	public String getStdName() {
		return stdName;
	}




	public void setStdName(String stdName) {
		this.stdName = stdName;
	}




	public StdDepartment getDeptCode() {
		return deptCode;
	}




	public void setDeptCode(StdDepartment deptCode) {
		this.deptCode = deptCode;
	}




	public int getGrade() {
		return grade;
	}




	public void setGrade(int grade) {
		this.grade = grade;
	}




	public StdState getStateCode() {
		return stateCode;
	}




	public void setStateCode(StdState stateCode) {
		this.stateCode = stateCode;
	}




	public MilitaryState getMilitaryCode() {
		return militaryCode;
	}




	public void setMilitaryCode(MilitaryState militaryCode) {
		this.militaryCode = militaryCode;
	}




	public String getIdNo() {
		return idNo;
	}




	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}




	public String getHpNo() {
		return hpNo;
	}




	public void setHpNo(String hpNo) {
		this.hpNo = hpNo;
	}




	public String getDayNighShift() {
		return dayNighShift;
	}




	public void setDayNighShift(String dayNighShift) {
		this.dayNighShift = dayNighShift;
	}




	public List<StudentScore> getStudentScore() {
		return studentScore;
	}




	public void setStudentScore(List<StudentScore> studentScore) {
		this.studentScore = studentScore;
	}




	public List<GradeConvertion> getGradeConvertion() {
		return gradeConvertion;
	}




	public void setGradeConvertion(List<GradeConvertion> gradeConvertion) {
		this.gradeConvertion = gradeConvertion;
	}




	@Override
	public String toString() {
		return String.format("StudentManagement [stdNo=%s, stdName=%s, stateCode=%s]", stdNo, stdName, stateCode);
	}




//	@Override
//	public String toString() {
//		return String.format(
//				"StudentManagement [stdNo=%s, stdName=%s, deptCode=%s, grade=%s, stateCode=%s, militaryCode=%s, idNo=%s, hpNo=%s, dayNighShift=%s, studentScore=%s, gradeConvertion=%s]",
//				stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo, dayNighShift, studentScore,
//				gradeConvertion);
//	}






	
	
	
	

	
}
