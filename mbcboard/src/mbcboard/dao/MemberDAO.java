package mbcboard.dao;

import java.io.InputStream;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import mbcboard.dto.MemberDTO;

public class MemberDAO {
	public MemberDTO memberDTO = new MemberDTO(); // MemberDTO 객체 하나 선언

	public Connection connection = null; // DB와 연결을 담당하는 객체
	public Statement statement = null; // SQL문 실행용 구식 객체(직접 문자열 조합시 사용)
	public PreparedStatement preparedStatement = null; // // SQL문 실행용 신식 객체 (파라미터 ? 사용)
	public ResultSet resultSet = null; // 쿼리 실행 결과를 저장하는 객체 (select 결과 표)
	public int result = 0; // 쿼리 실행 후 영향 받은 행(row) 수를 저장하는 변수

	// 기본생성자 - DB 연결 설정 수행
	public MemberDAO() {
		try {
			// oracle 드라이버 클래스 로드 (jdbc 드라이버 등록)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DB 연결 생성(주소,계정명,비밀번호)
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "boardtest", "boardtest");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 이름이나, ojdbc6.jar 파일이 잘못 되었습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("url, id, pw가 잘못 되었습니다. BoardDAO에 기본생성자를 확인하세요");
			e.printStackTrace();
		}
	} // 기본 생성자 종료

	public void showAllMembers() throws SQLException {// mno bwriter id pw regidate
		// 회원 전체보기 dao 만들기

		try {
			// SQL 쿼리 : 회원 정보를 최근 등록일 기준으로 내림차순 조회
			// 데이터베이스에 member 테이블 내용을 가져오는 쿼리문
			String sql = "select mno, bwriter, id, pw, regidate from member order by regidate desc";

			statement = connection.createStatement(); // 쿼리문을 실행 객체 생성

			resultSet = statement.executeQuery(sql); // 쿼리문을 실행하여 resultSet에 저장

			// 결과 출력 (컬럼 명과 각 행 데이터 출력)
			System.out.println("번호\t 작성자\t id\t pw\t 회원등록일\t");
			while (resultSet.next()) {
				// 각 컬럼 값을 타입에 맞게 받아 출력
				System.out.print(resultSet.getInt("mno") + "\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.print(resultSet.getString("id") + "\t");
				System.out.print(resultSet.getString("pw") + "\t");
				System.out.println(resultSet.getDate("regidate") + "\t");
			}
			System.out.println("===========끝=============");

		} catch (SQLException e) {
			System.out.println("selectAll()메서드에 쿼리문이 잘못 되었습니다.");
			e.printStackTrace();
		} finally {
			// 사용한 자원들 반드시 달기 (메모리 누수 방지)
			resultSet.close();
			statement.close();
		}

	} // 회원 전체보기 showAllmembers 메서드 종료

	public void showOneMembers(String id) throws SQLException {
		// 회원 개인 보기 dao 만들기
		try {
			// SQL 쿼리 : id가 일치하는 회원 조회
			String sql = "select mno, bwriter, id, pw, regidate from member where id=?";

			// preparedStatement 생성 및 id 파라미터 설정
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);

			// 쿼리 실행
			resultSet = preparedStatement.executeQuery();
			// 결과가 있으면(회원이 있으면)
			if (resultSet.next()) {
				// 회원 정보를 담을 빈 DTO 객체 생성
				MemberDTO memberDTO = new MemberDTO(); // 빈 객체 생성

				// resultSet 에서 한 행식 읽어 DTO에 세팅
				memberDTO.setMno(resultSet.getInt("mno"));
				memberDTO.setBwriter(resultSet.getString("bwriter"));
				memberDTO.setId(resultSet.getString("id"));
				memberDTO.setPw(resultSet.getString("pw"));
				memberDTO.setRegidate(resultSet.getDate("regidate"));
				// 데이터 베이스에 있는 행을 객체에 넣기 완료

				// 조회한 회원 정보 출력
				System.out.println("===========정보=============");
				System.out.println("번호" + memberDTO.getMno());
				System.out.println("작성자" + memberDTO.getBwriter());
				System.out.println("id" + memberDTO.getId());
				System.out.println("pw" + memberDTO.getPw());
				System.out.println("가입일" + memberDTO.getRegidate());

			} else {
				// 회원이 없으면 나타내는 메세지
				System.out.println("없는회원 입니다.");
			} // if문 종료
		} catch (SQLException e) {
			System.out.println("예외발생 : showOneMembers() 메서드를 확인하세요");
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
		}

	}

	public void addMember(MemberDTO memberDTO) throws SQLException {
		// 회원 추가 메서드 만들기

		try {
			// sql 쿼리 : 회원정보 insert, 시퀀스와 sysdate 사용
			String sql = "insert into member(mno, bwriter, id, pw, regidate)"
					+ "values(board_seq.nextval, ?, ?, ?, sysdate)";

			// preparedStatement 생성 및 파라미터 설정
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getBwriter());
			preparedStatement.setString(2, memberDTO.getId());
			preparedStatement.setString(3, memberDTO.getPw());

			// 쿼리 확인용 출력 (디버깅 목적)
			System.out.println("쿼리 확인 : " + sql);

			// 쿼리 실행 후 영향 받은 행 수를 result에 저장
			result = preparedStatement.executeUpdate();

			if (result > 0) {
				// 1개 이상 행이 영향 받으면 성공 및 커밋
				System.out.println(result + "개의 회원이 등록 되었습니다.");
				connection.commit();
			} else {
				// 영향 받은 행이 없으면 실패 및 롤백
				System.out.println("쿼리 실행 결과 : " + result);
				System.out.println("입력실패!!!");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("예외발생 : addMember()메서드에 쿼리문을 확인하세요 ");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		} // try문 종료

	} // add 메서드 종료

	public void updMember(String id, Scanner inputStr) throws SQLException {
		// 회원 정보 수정 메서드 만들기
		MemberDTO memberDTO = new MemberDTO();

		System.out.print("[수정할 회원의 새로운 id/pw 를 입력하세요]");
		System.out.print("새로운 id를 입력하세요 : ");
		memberDTO.setId(inputStr.next());

		System.out.print("새로운 pw를 입력하세요 : ");
		memberDTO.setPw(inputStr.next());

		try {
			// sql 쿼리 : id 를 조건으로 새로운 id,pw 로 업데이트 수정일 sysdate 로 변경
			String sql = "update member set id=? , pw=?, regidate=sysdate where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			preparedStatement.setString(2, memberDTO.getPw());
			preparedStatement.setString(3, id);

			// 쿼리 실행
			result = preparedStatement.executeUpdate();

			if (result > 0) {
				System.out.println(result + "개의 회원이 수정 되었습니다. ");
				connection.commit(); // 영구 저장
			} else {
				System.out.println("수정 실패!");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("예외발생 : updMember() 메서드와 sql문을 확인하세요!!!");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}

	}

	public void delMember(String id) throws SQLException {
		// 회원 삭제 메서드 만들기
		try {
			// sql 쿼리 : id에 해당하는 회원 삭제
			String sql = "delete from member where id =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);

			// 쿼리 실행
			result = preparedStatement.executeUpdate();

			if (result > 0) {
				System.out.println(result + "게시물이 삭제 되었습니다.");
				connection.commit(); // 영구저장
			} else {
				System.out.println("삭제 실패!!!");
				connection.rollback(); // 실패 시 롤백

			} // if-else 종료
			System.out.println("=============================");
			showAllMembers(); // 삭제 후 전체 리스트 출력
		} catch (SQLException e) {
			System.out.println("예외발생 : delMembers 메서드와 sql문을 확인하세요!!!");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		} // thy-catch-finally 종료

	} // del메서드 종료

	public boolean isIdExist(String id) throws SQLException {
		// 입력 된 id 가 DB에 존재하는지 확인하는 메서드 (회원가입 시 중복 체크용)
		String sql = "SELECT id FROM member WHERE id = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			// 결과가 있으면 true, 없으면 false 반환
			return resultSet.next();
		} finally {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
		}
	}

	public MemberDTO loginCheck(String id, String pw) throws SQLException {
		// 로그인 시 id,pw 검사 후 회원 정보 반환 메서드
		try {
			// sql 쿼리 : id 와 pw 가 일치하는 회원 검색
			String sql = "SELECT * FROM member WHERE id = ? AND pw = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);

			// 쿼리 실행
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// 로그인 성공 시, 회원 정보 DTO 객체에 세팅 후 반환
				MemberDTO session = new MemberDTO();

				session.setMno(resultSet.getInt("mno"));
				session.setBwriter(resultSet.getString("bwriter"));
				session.setId(resultSet.getString("id"));
				session.setPw(resultSet.getString("pw"));
				session.setRegidate(resultSet.getDate("regidate"));
				return session;
			}
		} catch (SQLException e) {
			System.out.println("오류 발생 : loginCheck 메서드와 sql문을 확인하세요");
			e.printStackTrace();

		} finally {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
		}
		// 로그인 실패시 null반환
		return null;
	}
}
