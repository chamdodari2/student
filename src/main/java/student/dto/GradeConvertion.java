package student.dto;

public class GradeConvertion {
	private int scoreMin;
	private int scoreMax;
	private String grade;
	private double gradescore;
	
	
	



	public GradeConvertion(int scoreMin, int scoreMax, String grade, double gradescore) {
		this.scoreMin = scoreMin;
		this.scoreMax = scoreMax;
		this.grade = grade;
		this.gradescore = gradescore;
	}



	public int getScoreMin() {
		return scoreMin;
	}



	public void setScoreMin(int scoreMin) {
		this.scoreMin = scoreMin;
	}



	public int getScoreMax() {
		return scoreMax;
	}



	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public double getGradescore() {
		return gradescore;
	}



	public void setGradescore(double gradescore) {
		this.gradescore = gradescore;
	}



	@Override
	public String toString() {
		return String.format("gradeConvertion [scoreMin=%s, scoreMax=%s, grade=%s, gradescore=%s]", scoreMin, scoreMax,
				grade, gradescore);
	}
	
	
}
