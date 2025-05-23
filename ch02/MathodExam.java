package ch02;

import java.util.Scanner;

public class MathodExam {

	public static void main(String[] args) {
		// 메서드 빼는거 응용

		Scanner inputInt = new Scanner(System.in); // 키보드로 정수 입력받을 객체
		boolean run = true;
		String id = "qwer";
		String pw = "1234";
		boolean session = false; // 로그인 상태 저장용

		while (run) { // 얘네를 무한반복을 위해 while 과 run을 적용해줘야함.
			System.out.println("===엠비씨 성적처리용===");
			System.out.println("1.로그인");
			System.out.println("2.교사관리");
			System.out.println("3.학생관리");
			System.out.println("4.성적관리");
			System.out.println("9.프로그램 종료");
			System.out.print(">>>");
			int select = inputInt.nextInt(); // 키보드로 입력 받는 코드

			switch (select) { // select 번호로 골랐을때의 번호별 case(항목)

			case 1:
				System.out.println("로그인 메뉴로 이동합니다.");
				session = loginOk(id, pw, session);
				// 로그인 여부에 따른 출력값 만들기
				if (session == true) {
					System.out.println(id + "님 환영합니다");
					System.out.println("2~4메뉴를 사용하실 수 있습니다.");

				} else {
					System.out.println("다시 입력해주세요.");
				}
				break;
			case 2:
				System.out.println("교사관리 메뉴로 이동합니다.");
				
				break;
			case 3:
				System.out.println("학생관리 메뉴로 이동합니다.");
				break;
			case 4:
				System.out.println("성적관리 메뉴로 이동합니다.");
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			} // 스위치 문 종료

		}

	} // 메인 메서드 종료

	static boolean loginOk(String id, String pw, boolean session) {
		// 로그인 성공 여부 메서드를 만든다
		Scanner inputLogin = new Scanner(System.in); // 키보드로 입력받을 id 객체
		System.out.println("로그인 id를 입력하세요");
		System.out.print(">>>");
		String inputId = inputLogin.next(); // id를 입력받을 항목 만들기
		System.out.println("로그인 pw를 입력하세요"); // 키보드로 입력받을pw 객체
		System.out.print(">>>");
		String inputPw = inputLogin.next(); // pw를 입력받을 항목 만들기.
		// id,pw입력 객체를 다 만들었으면 이제 출력할 값 만들기
		// if문을 사용해서 로그인 true/false 값 출력하기
		if (id.equals(inputId) && pw.equals(inputPw)) { // id 이퀄스 && pw 이퀄스가 맞을때 true
			System.out.println("로그인 성공!!!"); // 참일때의 출력값
			session = true; // true값 넣기
		} else {
			System.out.println("로그인 실패!!!"); // 거짓일때의 출력값
			session = false; // false 값 넣기
		} // id pw일치 판단문 종료
		return session;
	}// 로그인 메서드 종료
} // 클래스 종료