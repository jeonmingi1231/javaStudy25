package ch02;

public class For2t09Exam {

	public static void main(String[] args) {
		// 2단~9단까지 구구단을 구하는 프로그램을 작성해보자.
		//변수 m은 2~9까지 증가하여 단을 생성한다. (바깥쪽 for)
		//변수 n은 1~9까지 증가하여 곱셈을 완성한다. (안쪽 for문)

		for ( int m = 2 ; m <= 9; m++ ) {
			System.out.println("//////" + m + "단//////");
			for (int n = 1 ; n <= 9 ; n++ ) {
				System.out.println(m + " X " + n + " = " + (m*n));
			}
			//바깥쪽 for 문은 안쪽 for문이 끝나야 바깥쪽 for을 진행 하기 때문에 
			//2단에 1~9까지 곱셈을 진행하고 3단으로 넘어가 1~9까지 곱셈을 진행하며 9단까지 안쪽for을 반복 한다.

		}
		
		
		
	}

}
