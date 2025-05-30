package ch05.maple.service;

import java.util.Scanner;

import ch05.maple.DTO.Account;
import ch05.maple.DTO.ArcherDTO;
import ch05.maple.DTO.WarriorDTO;

public class CharacterService {
// 객체를 이용하여 캐릭터 선택용 부메뉴
	public static void menu(Scanner scanner, Account loginAccount, WarriorDTO warriorDTO, ArcherDTO archerDTO) {

		System.out.println("1. 전사 | 2. 궁수 | 3. 마법사 | 4. 도적 | 5. 해적 | 9. *종료* ");
		System.out.print(">>>");
		int select = scanner.nextInt();
		switch (select) {
		case 1:
			System.out.println("전사를 선택하셨습니다.");
			break;
		case 2:
			System.out.println("궁수를 선택하셨습니다.");
			break;
		case 3:
			System.out.println("마법사를 선택하셨습니다.");
			break;
		case 4:
			System.out.println("도적를 선택하셨습니다.");
			break;
		case 5:
			System.out.println("해적를 선택하셨습니다.");
			break;
		case 9:
			System.out.println("*종료*를 선택하셨습니다.");
			break;
		default:
			System.out.println("캐릭터 선택하시려면 1~5까지만 입력해주세요.");

		} // 스위치문 종료
	} // 메뉴 메서드 종료
}// 클래스 종료
