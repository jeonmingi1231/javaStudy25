package ch04.mbcbank.service;

import java.util.Scanner;

import ch04.mbcbank.DTO.AccountDTO;

public class HanaBankService { // 메인에서 하나은행 관리 페이지 를 눌렀을때 나오는 로직들 만들기.
	// 서비스 페이지 에서는 crud생성함.
	// 필드

	// 생성자

	// 메서드
	public void menu(Scanner inputInt, Scanner inputStr, AccountDTO[] hanaBank) { // 메인에서 사용할 객체.
		boolean subRun = true;
		while (subRun) {
			System.out.println("----------------------------");
			System.out.println("하나은행 계좌관리 메서드 입니다.");
			System.out.println("1. 계좌생성");
			System.out.println("2. 계좌목록보기");
			System.out.println("3. 예금");
			System.out.println("4. 출금");
			System.out.println("5. 이체");
			System.out.println("6. 종료");
			System.out.print(">>>");
			String select = inputStr.next();
			switch (select) { // 스위치/케이스로 위에 sysout을 눌렀을때 의 출력을 만들고
			// 그 후 케이스별로 필요한 메서드를 만들어 완성한다.

			case "1":
				System.out.println("===계좌생성 메서드로 진입합니다.===");
				creatAccount(inputInt, inputStr, hanaBank);
				break;
			case "2":
				System.out.println("===계좌목록보기 메서드로 진입합니다.===");
				accountLists(inputInt, inputStr, hanaBank);
				break;
			case "3":
				System.out.println("===계좌입금 메서드로 진입합니다.===");
				deposit(inputInt, inputStr, hanaBank);
				break;
			case "4":
				System.out.println("===계좌출금 메서드로 진입합니다.===");
				Withdrawal(inputInt, inputStr, hanaBank);
				break;
			case "5":
				System.out.println("===계좌이체 메서드로 진입합니다.===");
				break;
			case "6":
				System.out.println("===하나은행을 종료합니다.===");
				System.out.println("===메인메뉴로 복귀합니다.===");
				subRun = false;
				break;
			default:
				System.out.println("1~6까지만 입력하세요");
				break;
			}// switch 종료

		} // while 종료

	}// menu메서드 종료

	private void Withdrawal(Scanner inputInt, Scanner inputStr, AccountDTO[] hanaBank) {
	// 계좌출금 메서드 만들기
		System.out.println("=====출금=====");
		System.out.print("계좌번호 :  ");
		String ano = inputStr.next();
		System.out.print("출금액 :  ");
		int money = inputInt.nextInt();
		AccountDTO inputAccount = findAccount(ano, hanaBank);
		// findAccount 메서드는 배열에서 객체를 찾아주고 객체를 리턴해준다.(반복코드 배제용)
		if (inputAccount == null) {
			System.out.println("찾는 계좌번호가 없습니다.");
			return;
		}
		inputAccount.setBalance(inputAccount.getBalance() - money); // 출금은 -
		System.out.println("출금 테스트 결과 : " + inputAccount);
		// toString 으로 결과 보기.
		System.out.println(inputAccount.getOwner() + "님 출금이 성공되었습니다.");
		System.out.println("잔액 : " + inputAccount.getBalance() + "원");
		System.out.println("===============================");
}// 계좌출금 메서드 Withdrawal 종료

	private void deposit(Scanner inputInt, Scanner inputStr, AccountDTO[] hanaBank) {
		// 입금용 메서드 만들기
		// 계좌번호를 입력하고 입금액을 입력하면 계좌번호를 찾아서 계좌잔액을 증가시킴.
		System.out.println("=====예금=====");
		System.out.print("계좌번호 :  ");
		String ano = inputStr.next();
		System.out.print("예금액 :  ");
		int money = inputInt.nextInt();
		AccountDTO inputAccount = findAccount(ano, hanaBank);
		// findAccount 메서드는 배열에서 객체를 찾아주고 객체를 리턴해준다.(반복코드 배제용)
		if (inputAccount == null) {
			System.out.println("찾는 계좌번호가 없습니다.");
			return;
		}
		inputAccount.setBalance(inputAccount.getBalance() + money); // 입금은 +
		System.out.println("입금 테스트 결과 : " + inputAccount);
		// toString 으로 결과 보기.
		System.out.println(inputAccount.getOwner() + "님 입금이 성공되었습니다.");
		System.out.println("잔액 : " + inputAccount.getBalance() + "원");
		System.out.println("===============================");

	}// 입금용 메서드 종료

