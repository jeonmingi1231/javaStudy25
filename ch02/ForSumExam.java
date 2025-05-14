package ch02;

public class ForSumExam {

	public static void main(String[] args) {
		// 1부터 100까지의 합을 구해본다 1+2+3+ ........ 100 = sum / 5050
		int sum = 0; // 누적합계를 구하는 변수를 선언

		for (int i = 1; i <= 100; i++) { // 1~100까지 증가값)
			sum = sum + i; // sum->0 부터 i 는 1이라는 값을 넣어주고 i가 ++로 1씩 증가하는값을 더한다는 뜻.

		}
		System.out.println("1~100까지의 합 : " + sum);
		{
			int summ = 0 ;
			int w = 1 ;
			for (; w <= 700 ; w++ ) {
				summ = summ + w ;
			}
			System.out.println("1~" + (w-1) + "까지의 합 : " + summ);
		}

	}
}