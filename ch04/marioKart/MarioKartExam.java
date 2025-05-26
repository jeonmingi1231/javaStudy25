package ch04.marioKart;

import java.util.Random;
import java.util.Scanner;

import ch04.marioKart.dto.CartDTO;
import ch04.marioKart.dto.CharacterDTO;
import ch04.marioKart.dto.GliderDTO;
import ch04.marioKart.dto.ItemDTO;
import ch04.marioKart.dto.MemberDTO;
import ch04.marioKart.dto.TireDTO;
import ch04.marioKart.service.MemberService;

public class MarioKartExam {
	public static Scanner input = new Scanner(System.in);

	// 회원, 캐릭터, 카트, 글라이더, 타이어, 아이템 배열 선언
	public static MemberDTO[] memberDTOs = new MemberDTO[10];
	public static CharacterDTO[] characterDTOs = new CharacterDTO[15];
	public static CartDTO[] cartDTOs = new CartDTO[8];
	public static GliderDTO[] gliderDTOs = new GliderDTO[10];
	public static TireDTO[] tireDTOs = new TireDTO[10];
	public static ItemDTO[] itemDTOs = new ItemDTO[10];

	// 현재 로그인 상태인 회원 객체
	public static MemberDTO loginState;

	// 초기값 세팅(캐릭터, 카트, 글라이더, 타이어, 아이템)
	static {
		characterDTOs[0] = new CharacterDTO("마리오", 3.0, 4.5, 3.7, 4.1, 3.8);
		characterDTOs[1] = new CharacterDTO("루이지", 3.2, 4.4, 3.1, 4.4, 3.2);
		characterDTOs[2] = new CharacterDTO("와리오", 3.0, 4.2, 3.2, 4.2, 3.4);
		characterDTOs[3] = new CharacterDTO("피치", 3.1, 4.8, 3.4, 4.5, 3.5);

		cartDTOs[0] = new CartDTO("스피드카트", 4.0, 3.5, 4.0, 3.0);
		cartDTOs[1] = new CartDTO("파워카트", 3.5, 4.0, 3.5, 4.0);

		gliderDTOs[0] = new GliderDTO("스피드 글라이더", 3.0, 3.5, 3.2, 2.8);
		gliderDTOs[1] = new GliderDTO("파워 글라이더", 2.8, 3.8, 3.0, 3.2);
		gliderDTOs[2] = new GliderDTO("밸런스 글라이더", 2.9, 3.6, 3.3, 3.0);
		gliderDTOs[3] = new GliderDTO("라이트 글라이더", 3.2, 3.4, 3.1, 2.6);

		tireDTOs[0] = new TireDTO("스포츠 타이어", 3.5, 3.0, 3.4, 2.7);
		tireDTOs[1] = new TireDTO("오프로드 타이어", 3.0, 3.5, 3.2, 3.1);
		tireDTOs[2] = new TireDTO("슬릭 타이어", 3.7, 2.8, 3.0, 2.5);
		tireDTOs[3] = new TireDTO("클래식 타이어", 3.2, 3.3, 3.1, 2.9);

		itemDTOs[0] = new ItemDTO("버섯", "일시적으로 속도 증가");
		itemDTOs[1] = new ItemDTO("파워별", "공격 아이템 사용 가능");
		itemDTOs[2] = new ItemDTO("껍질", "앞의 적 공격");
		itemDTOs[3] = new ItemDTO("바나나", "뒤 차량 미끄러짐");
	}

	public static void main(String[] args) {
		System.out.println("======= 마리오 카트 게임을 시작합니다. =======");
		boolean run = true;

		while (run) {
			System.out.println("\n1. 회원관리 | 2. 카트관리 | 3. 게임실행 | 4. 종료");
			System.out.print(">>> ");
			int select = input.nextInt();
			input.nextLine();

			switch (select) {
			case 1:
				// 회원 관련 메뉴 실행 및 로그인 상태 갱신
				MemberService memberService = new MemberService();
				loginState = memberService.menu(input, memberDTOs, loginState);
				if (loginState != null) {
					System.out.println("현재 로그인한 회원: " + loginState.nickName);
				} else {
					System.out.println("로그인된 회원이 없습니다.");
				}
				break;

			case 2:
				// 카트 관리 메뉴 호출
				manageCarts();
				break;

			case 3:
				// 로그인 상태 확인 후 게임 실행
				if (loginState == null) {
					System.out.println("게임 실행을 위해서는 로그인하세요.");
				} else {
					runGame();
				}
				break;

			case 4:
				// 게임 종료
				run = false;
				break;

			default:
				System.out.println("1~4번 숫자만 입력하세요.");
			}
		}
		System.out.println("게임 종료합니다. 감사합니다!");
		input.close();
	}

