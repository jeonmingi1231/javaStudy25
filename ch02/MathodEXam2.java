package ch02;

import java.util.Scanner;

public class MathodEXam2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in) ;
		System.out.println("제비뽑기 좌석배치를 시작하겠습니다");
		System.out.print("자신의 글자를 입력하시오 >>");
		String Wd = in.nextLine();
		String kind = Class(Wd) ;
		System.out.println(Wd + "는 " + kind + "자리의 글자.");
		
		
		
	} // 메인 메서드 종료

	 static String Class(String Wd) {
		String kind = "없는" ;
		switch(Wd) {
		case "가", "나", "다", "라", "마" -> kind = "1열" ;
		//break;
		case "기", "니", "디", "리", "미" -> kind = "2열" ;
		//break;
		case "구", "누", "두", "루", "무" -> kind = "3열" ;
		//break;
		default -> System.out.println("다시 입력해 주세요");
		
		}
		return kind ;
		
	}

} // 클래스 종료
