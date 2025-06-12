package mbcboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import mbcboard.dto.BoardDTO;

public class BoardDAO {
	// 게시판의 db와 연동을 담당하는 클래스
	// jdbc 5단계 프로세스 기반 구현
	// 1단계 : Connect 객체를 사용하여 ojdbc6.jar를 생성
	// 2단계 : url, id, pw, sql 쿼리문을 작성한다.
	// 3단계 : 쿼리문을 생성 및 실행한다.
	// 4단계 : 쿼리문 실행 결과 수신
	// 5단계 : db 연결 종료 및 자원 해제를 진행한다.

	// 필드
	public BoardDTO boardDTO = new BoardDTO(); // BoardDTO 객체 (게시글 데이터 저장용)
	public Connection connection = null; // DB 연결 객체 (1단계)
	public Statement statement = null; // SQL 쿼리 실행 객체 (3단계, 구형)
	public PreparedStatement preparedStatement = null; // SQL 쿼리 실행 객체 (3단계, 신형, ? 파라미터 사용)
	public ResultSet resultSet = null; // 쿼리 실행 결과 표 (4단계, select 결과)
	public int result = 0; // 쿼리 실행 결과 정수 (insert/update/delete 결과 수신)
	// 1개의 행이 삽입 | 수정 | 삭제 되었습니다. (정상처리 -> commit)
	// 0개의 행이 삽입 | 수정 | 삭제 되었습니다. (비정상처리 -> rollback)
	private BoardDTO dto;

