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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentData == null) ? 0 : studentData.hashCode());
		result = prime * result + subject1;
		result = prime * result + subject2;
		result = prime * result + subject3;
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
		StudentScore other = (StudentScore) obj;
		if (studentData == null) {
			if (other.studentData != null)
				return false;
		} else if (!studentData.equals(other.studentData))
			return false;
		if (subject1 != other.subject1)
			return false;
		if (subject2 != other.subject2)
			return false;
		if (subject3 != other.subject3)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.format("%s  1과목 : %s점, 2과목 : %s점, 3과목 : %s점 ", studentData.getStdNo(),
				subject1, subject2, subject3);
	}
	

	


	

}
