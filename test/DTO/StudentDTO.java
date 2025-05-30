package test.DTO;

public class StudentDTO {
	// 필드
	private String name;
	private int kor;
	private int mat;
	private int eng;
	private int total;
	private double avg;
	private String grade;

	// 생성자
	public StudentDTO(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
		this.total = kor + eng + mat;
		this.avg = total / 3.0;
		this.grade = calcGrade(this.avg);
		
	

	}
	// 등급 계산 메서드
	private String calcGrade(double avg) {
		if (avg >= 90) return "A";
		else if (avg >= 80) return "B";
		else if (avg >= 70) return "C";
		else if (avg >= 60) return "D";
		else return "F";
	}
	public String getName() {
		return name;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	@Override
	public String toString() {
		return "StudentDTO [name=" + name + ", kor=" + kor + ", mat=" + mat + ", eng=" + eng + ", total=" + total
				+ ", avg=" + avg + ", grade=" + grade + "]";
	}

	// 메서드
}
