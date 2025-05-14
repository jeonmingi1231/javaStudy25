package ch02;

public class ForPrintExam {

	public static void main(String[] args) {
		// 초기화식이 둘이상이나 증감식이 둘이상인 경우도 있다.
		// 주의사항 : 조건식에는 &&를 이용해서 작성한다
		for(int i = 0 , j = 100 ; i <= 10 && j >= 90 ; i++ , j--) {
			System.out.println("i값의 증가 : " + i + " // j값의 감소 : " + j );
		}
		
		
	}
}
