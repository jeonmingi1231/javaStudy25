package ch02;

import java.util.Scanner;

public class UpAndDownGame {

	public static void main(String[] args) {
		// 컴퓨터가 랜덤으로 만든 1~31 숫자를 사용자가 맞추는 게임
		
		//먼저 숫자를 입력받을 변수를 만든다
		int input = 0 , answer = 0 ; 
		
		
		answer = (int)(Math.random()*31) + 1 ; //1~31까지의 랜덤정수를 넣는다.
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("1과 31사이의 정수를 입력하세요.");
			input = scanner.nextInt();
			
			if (input > answer) {
				System.out.println("down");
				
			} else if (input < answer) {
				System.out.println("up");
			}
		} while (input!=answer) ;
		System.out.println("정답입니다 " + answer);
		
		
					

	}

}
