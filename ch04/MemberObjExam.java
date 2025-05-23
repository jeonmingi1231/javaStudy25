package ch04;

import java.util.Scanner;

public class MemberObjExam {

	public static void main(String[] args) {
		// Member 클래스를 호출하여 처리 해보자.

		Scanner input = new Scanner(System.in); //사용자 입력을 받을 스캐너 생성
		Member[] members = null; 
		//회원 정보를 저장할 배열 선언 [] null 자리에 하나씩 배열대로 만들어짐

		// 회원 수를 먼저 입력받아 배열 크기 생성.
		System.out.println("가입할 회원수를 입력하세요"); //ex 3명 일시 배열 3개 생성됨.
		System.out.print(">>>");
		int count = input.nextInt();
		members = new Member[count]; // 키보드로 입력한 숫자만큼 배열 생성

		System.out.println("회원가입 프로그램을 시작합니다.");
		boolean run = true; //프로그램 종료 여부를 제어하는 변수.
		
		while (run) { //true일 동안 반복 실행

			//메뉴 실행
			System.out.println("1.회원가입");
			System.out.println("2.회원전체보기");
			System.out.println("3.로그인");
			System.out.println("4.회원수정");
			System.out.println("5.회원탈퇴");
			System.out.println("1~5 까지만 입력하세요.(다른키가 눌리면꺼집니다).");
			System.out.print(">>>");
			int select = input.nextInt(); //메뉴 선택 입력

			switch (select) {
			case 1: // 1. 회원가입 
				Member member1 = new Member(); // Member 객체 생성
				
				// 배열의 빈 칸(null)을 찾아 회원 정보 입력
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						member1 = member1.memberAdd(input); // 회원 정보 입력
						members[i] = member1; // 배열에 저장됨.
						System.out.println("회원가입이 완료되었습니다.");
					}
				}
				break;
			case 2: // 2. 전체 회원 정보 출력
				Member member2 = new Member(); // 객체 생성
				member2.memberAllList(members); // 위에서 만든 정보를 불러와서 전체 회원 출력한다.
				break;
			case 3: // 3. 로그인
				Member member3 = new Member(); // 객체 생성
				member3.memberLogin(input, members); // 로그인 메서드 실행
				break;
			case 4: // 4. 회원정보 수정
				Member member4 = new Member(); // 객체 생성
				member4.memberUpdate(input, members); // 회원수정 메서드 실행
				break;
			case 5: // 5. 회원 삭제
				Member member5 = new Member(); // 객체 생성
				member5.memberDelete(input, members); // 회원탈퇴 메서드 실행
				break;
				// 1~5 외의 숫자가 입력되면 종료
			default:
				System.out.println("회원가입 프로그램 종료");
				run = false; // while문을 종료하기 위한 false 설정.

			} // switch문 종료

		} // while문 종료

	} // 메인메서드 종료

} // class종료
