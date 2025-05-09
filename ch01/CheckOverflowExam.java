package ch01;

public class CheckOverflowExam {

	public static void main(String[] args) {
		// 산술연산전에 오버플로우 탐지 MAX,MIN_VALUE 코드를 활용하여 검증해보기.

		try {  //예외처리하는 문
			int result = safeAdd(2000000000, 2000000000) ;
			System.out.println(result);
		} catch(ArithmeticException e) {
			System.out.println("오버플로우발생 : 계산 할 수 없음.");
		}
}
public static int safeAdd(int left, int right) {
	if(right>0) {
		if(left>(Integer.MAX_VALUE - right)) {
			throw new ArithmeticException("오버플로우발생");
		}
	}else {
		if(left<(Integer.MIN_VALUE - right)) {
			throw new ArithmeticException("오버플로우발생");
		}
	}
	return left + right ;
}			
		
		}



