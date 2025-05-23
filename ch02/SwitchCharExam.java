package ch02;

import java.util.Scanner;

public class SwitchCharExam {

	public static void main(String[] args) {
		
	 
		Scanner inChar = new Scanner(System.in);
		
		System.out.print("회원 등급을 입력하세요 (A~C) : "); 
		
		//String gradeStr = inChar.next() ; 
		//char gradeChr = gradeStr.charAt(0); 
		
		char gradeChaStr = inChar.next().charAt(0); 
		System.out.println("검증 코드용(1줄) : " + gradeChaStr) ; 
	 
		switch(gradeChaStr) { 
		
		case 'a' :
		case 'A' :
			System.out.println("우수회원 입니다.");
			break ;
		case 'b' :
		case 'B' :
			System.out.println("일반회원 입니다.");
			break ;
		case 'c' :
		case 'C' :
			System.out.println("사업자회원 입니다.");
			break ;	
		
		default :
			System.out.println("손님 처음 이십니까?");
			System.out.println("회원 가입 하시려면 Yes를 입력해 주세요.");
			String newMember = inChar.next() ;
			if(newMember.equalsIgnoreCase("yes")) {
				System.out.println("회원가입을 진행합니다.");
				System.out.print("아이디 : ");
				String id = inChar.next() ;
				System.out.println(id + "님 회원가입을 축하드립니다.");
				break ;
			}else {
				System.out.println("안녕히 가세요! 다음 기회에 뵙겠습니다.");
				System.out.println("단, 두번 다시 못 뵐 수도 있습니다.");
				break ;
			} //회원가입 if문 종료
			
		

} //스위치 문 종료
	
	
	}
	
	
	
}
	