	// 카트 관리 메뉴 메서드
	private static void manageCarts() {
		boolean cartrun = true;

		while (cartrun) {
			System.out.println("\n=====[카트관리]=====");
			System.out.println("1. 카트 목록 보기");
			System.out.println("2. 카트 등록");
			System.out.println("3. 카트 삭제");
			System.out.println("4. 뒤로가기");
			System.out.print("선택 >> ");
			int cartMenu = input.nextInt();
			input.nextLine();

			switch (cartMenu) {
			case 1:
				// 등록된 카트 목록 출력
				System.out.println("=== 등록된 카트 목록 ===");
				for (int i = 0; i < cartDTOs.length; i++) {
					if (cartDTOs[i] != null) {
						System.out.print((i + 1) + ". ");
						cartDTOs[i].display();
					}
				}
				break;

			case 2:
				// 새 카트 등록
				System.out.println("새 카트를 등록합니다.");
				System.out.print("카트 이름 입력: ");
				String name = input.nextLine();

				System.out.print("속도 입력: ");
				double speed = input.nextDouble();

				System.out.print("가속 입력: ");
				double acceleration = input.nextDouble();

				System.out.print("핸들링 입력: ");
				double handling = input.nextDouble();

				System.out.print("무게 입력: ");
				double weight = input.nextDouble();
				input.nextLine();

				CartDTO newCart = new CartDTO(name, speed, acceleration, handling, weight);

				// 빈 공간에 새 카트 저장
				boolean added = false;
				for (int i = 0; i < cartDTOs.length; i++) {
					if (cartDTOs[i] == null) {
						cartDTOs[i] = newCart;
						System.out.println("카트가 등록되었습니다.");
						added = true;
						break;
					}
				}
				if (!added) {
					System.out.println("카트 등록 공간이 부족합니다.");
				}
				break;

			case 3:
				// 카트 삭제
				System.out.print("삭제할 카트 번호 입력 >> ");
				int delIndex = input.nextInt();
				input.nextLine();

				if (delIndex >= 1 && delIndex <= cartDTOs.length && cartDTOs[delIndex - 1] != null) {
					System.out.println(cartDTOs[delIndex - 1].name + " 카트가 삭제되었습니다.");
					cartDTOs[delIndex - 1] = null;
				} else {
					System.out.println("잘못된 번호이거나 카트가 존재하지 않습니다.");
				}
				break;

			case 4:
				// 카트관리 메뉴 종료
				cartrun = false;
				break;

			default:
				System.out.println("1~4 사이의 값만 입력하세요.");
			}
		}
	}

	// 게임 실행 메서드
	private static void runGame() {
		System.out.println("\n=== 게임 시작 ===");
		System.out.println(loginState.nickName + "님 환영합니다!");

		// 각 부품 선택
		CharacterDTO chosenCharacter = selectCharacter();
		CartDTO chosenCart = selectCart();
		GliderDTO chosenGlider = selectGlider();
		TireDTO chosenTire = selectTire();

		// 선택한 부품 정보 출력
		System.out.println("\n==== 조합된 정보 ====");
		chosenCharacter.display();
		chosenCart.display();
		chosenGlider.display();
		chosenTire.display();

		// 총합 스탯 계산 (단순 합산)
		double totalSpeed = chosenCharacter.speed + chosenCart.speed + chosenGlider.speed + chosenTire.speed;
		double totalAcceleration = chosenCharacter.acceleration + chosenCart.acceleration + chosenGlider.acceleration
				+ chosenTire.acceleration;
		double totalHandling = chosenCharacter.handling + chosenCart.handling + chosenGlider.handling
				+ chosenTire.handling;
		double totalWeight = chosenCharacter.weight + chosenCart.weight + chosenGlider.weight + chosenTire.weight;

		// 총합 스탯 출력
		System.out.println("총 속도: " + totalSpeed);
		System.out.println("총 가속: " + totalAcceleration);
		System.out.println("총 핸들링: " + totalHandling);
		System.out.println("총 무게: " + totalWeight);

		// 랜덤 아이템 획득
		ItemDTO randomItem = getRandomItem();
		System.out.println("\n아이템 획득: " + randomItem.name + " - " + randomItem.effect);

		// 간단한 게임 시뮬레이션: 플레이어 점수 계산 및 경쟁자 점수와 비교
		System.out.println("\n레이스 시작!");
		Random rnd = new Random();
		int playerScore = (int) (totalSpeed * 10 + totalAcceleration * 8 + totalHandling * 6 - totalWeight * 5);
		playerScore += rnd.nextInt(20); // 랜덤 변수 추가

		int rivalScore = rnd.nextInt(150);

		System.out.println("당신의 점수: " + playerScore);
		System.out.println("상대 점수: " + rivalScore);

		if (playerScore > rivalScore) {
			System.out.println("축하합니다! 당신이 이겼습니다!");

		} else {
			System.out.println("아쉽지만 졌습니다. 다음에 다시 도전하세요!");
		}

		System.out.println("게임이 종료됩니다.\n");
	}

