package mbcboard.service;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dao.MemberDAO; // 회원 데이터 관련 DB작업 담당 클래스 import
import mbcboard.dto.MemberDTO; // 회원 정보 담는 클래스 import

public class MemberService {

	MemberDAO memberDAO = new MemberDAO(); // DB 작업하는 MemberDAO 객체 생성

	public void memberMenu(Scanner inputStr) throws SQLException {
		boolean mRun = true;
		while (mRun) {
			System.out.println("회원메뉴");
			System.out.println("1. 전체 회원 보기");
			System.out.println("2. 개인 회원 보기");
			// System.out.println("3. 회원 정보 등록");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 뒤로가기");
			System.out.print(">>>");
			String choice = inputStr.next();

			switch (choice) {
			case "1":
				showAllMembers();
				break;
			case "2":
				showOneMembers(inputStr);
				break;
			// case "3":
			// addMember(memberDAO, inputStr);
			// break;
			case "3":
				updMember(inputStr);
				break;
			case "4":
				delMember(inputStr);
				break;
			case "5":
				mRun = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.1~5값만 입력해주세요.");
			}

		} // while 문 종료
	} // service 메서드 종료

	private void delMember(Scanner inputStr) throws SQLException {
		// 회원 삭제 메서드
		System.out.println("삭제하시려는 회원의 id를 입력하세요!");
		System.out.print(">>>");
		String id = inputStr.next();

		memberDAO.delMember(id);

	}

	private void updMember(Scanner inputStr) throws SQLException {
		// 회원 수정 메서드
		System.out.println("수정하시려는 회원의 id를 입력하세요!");
		System.out.print(">>>");
		String id = inputStr.next();

		memberDAO.updMember(id, inputStr);
		System.out.println("=====================================");
	}

	/*
	 * private void addMember(MemberDAO memberDAO, Scanner inputStr) throws
	 * SQLException { // 회원 추가 메서드 MemberDTO memberDTO = new MemberDTO();
	 * System.out.println("=========회원등록===========");
	 * System.out.print("이름을 입력하세요 : "); memberDTO.setBwriter(inputStr.next());
	 * 
	 * System.out.print("id를 입력하세요 : "); memberDTO.setId(inputStr.next());
	 * 
	 * System.out.print("pw를 입력하세요 : "); memberDTO.setPw(inputStr.next());
	 * 
	 * memberDAO.addMember(memberDTO);
	 */
	// }

	private void showOneMembers(Scanner inputStr) throws SQLException {
		// 회원 개인 보기 메서드
		System.out.println("=======================");
		System.out.println("조회하실 회원 id를 입력하세요 ");
		System.out.print(">>>");
		String id = inputStr.next();

		memberDAO.showOneMembers(id);
		System.out.println("=======================");
	}

	private void showAllMembers() throws SQLException {
		// 회원 전체보기 메서드
		System.out.println("=======================");
		memberDAO.showAllMembers();
		System.out.println("=======================");
	}

	public void addMember(Scanner inputStr) throws SQLException {
		// 회원가입 메서드 만들기
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("=========회원 가입===========");
		System.out.print("이름을 입력하세요 : ");
		memberDTO.setBwriter(inputStr.next());

		System.out.print("id를 입력하세요 : ");
		String id = inputStr.next();

		if (memberDAO.isIdExist(id)) {
			System.out.println("이미 존재하는 ID입니다.");
			return;
		}
		memberDTO.setId(id);

		System.out.print("pw를 입력하세요 : ");
		memberDTO.setPw(inputStr.next());

		memberDAO.addMember(memberDTO);
	}

	public MemberDTO login(Scanner inputStr) throws SQLException {
		// 로그인 메서드 만들기
		MemberDAO memberDAO = new MemberDAO();

		System.out.print("id를 입력하세요 : ");
		String id = inputStr.next();

		System.out.print("pw를 입력하세요 : ");
		String pw = inputStr.next();

		MemberDTO member = memberDAO.loginCheck(id, pw);
		if (member != null) {
			System.out.println("로그인 성공! 환영합니다, " + member.getBwriter() + "님");
			return member;
		} else {
			System.out.println("로그인 실패. ID 또는 비밀번호를 확인하세요.");
			return null;
		}
	}

}
