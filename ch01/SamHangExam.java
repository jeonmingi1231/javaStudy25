package ch01;

public class SamHangExam {

	public static void main(String[] args) {
		// 삼항연산자

		int score = 85 ;
		char grade = (score > 90) ? 'A' : ( (score > 80) ? 'B' : 'c') ;
		System.out.println(score + "점은" + grade + "등급입니다");
	}

}
