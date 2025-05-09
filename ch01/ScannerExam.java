package ch01;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		// Sacnner 메서드를 활용하여 키보드로 입력 받는 값을 처리하게 구현한다.
		
		Scanner in = new Scanner(System.in) ;
		int x = in.nextInt() ;
		int y = in.nextInt() ;
		System.out.printf("%d * %d은 %d 입니다. \n" , x , y, x * y);
		//10 엔터 > 20 엔터 > sysout 이 실행되고 출력이 진행됨.
	}

}
