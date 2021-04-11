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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gradescore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + scoreMax;
		result = prime * result + scoreMin;
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
		GradeConvertion other = (GradeConvertion) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (Double.doubleToLongBits(gradescore) != Double.doubleToLongBits(other.gradescore))
			return false;
		if (scoreMax != other.scoreMax)
			return false;
		if (scoreMin != other.scoreMin)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return String.format("gradeConvertion [scoreMin=%s, scoreMax=%s, grade=%s, gradescore=%s]", scoreMin, scoreMax,
				grade, gradescore);
	}
	
	
}
