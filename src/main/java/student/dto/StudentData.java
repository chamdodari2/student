package student.dto;

import java.util.List;

public class StudentData { ////// 여기에 점수도 들어가있어야한다!!!! 한꺼번에 3과목이어야하니까 배열이나 리스트로 받아오기!!!!!!!!!!!!!!
	private int stdNo; // 학번
	private String stdName; // 이름
	private StdDepartment stdDepartment; // 학과테이블
	private int grade; // 학년
	private StdState stdState; // 학적테이블(재학 등)
	private MilitaryState militaryState; // 병역테이블(미필 등)

	private String idNo; // 주민번호
	private String gender; // 성별 뷰에만 있는거
	private String hpNo; // 휴대폰번호
	private String dayNightShift; // 주야
	private int subject1; // 과목1
	private int subject2; // 과목2
	private int subject3; // 과목3

	private int total;
	private double avg;

    private List<StudentScore> studentScore; //성적테이블(과목 1,2,3)
    
   // private String abc ="";/////////////
  //  private double gradescore= 0.0;////////////////지울거면 get set도 지우기
    



	public StudentData(List<StudentScore> studentScore) {
		this.studentScore = studentScore;
	}

	public StudentData(int stdNo) {
		this.stdNo = stdNo;
	}

	
	
	
	public StudentData(StdDepartment stdDepartment, int grade, StdState stdState, String dayNightShift) {
		this.stdDepartment = stdDepartment;
		this.grade = grade;
		this.stdState = stdState;
		this.dayNightShift = dayNightShift;
	}

	public StudentData(int stdNo, String stdName, StdDepartment stdDepartment, int grade, StdState stdState,
			MilitaryState militaryState, String idNo, String gender, String hpNo, String dayNightShift, int subject1,
			int subject2, int subject3, int total, double avg) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdDepartment = stdDepartment;
		this.grade = grade;
		this.stdState = stdState;
		this.militaryState = militaryState;
		this.idNo = idNo;
		this.gender = gender;
		this.hpNo = hpNo;
		this.dayNightShift = dayNightShift;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.total = total;
		this.avg = avg;
		
	}



	public StudentData(int stdNo, String stdName, StdDepartment stdDepartment, int grade, StdState stdState,
			MilitaryState militaryState, String idNo, String hpNo, String dayNightShift) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdDepartment = stdDepartment;
		this.grade = grade;
		this.stdState = stdState;
		this.militaryState = militaryState;
		this.idNo = idNo;
		this.hpNo = hpNo;
		this.dayNightShift = dayNightShift;
	}

	public StudentData() {
		// TODO Auto-generated constructor stub
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

	public StdDepartment getStdDepartment() {
		return stdDepartment;
	}

	public void setStdDepartment(StdDepartment stdDepartment) {
		this.stdDepartment = stdDepartment;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public StdState getStdState() {
		return stdState;
	}

	public void setStdState(StdState stdState) {
		this.stdState = stdState;
	}

	public MilitaryState getMilitaryState() {
		return militaryState;
	}

	public void setMilitaryState(MilitaryState militaryState) {
		this.militaryState = militaryState;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHpNo() {
		return hpNo;
	}

	public void setHpNo(String hpNo) {
		this.hpNo = hpNo;
	}

	public String getDayNightShift() {
		return dayNightShift;
	}

	public void setDayNightShift(String dayNightShift) {
		this.dayNightShift = dayNightShift;
	}

	public int getSubject1() {
		return subject1;
	}

	public void setSubject1(int subject1) {
		this.subject1 = subject1;
	}

	public int getSubject2() {
		return subject2;
	}

	public void setSubject2(int subject2) {
		this.subject2 = subject2;
	}

	public int getSubject3() {
		return subject3;
	}

	public void setSubject3(int subject3) {
		this.subject3 = subject3;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public List<StudentScore> getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(List<StudentScore> studentScore) {
		this.studentScore = studentScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dayNightShift == null) ? 0 : dayNightShift.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + grade;
		result = prime * result + ((hpNo == null) ? 0 : hpNo.hashCode());
		result = prime * result + ((idNo == null) ? 0 : idNo.hashCode());
		result = prime * result + ((militaryState == null) ? 0 : militaryState.hashCode());
		result = prime * result + ((stdDepartment == null) ? 0 : stdDepartment.hashCode());
		result = prime * result + ((stdName == null) ? 0 : stdName.hashCode());
		result = prime * result + stdNo;
		result = prime * result + ((stdState == null) ? 0 : stdState.hashCode());
		result = prime * result + ((studentScore == null) ? 0 : studentScore.hashCode());
		result = prime * result + subject1;
		result = prime * result + subject2;
		result = prime * result + subject3;
		result = prime * result + total;
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
		StudentData other = (StudentData) obj;
		if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
			return false;
		if (dayNightShift == null) {
			if (other.dayNightShift != null)
				return false;
		} else if (!dayNightShift.equals(other.dayNightShift))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (grade != other.grade)
			return false;
		if (hpNo == null) {
			if (other.hpNo != null)
				return false;
		} else if (!hpNo.equals(other.hpNo))
			return false;
		if (idNo == null) {
			if (other.idNo != null)
				return false;
		} else if (!idNo.equals(other.idNo))
			return false;
		if (militaryState == null) {
			if (other.militaryState != null)
				return false;
		} else if (!militaryState.equals(other.militaryState))
			return false;
		if (stdDepartment == null) {
			if (other.stdDepartment != null)
				return false;
		} else if (!stdDepartment.equals(other.stdDepartment))
			return false;
		if (stdName == null) {
			if (other.stdName != null)
				return false;
		} else if (!stdName.equals(other.stdName))
			return false;
		if (stdNo != other.stdNo)
			return false;
		if (stdState == null) {
			if (other.stdState != null)
				return false;
		} else if (!stdState.equals(other.stdState))
			return false;
		if (studentScore == null) {
			if (other.studentScore != null)
				return false;
		} else if (!studentScore.equals(other.studentScore))
			return false;
		if (subject1 != other.subject1)
			return false;
		if (subject2 != other.subject2)
			return false;
		if (subject3 != other.subject3)
			return false;
		if (total != other.total)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				" 학번 : %s, 이름 : %s, 학과코드 : %s, 학과명 : %s, 학년 : %s, 학적상태코드 : %s, 학적상태명 : %s, 병역상태코드 : %s, 병역상태명 : %s, 주민번호 :  %s, 성별 : %s, 연락처 : %s, 주야구분 : %s, 과목1성적 : %s, 과목2성적 : %s, 과목3성적 : %s, 총점 :  %s, 평균 : %.1f",
				stdNo, stdName, stdDepartment.getDeptCode(),stdDepartment.getDeptName(),  grade, stdState.getStateCode(),stdState.getStateName(), militaryState.getMilitaryCode(), militaryState.getMilitaryName(), idNo, gender, hpNo, dayNightShift,
				subject1, subject2, subject3, total, avg );
	}
	public String toString2() {
		return String.format(
				"%s",
				stdNo, stdName, stdDepartment.getDeptCode(),stdDepartment.getDeptName(),  grade, stdState.getStateCode(),stdState.getStateName(), militaryState.getMilitaryCode(), militaryState.getMilitaryName(), idNo, gender, hpNo, dayNightShift,
				subject1, subject2, subject3, total, avg );
	}
	// 성적환산표
	

}
