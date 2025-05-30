package ch05.maple.service;

import java.util.Scanner;

import ch05.maple.DTO.Account;

public class LoginService {
// 로그인에 관한 부메뉴 용

	public static Account menu(Scanner scanner, Account[] accounts, Account loginAccount) {
		System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원수정 | 4. 뒤로가기");
		System.out.print(">>>");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			System.out.println("로그인을 시작합니다.");
			System.out.print("id : ");
			String id = scanner.next();

			System.out.print("pw : ");
			String pw = scanner.next();
			Account account = new Account();
			account.setId(id);
			account.setPw(pw); // 새로만든 account 객체에 id,pw 삽입

			// 배열에 있는 값과 비교
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i] != null) {
					if (accounts[i].getId().equals(account.getId())) {
						System.out.println("해당하는 id가 있습니다.");
						if (accounts[i].getPw().equals(account.getPw())) {
							System.out.println("해당하는 pw가 있습니다.");
							loginAccount = accounts[i];
							System.out.println("로그인 성공!!!");
							break;
						} else {
							System.out.println("해당하는 pw가 없습니다.");
						}
					} else {
						System.out.println("해당하는 id가 없습니다.");
					}
				} else {
					System.out.println("해당하는 정보가 없습니다.");
					System.out.println("로그인 실패!!!");
					break;
				} // 빈객체 비교
			} // for문종료
			break;
		/*
		 * case 2: System.out.println("===회원가입을 시작합니다.===");
		 * System.out.println("ID를 입력하세요"); System.out.print(">>>"); String newid =
		 * scanner.next(); //키보드로 회원가입할 아이디 입력받기
		 * 
		 * for(int i = 0 ; i < accounts.length; i++) { if (accounts[i] != null &&
		 * accounts[i].getId().equals(newid)) {
		 * System.out.println("이미 존재하는 ID입니다. 다시 시도하세요."); } else {
		 * System.out.println("PW를 입력하세요"); System.out.print(">>>"); String newpw =
		 * scanner.next();
		 * 
		 * public static Account newAccount = new Account(); newAccount.setId(newid);
		 * newAccount.setPw(newpw); // accounts 배열에서 빈 공간 찾아 새 계정 넣기
		 * 
		 * boolean added = false;
		 * 
		 * for (int i = 0; i < accounts.length; i++) { if (accounts[i] == null) {
		 * accounts[i] = newAccount; System.out.println("회원가입 성공!"); added = true;
		 * break; } } if (!added) { System.out.println("회원가입 실패: 계정 저장 공간이 부족합니다.");
		 */
				
						
						
			
		}// switch문종료

		return loginAccount; // void 안쓰니까 리턴쓰기

	}// menu메서드종료

}// 클레스 종료