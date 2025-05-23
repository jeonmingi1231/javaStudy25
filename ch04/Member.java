package ch04;

import java.util.Scanner;

public class Member {
	// 회원용 객체 클래스 (main 메서드는 MemberObjExam에서 작성)
	// 클래스 기본 구성: 필드 + 생성자 + 메서드

	// [1] 필드 선언 - 회원 정보로 사용할 변수들
	public int mno; // 회원 번호
	public String id; // 회원 아이디
	public String pw; // 회원 비밀번호

	// [2] 기본 생성자 - 객체 생성 시 자동 호출됨
	public Member() {
		// 기본생성자로 : 클래스명과 같은 메서드 											[1][2][3] 같이 필드,생성자,메서드가 꼭 있어야함.
		// Member member = new Member(); 이런식 으로 호출됨.

	}

	// [3] 회원가입 메서드 - 입력을 받아서 새 Member 객체를 만들어 반환
	public Member memberAdd(Scanner input) { // main에서 전달된 스케너 객체
		Member member = new Member(); // 새로운 회원 객체 생성
		System.out.println("회원가입용 메서드 입니다.");

		// 회원번호 입력받기
		System.out.println("회원번호를 입력 하세요");
		System.out.print("(숫자)>>>");
		member.mno = input.nextInt();
		// 아이디 입력받기
		System.out.println("회원id를 입력하세요.");
		System.out.print(">>>");
		member.id = input.next();
		// 비밀번호 입력받기
		System.out.println("회원pw를 입력하세요.");
		System.out.print(">>>");
		member.pw = input.next();

		return member; // 완성된 회원 객체 를 반환함.
	} // memberAdd()메서드 종료

	// [4] 모든 회원 정보를 출력하는 메서드
	public void memberAllList(Member[] members) {
		System.out.println("모든 회원 보기 리스트");

		// members 배열을 반복하면서 출력
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) { // 삭제된 회원null은 건너뜀.
				System.out.print("회원번호 : " + members[i].mno);
				System.out.print(" 회원id : " + members[i].id);
				System.out.print(" 회원pw : " + members[i].pw);
				System.out.println("--------------------------");
			}
		}
	} // memberAllList()메서드 종료

	// [5] 로그인 메서드
	public void memberLogin(Scanner input, Member[] members) {
		System.out.println("로그인 메서드 입니다");

		// 사용자로부터 id,pw입력받기
		System.out.print("아이디 입력 >>> ");
		String inputId = input.next();

		System.out.print("비밀번호 입력 >>> ");
		String inputPw = input.next();

		boolean loginSuccess = false; // 로그인 성공 여부를 저장

		// 회원 배열에서 입력된 id/pw가 일치하는지 확인
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null && members[i].id.equals(inputId) && members[i].pw.equals(inputPw)) {
				// null이 !아니고 && id.equals가 맞고 && pw.equals가 맞냐.
				System.out.println("로그인 성공! 환영합니다, " + members[i].id + "님!");
				loginSuccess = true;
				break; // 로그인 성공했으면 더이상 반복할 필요 없으니 break;
			}
		}
		// 로그인 실패시 메시지 출력값.
		if (!loginSuccess) {
			System.out.println("로그인 실패! 아이디 또는 비밀번호가 올바르지 않습니다.");
		}

	}// memberAllLogin()메서드 종료

	// [6] 회원정보 수정 메서드
	public void memberUpdate(Scanner input, Member[] members) {
		System.out.println("회원수정 메서드 입니다");

		// 수정할 대상 회원의 id입력 받기.
		System.out.print("수정할 아이디 입력 >>> ");
		String targetId = input.next();

		boolean found = false; // 수정 대상이 존재하는지 찾아서 확인.

		for (int i = 0; i < members.length; i++) {
			// 빈칸이 !아니고 id가 맞으면 정보 수정.
			if (members[i] != null && members[i].id.equals(targetId)) {
				// 비밀번호 수정
				System.out.print("새 비밀번호 입력 >>> ");
				members[i].pw = input.next();
				
				// 회원번호 수정
				System.out.print("새로운 회원번호 입력 >>> ");
				members[i].mno = input.nextInt();

				// 새 아이디 입력
				System.out.print("새 아이디 입력 >>> ");
				members[i].id = input.next();
				
				System.out.println("회원 정보가 수정되었습니다.");
				found = true;
				break;
			}
		}
		// id와 일치하지 않은 회원을 못찾았을때의 메세지 출력
		if (!found) {
			System.out.println("해당 아이디의 회원을 찾을 수 없습니다.");
		}

	}// membermemberUpdate()메서드 종료

	// [7] 회원 탈퇴 메서드
	public void memberDelete(Scanner input, Member[] members) {
		System.out.println("회원탈퇴 메서드 입니다");

		// 탈퇴할 id 입력받기.
		System.out.print("탈퇴할 아이디를 입력하세요 >>> ");
		String targetId = input.next();

		// 삭제 성공여부 확인용 삭제되면 반복되지않음.
		boolean deleted = false;

		for (int i = 0; i < members.length; i++) {
			// 빈칸이 !아니고 && id가 맞으면
			if (members[i] != null && members[i].id.equals(targetId)) {
				members[i] = null; // null처리로 바꾸며 삭제한다.
				System.out.println("회원 탈퇴가 완료되었습니다.");
				deleted = true;
				break;
			}
		}
		// 일치하는 회원이 없을경우 메세지 출력
		if (!deleted) {
			System.out.println("해당 아이디를 찾을 수 없습니다.");
		}
	}
}