	private AccountDTO findAccount(String ano, AccountDTO[] hanaBank) {
		// 계좌 찾기 메서드 시작
		// 입금,출금,이체에서 계좌번호를 이용해 객체를 찾는 반복코드 메서드.
		AccountDTO account = null; // 빈객체
		for (int i = 0; i < hanaBank.length; i++) {
			if (hanaBank[i] != null) {
				// 하나은행이 null이 아님.
				String dbAno = hanaBank[i].getAno();
				// 배열에 있는 계좌번호를 가졍좌 dbAno 변수에 넣음.
				if (dbAno.equals(ano)) {
					// 키보드로 입력받은 계좌번호와 dbAno와 같은 값을 찾는다.
					account = hanaBank[i];
					// 빈객체에 찾은 객체를 넣는다.
					break; // 한번 찾았기 떄문에 break;
				} // dbAno equals 종료.
			} // if문 종료
		} // for문 종료

		return account;
	}// 계좌찾기 종료.

	private void accountLists(Scanner inputInt, Scanner inputStr, AccountDTO[] hanaBank) {
		// 계좌목록보기 메서드 만들기 하나은행에 있는 계정을 모두 봄 (은행원 용)
		System.out.println("=====하나은행 계좌 리스트=====");
		for (int i = 0; i < hanaBank.length; i++) {
			AccountDTO accountlist = hanaBank[i]; // 배열로 list확인
			if (accountlist != null) {
				// 배열의 값이 null이 아니면 출력함.
				System.out.print(accountlist.getAno());
				System.out.print("\t");

				System.out.print(accountlist.getOwner());
				System.out.print("\t");

				System.out.print(accountlist.getBalance());
				System.out.print("\t\n");
				System.out.println("-----------------------");
			} // if문 종료
		} // for 문 종료

	}// accountLists 계좌목록보기 메서드 종료

	private void creatAccount(Scanner inputInt, Scanner inputStr, AccountDTO[] hanaBank) { // 계좌 생성 메서드 시작
		// 여기서 키보드로 입력받은 객체를 AccountDTO[] hanaBank 여기 배열에 넣는다.
		System.out.println("=====계좌를 생성합니다=====");
		AccountDTO myAccount = new AccountDTO(); // 빈 객체 생성

		System.out.print("계좌번호 :");
		myAccount.setAno(inputStr.next());

		System.out.print("계좌주 :");
		myAccount.setOwner(inputStr.next());

		System.out.print("초기입금액 :");
		myAccount.setBalance(inputInt.nextInt());
		myAccount.setBankname("하나"); // 이 페이지에서 "하나"은행이 고정이기 때문에 키보드로 입력 안받고 지정한 "하나"가 뜨게 코드 넣음

		// 하나은행 배열에 객체를 삽입. ( for 문을 사용해 , null 인지 먼저 판단하고 null이 확인되면 넣음)
		for (int i = 0; i < hanaBank.length; i++) { // 배열돌릴때 쓰는 공식
			if (hanaBank[i] == null) {
				// 하나은행 배열에 null이 확인되면 처리하는 코드.
				hanaBank[i] = myAccount;
				System.out.println("계좌입력 테스트 : " + hanaBank[i]);
				break; // 1개만 보이기 위해 브레이크.
			} //if문 종료

		}//for문 종료

	} // 계좌 생성 메서드 종료

}// 클래스종료
