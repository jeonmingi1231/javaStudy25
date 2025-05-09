package ch01;

import java.util.Scanner;

public class NonRiGopExam {

	public static void main(String[] args) {
		// 논리곱 테스트
		// & < 는 둘다 true 값일 때 true가 실행된다.
		
		Scanner input = new Scanner(System.in); // 키보드로 입력받을 객체 생성
		System.out.print("정수를 입력하시면 대소문자나 숫자를 판단합니다 : ");
		
		int charCode = input.nextInt(); // 키보드로 입력 받은 값을 charcode 변수에 넣음
		
		if( (charCode >= 65 ) && (charCode <= 90) ) { //charCode 가 65이상 90이하이면
				System.out.println("입력값은 대문자 입니다 : " + (char)charCode)  ;
				//여기까지 하면 참일때만 출력 값이 나옴.
				//그래서 else if 를 써서 다른 출력값도 만들어 줘야함
				
		}else if((charCode >= 97 ) && (charCode <= 122)) {
			System.out.println("입력값은 소문자 입니다 : " + (char)(charCode)) ;
			
		}else if( !(charCode < 48 ) && !(charCode > 57) ) { //NAND
			// (!가 있어서 부정)48보다 작지 않고 57보다 크지 않은
				System.out.println("입력값이 숫자 입니다 : " + ((char)charCode)) ;
			//이제 유니코드 대소문자,숫자 값을 입력했으니,아닐시의 출력값을 만들어줘야함
			//else + sysout 사용해서 아닐때의 아니다. 라는 출력값을 만들면 됨.
				
		}else {
			System.out.println("대소문자나 숫자가 아닙니다.");
			
		}

	}
	
}	