	// 캐릭터 선택 메서드
	private static CharacterDTO selectCharacter() {
		System.out.println("\n캐릭터를 선택하세요.");
		for (int i = 0; i < characterDTOs.length; i++) {
			if (characterDTOs[i] != null) {
				System.out.print((i + 1) + ". ");
				characterDTOs[i].display();
			}
		}
		System.out.print("번호 입력 >>> ");
		int sel = input.nextInt();
		input.nextLine();

		// 잘못된 선택시 기본 캐릭터 반환
		if (sel < 1 || sel > characterDTOs.length || characterDTOs[sel - 1] == null) {
			System.out.println("잘못된 선택입니다. 기본 캐릭터(마리오)를 선택합니다.");
			return characterDTOs[0];
		}
		return characterDTOs[sel - 1];
	}

	// 카트 선택 메서드
	private static CartDTO selectCart() {
		System.out.println("\n카트를 선택하세요.");
		for (int i = 0; i < cartDTOs.length; i++) {
			if (cartDTOs[i] != null) {
				System.out.print((i + 1) + ". ");
				cartDTOs[i].display();
			}
		}
		System.out.print("번호 입력 >>> ");
		int sel = input.nextInt();
		input.nextLine();

		// 잘못된 선택시 기본 카트 반환
		if (sel < 1 || sel > cartDTOs.length || cartDTOs[sel - 1] == null) {
			System.out.println("잘못된 선택입니다. 기본 카트(스피드카트)를 선택합니다.");
			return cartDTOs[0];
		}
		return cartDTOs[sel - 1];
	}

	// 글라이더 선택 메서드
	private static GliderDTO selectGlider() {
		System.out.println("\n글라이더를 선택하세요.");
		for (int i = 0; i < gliderDTOs.length; i++) {
			if (gliderDTOs[i] != null) {
				System.out.print((i + 1) + ". ");
				gliderDTOs[i].display();
			}
		}
		System.out.print("번호 입력 >>> ");
		int sel = input.nextInt();
		input.nextLine();

		// 잘못된 선택시 기본 글라이더 반환
		if (sel < 1 || sel > gliderDTOs.length || gliderDTOs[sel - 1] == null) {
			System.out.println("잘못된 선택입니다. 기본 글라이더(스카이글라이더)를 선택합니다.");
			return gliderDTOs[0];
		}
		return gliderDTOs[sel - 1];
	}

	// 타이어 선택 메서드
	private static TireDTO selectTire() {
		System.out.println("\n타이어를 선택하세요.");
		for (int i = 0; i < tireDTOs.length; i++) {
			if (tireDTOs[i] != null) {
				System.out.print((i + 1) + ". ");
				tireDTOs[i].display();
			}
		}
		System.out.print("번호 입력 >>> ");
		int sel = input.nextInt();
		input.nextLine();

		// 잘못된 선택시 기본 타이어 반환
		if (sel < 1 || sel > tireDTOs.length || tireDTOs[sel - 1] == null) {
			System.out.println("잘못된 선택입니다. 기본 타이어(스포츠타이어)를 선택합니다.");
			return tireDTOs[0];
		}
		return tireDTOs[sel - 1];
	}

	// 랜덤 아이템 선택 메서드
	private static ItemDTO getRandomItem() {
		Random rnd = new Random();
		ItemDTO item;
		do {
			int idx = rnd.nextInt(itemDTOs.length);
			item = itemDTOs[idx];
		} while (item == null); // null이 아닌 아이템을 얻을 때까지 반복
		return item;
	}
}
