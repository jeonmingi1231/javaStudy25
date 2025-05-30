package ch05.maple;

import java.util.Scanner;

import ch04.mbcbank.DTO.AccountDTO;
import ch05.maple.DTO.Account;
import ch05.maple.DTO.ArcherDTO;
import ch05.maple.DTO.WarriorDTO;
import ch05.maple.service.CharacterService;
import ch05.maple.service.LoginService;

public class MapleExam {

	public static Scanner scanner = new Scanner(System.in);

	public static Account[] accounts = new Account[10];

	public static WarriorDTO warriorDTO = new WarriorDTO();

	public static ArcherDTO archerDTO = new ArcherDTO();

	private static Account loginAccount; // 로그인 성공시 객체

	static {
		warriorDTO.setSword("한손검");
		warriorDTO.setArmor("파란색가운");
		warriorDTO.setShield("나무방패");
		warriorDTO.setName("쩐사");
		warriorDTO.setSex("남");
		warriorDTO.setLevel("10");
		warriorDTO.setHp(300);
		warriorDTO.setMp(100);
		warriorDTO.setMoney(10000000);

		archerDTO.setBow("보우");
		archerDTO.setDress("빨간색원피스");
		archerDTO.setArrow("나무화살");
		archerDTO.setName("꿍수");
		archerDTO.setSex("여");
		archerDTO.setLevel("10");
		archerDTO.setHp(250);
		archerDTO.setMp(120);
		archerDTO.setMoney(10000000);

		Account account = new Account(); // 테스트용 계정생성
		account.setId("jjj");
		account.setPw("mmm");
		account.setNickName("ggg");
		accounts[0] = account; // 배열 0번에 계정객체를 연결

	} // db대신 초기값 지정(생성자 대신)

	public static void main(String[] args) {
		// 객체 간의 상속을 알아 본다.
		// 부모 객체 자식 객체에게 모든 정보를 상속한다.
		// 자식 객체는 부모 객체의 정보를 받아 사용하며 추가적인 정보를 생성하여 활용함

		System.out.println("=====메이플 게임을 시작합니다.======");

		boolean run = true;

		while (run) {
			System.out.println("1. 로그인 | 2. 캐릭터 선택 | 3. 게임 실행 | 4. 종료 ");
			System.out.print(">>>");

			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("로그인을 시작합니다.");
				loginAccount = LoginService.menu(scanner, accounts, loginAccount);
				
				break;
			case 2:
				System.out.println("캐릭터를 선택 합니다.");
				CharacterService.menu(scanner, loginAccount, warriorDTO, archerDTO);
				break;
			case 3:
				System.out.println("게임을 시작합니다.");
				break;
			case 4:
				System.out.println("종료 합니다.");
				run = false;
				break;
			default:
				System.out.println("1~4까지만 입력하세요");

			} // switch문 종료

		} // while문 종료

	} // main 메서드 종료

} // class 종료
