package ch02;

import java.util.Scanner;

public class SwitchExam2 {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("===========================");
		System.out.println("mbcFC에 오신것을 환영합니다.");
		System.out.println("무엇을 확인하시겠습니까?");
		System.out.println("a. player");
		System.out.println("b. shop");
		System.out.println("c. 고객센터");
		System.out.println("z. 프로그램 종료");
		System.out.print("(a~z)>>>");
		char site = input.next().charAt(0) ;
		System.out.println("입력하신 목록으로 들어갑니다 : " + site);
		
		switch(site) { // if(site == a || site == A ){
		case 'a' :
		case 'A' :
			System.out.println("plyer 목록으로 진입합니다.");
			System.out.println("1. 공격수 목록.");
			System.out.println("2. 미드필더 목록");
			System.out.println("3. 수비수 목록");
			System.out.print("(1~3)>>>");
			int subSelete = input.nextInt() ;
			switch(subSelete) { 
			case 1 : // if(subSelete == 1) {
				System.out.println("1. 공격수 목록으로 진입합니다.");
				break; 
			case 2 : // else if (subSelete == 2) {
				System.out.println("2. 미드필더 목록으로 진입합니다.");
				break;
			case 3 : // else if (subSelete == 3) {
				System.out.println("3. 수비수 목록으로 진입합니다.");	
				break;
			default : 
				System.out.println("(1~3)을 선택해주세요. ");
				System.out.println("잘못 입력되었습니다. 다시 실행해 주세요.");
			}
		
			break;
		case 'b' : 
		case 'B' :
			System.out.println("shop 목록으로 진입합니다.");
			System.out.println("1. 유니폼 구매");
			System.out.println("2. 티켓 구매");
			System.out.println("3. 굿즈 구매");
			System.out.print("(1~3)>>>");
			int subSelete2 = input.nextInt() ;
			
			if (subSelete2 == 1) { 
			
				System.out.println("1. 유니폼 구매 목록으로 진입합니다.");
			
			}else if (subSelete2 == 2) { 
				System.out.println("2. 티켓 구매 목록으로 진입합니다.");
				
			}else if (subSelete2 == 3) { 
				System.out.println("3. 굿즈 구매 목록으로 진입합니다.");	
				
			}else { 
				System.out.println("(1~3)을 선택해주세요. ");
				System.out.println("잘못 입력되었습니다. 다시 실행해 주세요.");
			}
			break;
		case 'c' :
		case 'C' :
			System.out.println("고객센터 목록으로 진입합니다.");
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
				System.out.println("(1~3)을 선택해주세요. ");
				System.out.println("잘못 입력되었습니다. 다시 실행해 주세요.");
			}	
			break;
			
		case 'z' :
		case 'Z' :
			System.out.println("프로그램을 종료합니다.");
			break;	
		
		default :
			System.out.println("잘못 입력되었습니다.");
			System.out.println("다시 입력해 주세요.");
			break;
		
		}
	}

}

	
	
