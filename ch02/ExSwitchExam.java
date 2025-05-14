package ch02;

import java.util.Scanner;

public class ExSwitchExam {

	public static void main(String[] args) {
		// 향상된 switch문은 같은 조건을 동시에 처리하기 위한 기법
		// case뒤에 값이 여러개 존재할 수 있다.
		// case에 해당하는 값 처리는 -> 람다식 구현 방법을 활용한다.
		
		Scanner in = new Scanner(System.in);
		System.out.print("동물의 이름을 입력하세요 >>");
		String Monster = in.nextLine(); //문자열 입력
		String kind = WhoIsIt(Monster); //메서드호출+실행(매개값,파라미터,전달값) 
		System.out.println(Monster + "는 " + kind + "그룹에 포함된 동물입니다.");
	} // main()메서드 종료

	//추가 메서드 활용 (동작부분을 따로 만듬 -> 관심사의 분리 (oop핵심))
	static String WhoIsIt(String Monster) { //매개값으로 main()넘어온 문자열을 처리
		String kind = "미지의 생물" ; //출력용 변수 선언 및 초기값 입력
		switch(Monster) {
		case "호랑이", "사자", "강아지", "고양이", "고래" -> kind = "포유류" ;
		//break; 향상된 스위치문에는 break를 사용할수 없다.
		case "독수리", "참새", "까마귀", "비둘기", "닭" -> kind = "조류" ;
		//break;
		case "고등어", "연어", "참치", "갈치", "광어" -> kind = "어류" ;
		//break;
		default -> System.out.println("사전에 등록되지 않은 Monster 입니다.");
		} // 스위치문 종료
		//System.out.println(Monster + "는 " + kind + "그룹에 호함된 동물입니다";
		return kind ;// void가 아닌 타입 반환 기법.
	}// whoisit 메서드 종료
	
}
