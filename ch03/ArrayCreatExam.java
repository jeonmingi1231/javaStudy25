package ch03;

public class ArrayCreatExam {

	public static void main(String[] args) {
		// 배열을 이용하여 총점과 평균을 구해 봄
		int[] scores = {90, 80, 70} ;
		System.out.println("scores[0] : " + scores[0]);
		System.out.println("scores[1] : " + scores[1]);
		System.out.println("scores[2] : " + scores[2]);
		
		int sum = 0 ;
		for(int i = 0; i < 3 ; i++) {
			sum += scores[i] ;
			// System.out.println( "총점 : " + sum);
		}
		System.out.println("총점 : " + sum);
		double avg = (double) sum / 3;
		System.out.println("평균 : " + avg);
	}

}
