package mbcboard;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dto.MemberDTO;
import mbcboard.service.BoardService;
import mbcboard.service.MemberService;

public class BoardExam {
	// 필드
	public static Scanner inputStr = new Scanner(System.in);
	public static MemberDTO session = null; // 로그인 상태 저장용
	// 생성자->static 블럭

	// 메서드
	public static void main(String[] args) throws SQLException {
		// mbc게시판용 jdbc 테스트
		// dto : 객체를 담당한다.
		// dao : 데이터베이스에서 연동을 담당한다.
		// service : 부메뉴와 서비스를 담당한다.
		boolean run = true;

		while (run) {
			System.out.println("MBC 자유 게시판입니다.");
			System.out.println("1. 로그인");
			System.out.println("2. 회원메뉴");
			System.out.println("3. 게시판");
			System.out.println("4. 종료");
			System.out.print(">>>");
			String select = inputStr.next();

			switch (select) {
			case "1":
				boolean loginMenuRun = true;
				while (loginMenuRun) {
					System.out.println("로그인 메뉴로 진입합니다.");
					System.out.println("1. 회원가입");
					System.out.println("2. 로그인");
					System.out.println("3. 로그아웃");
					System.out.println("4. 로그인 상태 확인");
					System.out.println("5. 뒤로가기");
					System.out.print(">>> ");
					String loginChoice = inputStr.next();
					MemberService memberService = new MemberService();
					switch (loginChoice) {
					case "1":
						memberService.addMember(inputStr); // 회원가입
						break;
					case "2":
						session = memberService.login(inputStr); // 로그인
						break;
					case "3":
						session = null; // 로그아웃
						System.out.println("로그아웃 되었습니다.");
						break;
					case "4":
						if (session != null) {
							System.out.println("현재 로그인 중: " + session.getId());
						} else {
							System.out.println("로그인되어 있지 않습니다.");
						}
						break;
					case "5":
						loginMenuRun = false;
						break;
					default:
						System.out.println("1~5번 중에서 선택하세요.");
					}
				}

				break;
			case "2":
				System.out.println("회원메뉴로 진입합니다.");
				MemberService memberService = new MemberService();
				memberService.memberMenu(inputStr);
				break;
			case "3":
				System.out.println("게시판 서비스로 진입합니다.");
				BoardService boardService = new BoardService();
				boardService.subMenu(inputStr, session);
				break;
			case "4":
				System.out.println("자유게시판 프로그램 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("1~3까지만 입력 바랍니다.");
			} // switch 문 종료

		} // while문 종료

	}// main() 종료

} // class 종료
