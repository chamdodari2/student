package student.dto;

public class StudentScore {
	private int stdNo;
	private int subject1;
	private int subject2;
	private int subject3;
	private int total;
	private double avg;
	
	public StudentScore() {
		// TODO Auto-generated constructor stub
	}
	
	

	public StudentScore(int stdNo) {
		this.stdNo = stdNo;
	}



	public StudentScore(int stdNo, int subject1, int subject2, int subject3, int total, double avg) {
		this.stdNo = stdNo;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.total = total;
		this.avg = avg;
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
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

	@Override
	public String toString() {
		return String.format("StudentScore [stdNo=%s, subject1=%s, subject2=%s, subject3=%s, total=%s, avg=%s]", stdNo,
				subject1, subject2, subject3, total, avg);
	}
	
	
	

}
