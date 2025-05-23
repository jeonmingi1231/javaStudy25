package ch03;

public class ArrayCreatExam2 {

	public static void main(String[] args) {
		// 메서드를 활용한 평균 계산
		int sum = add(new int[] {80, 70, 40} );
		System.out.println("총합 : "+ sum );
	}

	private static int add(int[] scores) {
		// add메서드 만들기
		int sum= 0;
		for(int i = 0; i < 3; i++ ) {
		sum += scores[i];
				

	}
	return sum;
}
}