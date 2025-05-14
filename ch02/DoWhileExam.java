package ch02;

import java.util.Scanner;

public class DoWhileExam {

	public static void main(String[] args) {
		//while문과 같은데 while문은 시작과 동시에 조건을 비교하지만, do-while문은 1번은 실행되고 다음 번째 부터 조건을 비교한다.
		//예를 들어 키보드로 입력 받은 내용을 조사하여 계속 루프를 돌게할 것인지 판단하는 프로그램이 있다고 가정하자. 
		//조건식은 키보드로 입력 받은 이후에 평가 되어야 하므로, 우선적으로 키보드로부터 입력된 내용을 받아야 한다.
		//do { 실행문; } while ( 조건식 ) ; 
		//조건식이 true이면 위로 올라가 do 실행문을 진행하고 false이면 while문을 빠져나간다
		System.out.println("메세지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요 : ");
		
		Scanner in = new Scanner(System.in);
		String inputString; //키보드로 입력 받은 값 저장용
		
		do {
			System.out.print(">>>");
			inputString = in.nextLine();
			System.out.println("전송값 : "  + inputString );
			
		} while (!inputString.equalsIgnoreCase("q")) ;
		System.out.println("프로그램 종료");
		System.out.println("==================");

	}

}
