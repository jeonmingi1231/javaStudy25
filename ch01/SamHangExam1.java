package ch01;

import java.util.Scanner;

public class SamHangExam1 {

	public static void main(String[] args) {
		// 삼항연산자를 이용한 홀짝 계산
		Scanner in = new Scanner(System.in) ;
		
		System.out.print("정수를 입력하세요 : ");
		int num = in.nextInt() ;
		System.out.println(num % 2 == 0 ? "짝수" : "홀수 ");
	}

}
