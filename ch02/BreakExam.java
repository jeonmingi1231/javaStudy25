package ch02;

public class BreakExam {

	public static void main(String[] args) {
		// break문은 for, while, do-while문을 실행 중지 할 때 사용한다.
		//전에 배웠던 switch문에서도 break를 만나면 실행 중지 되는 것을 파악 하였다.
		//반복 문에서도 break문을 사용하면 루프중 중단되는 현상을 볼 수 있다.

		int i = 0 ;
		while (true) {
			int num = (int) (Math.random()*45)+1 ;
			System.out.println("오늘의 로또번호 : " + num);
			i++ ;
			if (i == 6) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

}
