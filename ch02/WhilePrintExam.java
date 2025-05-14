package ch02;

public class WhilePrintExam {

	public static void main(String[] args) {
		// for문은 정해진 횟수만큼 반복한다면, while문은 조건식이 true일 경우 계속해서 반복한다.
		//조건식에는 비교 또는 논리 연산식이 주로 온다.
		//조건식이 false가 되면 반복 행위를 멈추고, while문을 종료 한다.
		//작성법
		//while(조건식) { 조건식이 true일 때 실행문; } 조건식이 false면 빠져나온다.
		//while문은 처음 실행될 때 조건식을 평가한다. (반복문)
		int i = 1 ;
		while (i <= 10) {
			System.out.println(i); //이대로 끝내면 11111111111111111111111계속 뜸;;
			i++ ; // 증감식을 넣어줘야함. 
			
		} // i <= 10 종료
	System.out.println("================");
		{
			int summ = 0 ; //누적합계를 구하는 변수를 선언
			int w = 1 ;
			while ( w <= 100 ) {
				summ = summ + w ;
				w++ ;
			
			}
			System.out.println("1~" + (w - 1 ) + "까지의 합 : " + summ );
	}

}
}