package ch01;

import java.util.Scanner;

public class ScannerClassExam {

	public static void main(String[] args) {
		// Scanner 클래스
		
		//  Scanner in = new Scanner(System.in) ;
		  
		 // String strval1 = in.nextLine() ; // 전민기 라는 strval1 
		 // String strval2 = in.nextLine() ; // 같은 객체가 있어서 
		 // String strval3 = new String(in.nextLine()) ;  //새로운 객체를 생성
		
		  
		Scanner in = new Scanner (System.in) ;
		System.out.print("이름을 입력하세요 : ");
		String name = in.nextLine() ;
		System.out.print("나이를 입력하세요 : ");
		String age = in.nextLine() ;
		System.out.print("이메일을 입력하세요 : ");
		String email = in.nextLine() ;
		
		System.out.println(name + "님 해킹 당하신것을 축하드립니다. ㅋㅋㅋ");
		System.out.println("당신의 나이가 " + age + "이군요");
		System.out.println(email + "주소 잘 사용하겠습니다. 감사합니다 . ");
		
		
	}

}
