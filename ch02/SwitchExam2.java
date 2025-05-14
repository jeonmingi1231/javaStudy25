package ch02;

import java.util.Scanner;

public class SwitchExam2 {

	public static void main(String[] args) {
		// SwitchExam 응용하기.
		// 축구 구단 홈페이지 만들기
		
		Scanner input = new Scanner(System.in);
		System.out.println("===========================");
		System.out.println("mbcFC사이트에 오신것을 환영합니다.");
		System.out.println("어떤 메뉴를 확인할까요?");
		System.out.println("a. player");
		System.out.println("b. shop");
		System.out.println("c. 고객센터");
		System.out.println("z. 창 닫기");
		System.out.print("(a~z)>>>");
		char site = input.next().charAt(0) ;
		System.out.println("선택한 문자 : " + site);
		
		switch(site) { // if문으로 변경시 if(site == a || site == A ){
		case 'a' :
		case 'A' :
			System.out.println("plyer 로 진입합니다.");
			System.out.println("1. 선수단");
			System.out.println("2. 코칭 스태프");
			System.out.println("3. 팀 스태프");
			System.out.print("(1~3)>>>");
			int subSelete = input.nextInt() ;
			switch(subSelete) { // 삭제
			case 1 : // if(subSelete == 1) {
				System.out.println("1. 선수단 목록으로 진입합니다.");
				break; //삭제
			case 2 : // else if (subSelete == 2) {
				System.out.println("2. 코칭 스태프 목록으로 진입합니다.");
				break; //삭제
			case 3 : // else if (subSelete == 3) {
				System.out.println("3. 팀 스태프 목록으로 진입합니다.");	
				break;//삭제
			default : //디폴트 대신 else로 아닐때의 값 입력
				System.out.println("(1~3)만 입력해주세요. ");
				System.out.println("올바르지않은 번호 입니다. 처음부터 다시 해주세요.");
			}
		
			break;//삭제
		case 'b' : // switch 문을 if/else문으로 변경하기.
		case 'B' :
			System.out.println("shop 으로 진입합니다.");
			System.out.println("1. 티켓");
			System.out.println("2. 유니폼");
			System.out.println("3. 굿즈");
			System.out.print("(1~3)>>>");
			int subSelete2 = input.nextInt() ;
			
			if (subSelete2 == 1) { // case 대신 if로 해서 먼저 1번값을 true로 바꿔준다
			
				System.out.println("1. 티켓 목록으로 진입합니다.");
			
			}else if (subSelete2 == 2) { // 1번값이 아닐때 2번값이 true가 되게 else if를 써준다.
				System.out.println("2. 유니폼 목록으로 진입합니다.");
				
			}else if (subSelete2 == 3) { // 1,2번 값이 아닐때 3번이 true가 되게 else if를 써준다.
				System.out.println("3. 굿즈 목록으로 진입합니다.");	
				
			}else { //셋다 아닐 경우가 있으므로 else로 써준다.
				System.out.println("(1~3)만 입력해주세요. ");
				System.out.println("올바르지않은 번호 입니다. 처음부터 다시 해주세요.");
			}
			break;
		case 'c' :
		case 'C' :
			System.out.println("고객센터 로 진입합니다.");
			System.out.println("1. 온라인 상담");
			System.out.println("2. 전화 상담");
			System.out.println("3. 게시판");
			System.out.print("(1~3)>>>");
			int subSelete3 = input.nextInt() ;
			switch(subSelete3) {
			case 1 :
				System.out.println("1. 온라인 상담 목록으로 진입합니다.");
				break;
			case 2 :
				System.out.println("2. 전화 상담 목록으로 진입합니다.");
				break;
			case 3 :
				System.out.println("3. 게시판 목록으로 진입합니다.");	
				break;
			default :
				System.out.println("(1~3)만 입력해주세요. ");
				System.out.println("올바르지않은 번호 입니다. 처음부터 다시 해주세요.");
			}	//괄호 닫기.
			break;
			
		case 'z' :
		case 'Z' :
			System.out.println("창 을 닫습니다.");
			break;	
		
		default :
			System.out.println("메뉴에 없는 문자를 넣었습니다.");
			System.out.println("프로그램을 다시 실행해 주세요.");
			break;
		
		}
	}

}

	
	