	// 기본생성자
	public BoardDAO() {

		try {
			// 1단계 : oracle JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계 ojdbc6.jar 호출
			// 2단계 : DB 접속 연결 생성 (localhost, 포트 1521, SID xe, 사용자명 boardtest, 비밀번호
			// boardtest)
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "boardtest", "boardtest"); // 2단계
		} catch (ClassNotFoundException e) {
			// 드라이버 클래스 로드 실패 시 메시지 출력 및 프로그램 강제 종료
			System.out.println("드라이버 이름이나, ojdbc6.jar 파일이 잘못 되었습니다.");
			e.printStackTrace();
			System.exit(0); // 강제 종료
		} catch (SQLException e) {
			System.out.println("url, id, pw가 잘못 되었습니다. BoardDAO에 기본생성자를 확인하세요");
			e.printStackTrace();
			System.exit(0); // 강제 종료
		}

	}// 기본 생성자 종료

	// 메서드
	public void selectAll() throws SQLException { // throws SQLException 쿼리문 예외처리용
		// SQL를 사용하여 전체 목록 보기 결과 출력
		try {
			// 게시판 테이블에서 번호(bno), 제목(btitle), 작성자(bwriter), 작성일(bdate)을 내림차순 정렬하여 조회하는 SQL
			// 쿼리
			String sql = "select bno, btitle, bwriter, bdate from board order by bdate desc";
			// 데이터베이스에 board 테이블 내용을 가져오는 쿼리문

			statement = connection.createStatement(); // 쿼리문을 실행 객체 생성
			resultSet = statement.executeQuery(sql); // 쿼리문을 실행하여 결과를 표로 받는다.

			System.out.println("번호\t 제목\t 작성자\t 작성일\t");
			while (resultSet.next()) {
				// ResultSet의 다음 행으로 이동하며 각 컬럼 데이터 출력
				System.out.print(resultSet.getInt("bno") + "\t");
				System.out.print(resultSet.getString("btitle") + "\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.println(resultSet.getDate("bdate") + "\t");

			}
			System.out.println("=================끝=================");
		} catch (SQLException e) {
			// 오류발생시 예외처리문
			System.out.println("selectAll()메서드에 쿼리문이 잘못 되었습니다.");
			e.printStackTrace();
		} finally {
			// 항상실행문
			// DB 자원 해제 - 열린 ResultSet, Statement 닫기 (필수)
			// 열린 객체를 닫아야 다른 메서드도 정상 작동함.
			resultSet.close();
			statement.close();

		}
	}

	public void insertBoard(BoardDTO boardDTO) throws SQLException {
		// jdbc를 이용하여 insert 쿼리를 처리한다.
		// PreparedStatement 문을 사용해보자.
		// 동적쿼리문 이라고 하고 ?를 사용해서 세터로 입력한다.

		try {
			// 게시글 등록 쿼리 (게시글 번호는 시퀀스 BOARD_SEQ 사용, 작성일은 sysdate 자동 입력)
			String sql = "insert into board(bno, btitle, bcontent, bwriter, bdate) "
					+ " values(BOARD_SEQ.nextval, ?, ?, ?, sysdate)";
			// PreparedStatement 객체 생성
			preparedStatement = connection.prepareStatement(sql);

			// ? 위치에 DTO의 제목, 내용, 작성자 값을 바인딩
			preparedStatement.setString(1, boardDTO.getBtitle()); // 첫번째 ?에 dto객체에 있는 제목 넣음
			preparedStatement.setString(2, boardDTO.getBcontent()); // 두번째 ?에 dto 객체 내용 넣음
			preparedStatement.setString(3, boardDTO.getBwriter()); // 세번째 ?에 dto 객체 내용 넣음
			System.out.println("쿼리 확인 : " + sql); // 쿼리 완성본 확인용 (테스트)

			result = preparedStatement.executeUpdate(); // 쿼리문 실행해서 결과를 정수로 받음
			// result = preparedStatement.executeUpdate(sql); 오류발생

			if (result > 0) {
				System.out.println(result + "개의 게시물이 등록 되어 있습니다.");
				connection.commit(); // 영구저장
			} else {
				System.out.println("쿼리 실행 결과 : " + result);
				System.out.println("입력실패!!!");
				connection.rollback(); // 롤백(저장취소)
			}

		} catch (SQLException e) {
			System.out.println("예외발생 : insertBoard()메서드에 쿼리문을 확인하세요 ");
			e.printStackTrace();

		} finally {
			// 예외 발생 및 정상 실행후 무조건 처리되는 실행문
			preparedStatement.close();

		}

	}

	public void readOne(String title) throws SQLException {
		// 제목 문자열이 넘어온 것을 select 처리하여 출력 함

		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate from board where btitle= ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title); // service에서 넘어온 찾고 싶은 제목이 ?로 넘어간다.

			resultSet = preparedStatement.executeQuery(); // 쿼리문 실행 후 결과를 표로 받는다.

			if (resultSet.next()) {
				// 검색 결과가 있으면 DTO 객체에 저장 후 출력
				BoardDTO boardDTO = new BoardDTO();

				boardDTO.setBno(resultSet.getInt("bno"));
				boardDTO.setBtitle(resultSet.getString("btitle"));
				boardDTO.setBcontent(resultSet.getString("bcontent"));
				boardDTO.setBwriter(resultSet.getString("bwriter"));
				boardDTO.setBdate(resultSet.getDate("bdate"));
				// 데이터 베이스에 있는 행을 객체에 넣기 완료

				System.out.println("=========================");
				System.out.println("번호 : " + boardDTO.getBno());
				System.out.println("제목 : " + boardDTO.getBtitle());
				System.out.println("내용 : " + boardDTO.getBcontent());
				System.out.println("작성자 : " + boardDTO.getBwriter());
				System.out.println("작성일 : " + boardDTO.getBdate());

			} else {
				// 검색 결과가 없으면!!!
				System.out.println("해당하는 게시물이 존재하지 않습니다.");

			} // if문 종료

		} catch (SQLException e) {
			System.out.println("예외발생 : readOne() 메서드를 확인하세요");
			e.printStackTrace();
		} finally {
			// 항상 실행문
			resultSet.close();
			preparedStatement.close();
		}

	}

	public void modify(String title, Scanner inputStr) throws SQLException {
		// 제목을 찾아서 내용을 수정한다.

		BoardDTO boardDTO = new BoardDTO();
		Scanner inputLine = new Scanner(System.in);

		System.out.println("[수정할 내용을 입력하세요]");
		System.out.print("제목 : ");
		boardDTO.setBtitle(inputStr.next());

		System.out.print("내용 : ");
		boardDTO.setBcontent(inputLine.nextLine());

		try {
			// 제목을 기준으로 제목과 내용 수정, 작성일 sysdate로 갱신하는 쿼리
			String sql = "update board set btitle=? , bcontent =? , bdate=sysdate where btitle=? ";

			preparedStatement = connection.prepareStatement(sql);

			// ?에 각각 새 제목, 새 내용, 수정할 기존 제목 순서로 바인딩
			preparedStatement.setString(1, boardDTO.getBtitle());
			preparedStatement.setString(2, boardDTO.getBcontent());
			preparedStatement.setString(3, title);

			result = preparedStatement.executeUpdate(); // 쿼리문 실행후 결과를 정수로 보냄

			if (result > 0) {
				System.out.println(result + "개의 데이터가 수정 되었습니다. ");
				connection.commit(); // 영구 저장
			} else {
				System.out.println("수정이 되지 않았습니다.");
				connection.rollback();
			}

		} catch (SQLException e) {
			System.out.println("예외발생 : modify() 메서드와 sql문을 확인하세요!!!");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}

	}

	public void deleteOne(int selectBno) throws SQLException {
		// 서비스에서 받은 게시물의 번호를 이용하여 데이터를 삭제한다.

		try {
			// 게시글 번호를 기준으로 삭제하는 쿼리
			String sql = "delete from board where bno = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, selectBno);

			result = preparedStatement.executeUpdate(); // 쿼리문 실행 후 결과를 정수로 리턴

			if (result > 0) {
				System.out.println(result + "게시물이 삭제 되었습니다.");
				connection.commit();
			} else {
				System.out.println("게시물이 삭제되지 않았습니다.");
				connection.rollback();
			}

			System.out.println("=======================");
			selectAll(); // 삭제후 전체 리스트 보기

		} catch (SQLException e) {
			System.out.println("예외발생 : deleteOne() 메서드와 sql문을 확인하세요!!!");
			e.printStackTrace();
		} finally {
			preparedStatement.close();

		}

	}

	public BoardDTO getPostByNo(int bno) {
		// 게시글 번호로 단일 게시글 조회 후 DTO 리턴
		try {
			String sql = "SELECT bno, btitle, bcontent, bwriter, bdate FROM board WHERE bno = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bno);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				dto = new BoardDTO();
				dto.setBno(resultSet.getInt("bno"));
				dto.setBtitle(resultSet.getString("btitle"));
				dto.setBcontent(resultSet.getString("bcontent"));
				dto.setBwriter(resultSet.getString("bwriter"));
				dto.setBdate(resultSet.getDate("bdate"));
			}

		} catch (SQLException e) {
			System.out.println("getPostByNo() 메서드에서 오류 발생!");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

	public BoardDTO readOneReturn(String title) {
		try {
			String sql = "SELECT bno, btitle, bcontent, bwriter, bdate FROM board WHERE btitle = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title.trim()); // 공백 제거 후 비교
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				dto = new BoardDTO();
				dto.setBno(resultSet.getInt("bno"));
				dto.setBtitle(resultSet.getString("btitle"));
				dto.setBcontent(resultSet.getString("bcontent"));
				dto.setBwriter(resultSet.getString("bwriter"));
				dto.setBdate(resultSet.getDate("bdate"));
			}

		} catch (SQLException e) {
			System.out.println("readOneReturn() 메서드 오류 발생!");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}
}
