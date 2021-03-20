package student.dto;

public class StudentScore {
	private StudentData studentData;
	private int subject1;
	private int subject2;
	private int subject3;
	
	
	
	
	public StudentScore(StudentData studentData) {
		this.studentData = studentData;
	}

	
	public StudentScore(StudentData studentData, int subject1, int subject2, int subject3) {
		this.studentData = studentData;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	}

	
	
	


	public StudentData getStudentData() {
		return studentData;
	}

	public void setStudentData(StudentData studentData) {
		this.studentData = studentData;
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


	@Override
	public String toString() {
		return String.format("StudentScore [studentData=%s, subject1=%s, subject2=%s, subject3=%s]", studentData,
				subject1, subject2, subject3);
	}
	

	


	

}
