package ch04.mbcbank;

import java.util.Scanner;

import ch04.mbcbank.DTO.AccountDTO;
import ch04.mbcbank.service.HanaBankService;

public class BankExam {
	// 필드

	// 먼저 스캐너 객체 생성
	public static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputStr = new Scanner(System.in);
	// 은행별 DTO 만들기
	public static AccountDTO[] hanaBank = new AccountDTO[10]; // 10개의 배열을 만든다.
	public static AccountDTO[] woriBank = new AccountDTO[10];
	public static AccountDTO[] nhBank = new AccountDTO[10];

	// 생성자 -> 정적블럭 (main 메서드 초기화 값)
	static {
		AccountDTO accountDTO0 = new AccountDTO("1111", "전", 1000000, "하나");
		hanaBank[0] = accountDTO0;
		AccountDTO accountDTO1 = new AccountDTO("2222", "민", 2000000, "우리");
		woriBank[0] = accountDTO1;
		AccountDTO accountDTO2 = new AccountDTO("3333", "기", 3000000, "농협");
		nhBank[0] = accountDTO2;
	} // 정적 블럭 종료

	// 메서드
	public static void main(String[] args) { // main메서드는 주메뉴 실행용
		// 은행 3개를 만들어 계좌관리하는 프로그래밍
		// 테스트 코드 작성
		// 기본값 입력 더미데이터 출력용 코드 -> toString 오버라이딩으로 볼수 있다.
		// System.out.println("하나은행 더미데이터 출력 테스트 : " + hanaBank[0]);
		// System.out.println("우리은행 더미데이터 출력 테스트 : " + woriBank[0]);
		// System.out.println("농협은행 더미데이터 출력 테스트 : " + nhBank[0]); //<< 더미 확인용

		boolean run = true; // 주 메뉴 반복용
		while (run) {
			System.out.println("==========================");
			System.out.println("JMG금융시스템에 오신것을 환영합니다.");
			System.out.println("==========================");
			System.out.println("1. 하나은행");
			System.out.println("2. 우리은행");
			System.out.println("3. 농협은행");
			System.out.println("4. 프로그램 종료");
			System.out.print(">>>");
			String select = inputStr.next();
			switch (select) {
			case "1":
				System.out.println("하나은행으로 진입합니다.");
				HanaBankService hanaBankService = new HanaBankService();
				hanaBankService.menu(inputInt, inputInt, hanaBank);
				break;
			case "2":
				System.out.println("우리은행으로 진입합니다.");
				
				break;
			case "3":
				System.out.println("농협은행으로 진입합니다.");
				break;
			case "4":
				System.out.println("프로그램을 종료 합니다.");
				run = false;
				break;
			default:
				System.out.println("1~4값만 입력하세요.");
				break;
			} // switch 종료
		} // while 종료

	}// 메인 메서드 종료

}// 클래스 종료
