package mbcboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.BoardExam;
import mbcboard.dao.BoardDAO;
import mbcboard.dto.BoardDTO;
import mbcboard.dto.MemberDTO;

public class BoardService {
	// 게시판과 관련된 기능을 처리하는 서비스 클래스
	// BoardDAO를 통해 DB와 연동하고, 메뉴와 CRUD 작업을 담당함

	// 필드 - DB 작업을 담당하는 BoardDAO 객체를 하나 만듦
	public BoardDAO boardDAO = new BoardDAO(); // 1단계, 2단계가 수행 된다.

	// 생성자 

	// 게시판 부메뉴를 보여주고, 사용자의 입력을 받아 기능을 실행 하는 메서드
	// 로그인한 회원 정보를 session으로 받아서 로그인 상태를 확인함.
	public void subMenu(Scanner inputStr, MemberDTO session) throws SQLException {
		boolean subRun = true; // 메뉴 반복 실행을 위한 변수 
		while (subRun) {
			System.out.println("MBC아카데미 게시판 서비스 입니다.");
			System.out.println("1. 모두보기");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 게시글 자세히 보기");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 게시글 삭제");
			System.out.println("6. 뒤로가기");
			System.out.print(">>>");
			String subSelect = inputStr.next(); // 사용자 메뉴 선택 입력 받음

			switch (subSelect) {
			case "1":
				System.out.println("모든 게시글 보기");
				selectAll(boardDAO);
				break;
			case "2":
				if (session == null) {
					System.out.println("로그인 후 이용 가능합니다.");
				} else {
					System.out.println("게시글 작성메서드로 진입합니다.");
					insertBoard(boardDAO, inputStr, session);
				}

				break;
			case "3":
				System.out.println("게시글 자세히 보기");
				readOne(inputStr);
				break;
			case "4":
				if (session == null) {
					System.out.println("로그인 후 이용 가능합니다.");
				} else {
					System.out.println("게시글 수정메서드로 진입합니다.");
					modify(inputStr, session);
				}
				break;
			case "5":
				if (session == null) {
					System.out.println("로그인 후 이용 가능합니다.");
				} else {
					System.out.println("게시글 삭제메서드로 진입합니다.");
					deleteOne(inputStr, session);
				}
				break;
			case "6":
				System.out.println("이전으로 돌아갑니다.");
				boardDAO.connection.close(); // 게시판 종료시 connection 종료
				subRun = false;
				break;

			} // switch문 종료(부메뉴)

		} // while 문 종료 (부메뉴 반복)
	} // 부메뉴 메서드 종료

	private void deleteOne(Scanner inputStr, MemberDTO session) throws SQLException {
		// 게시물의 번호를 받아 삭제한다.
		System.out.println("삭제하려는 게시글의 번호를 입력하세요");
		Scanner inputInt = new Scanner(System.in);
		System.out.print(">>>");
		int selectBno = inputStr.nextInt(); // 게시글 번호 입력

		BoardDTO post = boardDAO.getPostByNo(selectBno); // DB에서 게시글 정보 가져오기
		if (post == null) {
			System.out.println("해당 게시글이 없습니다.");
			return; 
		}
		if (!post.getBwriter().equals(session.getId())) { 
			// 게시글 작성자와 로그인한 아이디가 다르면 삭제 불가
			System.out.println("본인이 작성한 글만 삭제할 수 있습니다.");
			return;
		}
		boardDAO.deleteOne(selectBno);
		System.out.println("게시글이 삭제 되었습니다.");

	}

	private void modify(Scanner inputStr, MemberDTO session) throws SQLException {
		// 제목을 찾아서 내용을 수정한다.
		System.out.println("수정하려는 게시글의 제목을 입력하세요!");
		System.out.print(">>>");
		
		inputStr.nextLine(); // 버퍼 지우기
		String title = inputStr.nextLine();

		BoardDTO post = boardDAO.readOneReturn(title);
		if (post == null) {
			System.out.println("해당 게시글이 없습니다.");
			return;
		}

		// 작성자 확인
		if (!post.getBwriter().equals(session.getId())) {
			System.out.println("본인이 작성한 글만 수정할 수 있습니다.");
			return;
		}

		// 수정 진행
		boardDAO.modify(title, inputStr);
		System.out.println("========끝==========");

	}

	private void readOne(Scanner inputStr) throws SQLException {
		// 제목을 입력하면 내용이 보이도록 select 처리
		System.out.println("보고싶은 게시글의 제목을 입력하세요!");
		System.out.print(">>>");
		String title = inputStr.next();

		boardDAO.readOne(title);
		System.out.println("========끝==========");

	} // readOne메서드 종료

	private void insertBoard(BoardDAO boardDAO, Scanner inputStr, MemberDTO session) throws SQLException {
		//  게시글 작성 메서드 - 입력받은 내용 DTO에 담고 DB에 저장
		BoardDTO boardDTO = new BoardDTO(); // 게시글 정보를 담을 빈객체 생성
		
		boardDTO.setBwriter(session.getId()); // 로그인 된 아이디로 작성자 설정
		//System.out.print("작성자 : ");
		//boardDTO.setBwriter(inputStr.next());

		System.out.print("제목 : ");
		boardDTO.setBtitle(inputStr.next()); // 제목을 입력받아 DTO에 저장
		
		Scanner inputLine = new Scanner(System.in); // 띄어쓰기 를 포함해서 입력 받기위해 nextline 만듬
		System.out.print("내용 : ");
		boardDTO.setBcontent(inputLine.nextLine()); // 띄어쓰기가 있는 문장!!!! nextLine()

		boardDAO.insertBoard(boardDTO); // DB에 게시글 저장 요청
		System.out.println("==========insertBoard메서드 종료==========");

	} // insertBoard()메서드 종료

	private void selectAll(BoardDAO boardDAO) throws SQLException {
		// dao에게 전체보기 하는 서비스를 제공한다.
		System.out.println("=======================");
		System.out.println("====MBC게시판목록입니다====");
		boardDAO.selectAll();
		System.out.println("=======================");

	} // 전체 보기 메서드 종료

}
