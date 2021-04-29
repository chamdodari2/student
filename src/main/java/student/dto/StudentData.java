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
	private int subject1; // 과목1   ///////아직 impl에서 여기에 db연결 안해줬다
	private int subject2; // 과목2
	private int subject3; // 과목3

	private int total;
	private double avg;
	private String pic;
	private int num;
	
    private List<StudentScore> studentScore; //성적테이블(과목 1,2,3) 리스트로 받아야 묶어서받을수있다
    
   // private String abc ="";/////////////
  //  private double gradescore= 0.0;////////////////지울거면 get set도 지우기
    
//select stdNo, stdName, deptCode, grade, stateCode, militaryCode, idNo, hpNo, dayNightShift from studentdata;


	public StudentData(List<StudentScore> studentScore) {
		this.studentScore = studentScore;
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

	public StudentData(int stdNo) {
		this.stdNo = stdNo;
	}

	
	
	
	public StudentData(String pic) {
		this.pic = pic;
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
			MilitaryState militaryState, String dayNightShift) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdDepartment = stdDepartment;
		this.grade = grade;
		this.stdState = stdState;
		this.militaryState = militaryState;
		this.dayNightShift = dayNightShift;
	}

	
	public StudentData() {
		// TODO Auto-generated constructor stub
	}

	public StudentData(int stdNo, String stdName, StdDepartment stdDepartment, List<StudentScore> studentScore) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdDepartment = stdDepartment;
		this.studentScore = studentScore;
	}





	public StudentData(int stdNo, String stdName, StdDepartment stdDepartment, int grade, String dayNightShift,
			int subject1, int subject2, int subject3) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdDepartment = stdDepartment;
		this.grade = grade;
		this.dayNightShift = dayNightShift;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	}
	
	

	public StudentData(int stdNo, String stdName, StdDepartment stdDepartment, int grade, StdState stdState,
			MilitaryState militaryState, String idNo, String gender, String hpNo, String dayNightShift, int subject1,
			int subject2, int subject3, int total, double avg, String pic, List<StudentScore> studentScore) {
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
		this.pic = pic;
		this.studentScore = studentScore;
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



	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public StudentData(int stdNo, String stdName, StdDepartment stdDepartment, int grade, StdState stdState,
			MilitaryState militaryState, String idNo, String hpNo, String dayNightShift, String pic) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdDepartment = stdDepartment;
		this.grade = grade;
		this.stdState = stdState;
		this.militaryState = militaryState;
		this.idNo = idNo;
		this.hpNo = hpNo;
		this.dayNightShift = dayNightShift;
		this.pic = pic;
	}
	//stdNo, stdName, stdDepartment, grade, stdState, militaryState, idNo, gender, hpNo,
		//dayNightShift, subject1, subject2, subject3, total, avg, pic
		
		
	

	public String getPic() {
		return pic;
	}

	public StudentData(int stdNo, String stdName, StdDepartment stdDepartment, int grade, StdState stdState,
			MilitaryState militaryState, String idNo, String gender, String hpNo, String dayNightShift, int subject1,
			int subject2, int subject3, int total, double avg, String pic) {
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
		this.pic = pic;
	}

	
	public StudentData(int stdNo, String stdName, StdDepartment stdDepartment, int grade, StdState stdState,
			MilitaryState militaryState, String idNo, String gender, String hpNo, String dayNightShift, int subject1,
			int subject2, int subject3, int total, double avg, String pic, int num) {
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
		this.pic = pic;
		this.num = num;
		
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stdNo;
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
		if (stdNo != other.stdNo)
			return false;
		return true;
	}

	
	
	
	public String toString6() {
		return String.format("%s",pic);
	}
	
	
	
	public String toString4() {
		return String.format("%s(%s)",stdNo,stdName);
	}
	public String toString3() {
		return String.format("%s",dayNightShift);
	}
	public String toString2() {
		return String.format(
				"%s",
				stdNo, stdName, stdDepartment.getDeptCode(),stdDepartment.getDeptName(),  grade, stdState.getStateCode(),stdState.getStateName(), militaryState.getMilitaryCode(), militaryState.getMilitaryName(), idNo, gender, hpNo, dayNightShift,
				subject1, subject2, subject3, total, avg );
	}
	public String toString11() {
		return String.format(
				" 학번 : %s, 이름 : %s, 학과코드 : %s, 학과명 : %s, 학년 : %s, 학적상태코드 : %s, 학적상태명 : %s, 병역상태코드 : %s, 병역상태명 : %s, 주민번호 :  %s, 성별 : %s, 연락처 : %s, 주야구분 : %s, 국어성적 : %s, 영어성적 : %s, 수학성적 : %s, 총점 :  %s, 평균 : %.1f",
				stdNo, stdName, stdDepartment.getDeptCode(),stdDepartment.getDeptName(),  grade, stdState.getStateCode(),stdState.getStateName(), militaryState.getMilitaryCode(), militaryState.getMilitaryName(), idNo, gender, hpNo, dayNightShift,
				subject1, subject2, subject3, total, avg );
	}
	@Override
	public String toString() {
		return String.format("StudentData [stdNo=%s, stdName=%s, stdDepartment=%s, subject1=%s, subject2=%s, subject3=%s, avg=%.1f, num=%s]", stdNo,
				stdName, stdDepartment.getDeptCode(), subject1, subject2, subject3, avg,num);
	}

	public String toString5() {
		return String.format(
				"%.1f",avg );
	}

	
	public String toString7() {
		if(pic!=null) {	
		return String.format("O");
	}else {
		return String.format("X");
				}
	}
	
}


