package ch03;

import java.util.Scanner;

public class JaphanGiExam {

	public static void main(String[] args) {
		// 관리자모드(메뉴변경,가격변경,음료리필,통계(이윤계산)
		// 사용자모드(음료의 재고관리,사용자 요금관리,관리자호출)

		Scanner inputStr = new Scanner(System.in); // 스캐너 객체 만들기.
		Scanner inputInt = new Scanner(System.in); // 스캐너 객체 만들기.

		String[] drinks = { "콜라", "사이다", "환타", null, null }; // 음료 이름 배열 만들기.
		int[] price = { 1500, 1400, 1300, 0, 0 };// 음료 가격 배열 만들기
		int[] stock = { 10, 10, 10, 0, 0 };// 음료 재고 배열 만들기
		int[] sold = { 0, 0, 0, 0, 0 }; // 음료 판매량 추적 배열 만들기
		int[] profit = new int[1]; // 전체 판매 이윤계산하는 변수

		
		
		// 회원 정보
		String[][] members = new String[10][2]; // [10]명의 회원의 [id, pw] 를 받는다.
		 int[] memberCountRef = {0} ;
		memberCountRef[0] = 0;
		String[][][] purchaseHistory = new String[10][50][2]; // [회원][구매][음료명, 수량]
		int[] purchaseCount = new int[10];

		boolean run = true; // true일때 계속 돌게하는 블리언 런 트루를 만든다.

		while (run) { // while문 시작 run으로 계속 돌게한다.
			System.out.println("=====음료 자판기를 실행합니다=====");
			System.out.println("원하시는 모드를 눌러주세요.");
			System.out.println("1.관리자모드");
			System.out.println("2.사용자모드");
			System.out.println("3.종료");
			System.out.print(">>>");
			int choice = inputInt.nextInt(); // 숫자 입력받을 객체 만들어준다.

			switch (choice) { // 위에 sysout 선택 번호창을 스위치로 만들어준다.
			case 1:
				adminMode(drinks, price, stock, sold, profit); // adminMode 라는 메서드를 만들어서 case1 의 가독성을 좋게 만들어준다.
				// (drinks, price, stock, sold, profit) 메인메서드의 이 항목들을 불러옴.
				break;
			case 2:
				// 사용자 모드 기능 추가 가능
				 userMod(drinks, price, stock, sold, profit, members, memberCountRef, purchaseHistory, purchaseCount);
				    break;// userMod 라는 메서드를 만들어서 case2 의 가독성을 좋게 만들어준다.
				// (drinks, price, stock, sold, profit) 메인메서드의 이 항목들을 불러옴.
			
			case 3:
				run = false; // 3번을 누르면 true가 false로 되어 실행을 멈추게 만든다.
				break;
			default: // 다른 키를 눌렀을때의 출력값.
				System.out.println("잘못된 선택입니다.");

			}// switch문 종료 

		} // while문 종료

	} // 메인메서드 종료

	private static void userMod(String[] drinks, int[] price, int[] stock, int[] sold, int[] profit, String[][] members,
			int[] memberCountRef, String[][][] purchaseHistory, int[] purchaseCount) {
		// (userMod)사용자 모드 만들기
		Scanner inputStr = new Scanner(System.in); // 키보드로 입력받을 객체 만들기
		Scanner inputInt = new Scanner(System.in); // 키보드로 입력받을 객체 만들기
		
		int currentMemberIndex = -1;
		
		 while (true) {
		        System.out.println("1. 로그인");
		        System.out.println("2. 회원가입");
		        System.out.println("3. 비회원 모드로 시작");
		        System.out.print(">>> ");
		        int loginChoice = inputInt.nextInt();
		        inputInt.nextLine(); // 버퍼 비우기

		        if (loginChoice == 1) {
		            System.out.print("아이디 입력: ");
		            String id = inputStr.nextLine();
		            System.out.print("비밀번호 입력: ");
		            String pw = inputStr.nextLine();

		            for (int i = 0; i < memberCountRef[0]; i++) {
		                if (members[i][0].equals(id) && members[i][1].equals(pw)) {
		                    currentMemberIndex = i;
		                    System.out.println("로그인 성공!");
		                    break;
		                }
		            }

		            if (currentMemberIndex == -1) {
		                System.out.println("로그인 실패. 다시 시도하세요.");
		                continue;
		            } else break;

		        } else if (loginChoice == 2) {
		            if (memberCountRef[0] >= 10) {
		                System.out.println("회원 정원이 가득 찼습니다.");
		                break;
		            }

		            System.out.print("새 아이디: ");
		            String newId = inputStr.nextLine();
		            System.out.print("새 비밀번호: ");
		            String newPw = inputStr.nextLine();

		            members[memberCountRef[0]][0] = newId;
		            members[memberCountRef[0]][1] = newPw;
		            System.out.println("회원가입 완료. 로그인 후 이용하세요.");
		            memberCountRef[0]++;
		        } else if (loginChoice == 3) {
		            System.out.println("비회원 모드로 시작합니다.");
		            break;
		        } else {
		            System.out.println("잘못된 입력입니다.");
		        }
		    }

		    boolean userModerun = true; // 트루일때 계속 돌게하는 블리언 유저모드런을 만든다.

	

		while (userModerun) {
			System.out.println("--- 사용자 모드 ---");
			System.out.println("0. 음료 인기 순위 보기");
			System.out.println("1. 음료 구매");
			System.out.println("2. 음료 재고 확인");
			System.out.println("3. 사용자 요금 관리");
			System.out.println("4. 관리자 호출");
			System.out.println("5. 구매 이력 보기");
			System.out.println("9. 뒤로가기");
			System.out.print(">>> ");
			int userChoice = inputInt.nextInt(); // 키보드로 입력받을 정수값 객체

			switch (userChoice) { // 위의 sysout의 선택번호를 switch로 만듬.
			case 0:
				System.out.println("=== 인기 음료 순위 ===");
				// 판매량에 따라 정렬할 인덱스를 담을 배열
				int[] rank = new int[sold.length];
				for (int i = 0; i < rank.length; i++) {
					rank[i] = i; // 인덱스 초기화
				}
				// 판매량 sold[] 를 기준으로 인덱스들을 정렬(버블 정렬)
				for (int i = 0; i < rank.length - 1; i++) {
					for (int j = i + 1; j < rank.length; j++) {
						if (sold[rank[j]] > sold[rank[i]]) {
							int temp = rank[i];
							rank[i] = rank[j];
							rank[j] = temp;
						}
					}
				}
				// 정리한 인덱스로 순위 출력
				for (int ranking = 0; ranking < rank.length; ranking++) {
					int idx = rank[ranking];
					if (drinks[idx] != null && sold[idx] > 0) {
						System.out.println((ranking + 1) + "위: " + drinks[idx] + "= 판매량 -> " + sold[idx] + "개");
					}
				}
				break;

			case 1: // 1번인 음료구매 항목을 만들기위한 case1.
				System.out.println("구매할 음료를 선택하세요.");
				for (int i = 0; i < drinks.length; i++)
					if (drinks[i] != null) { // 배열식 쓸때 공식처럼 외우기.
						System.out.println(
								(i + 1) + ". " + drinks[i] + " - 가격: " + price[i] + "원 (재고: " + stock[i] + ")");
					} // (i + 1) 에 +1 을 쓰는 이유는 i는 [0][1][2]이렇게 뜨기때문에 0말고 1부터 표시하기 위해.
				System.out.print("선택(1~5): ");
				int drinkChoice = inputInt.nextInt() - 1; // 내가 입력하는값은 정수 1,2,3이지만 배열은 0,1,2로 뜨기 떄문에. -1
				if (drinkChoice >= 0 && drinkChoice < drinks.length && drinks[drinkChoice] != null) { // 1~5번이
																										// 아닌다른번호를입력했을지
																										// 확인용.
					System.out.print("몇 개 구매하시겠습니까? : ");
					int howMany = inputInt.nextInt();
					if (howMany <= 0) {
						System.out.println("올바른 수량을 입력하세요.");
						break;
					}

					if (stock[drinkChoice] >= howMany) { // 구매전 재고가 있나 확인하는 코드 (재고가 0개 이상일때 구매가능)
						// 수정: 현금 삽입
						int totalPrice = price[drinkChoice] * howMany;
						System.out.println("====================");
						System.out.print("총 금액은 " + totalPrice + "원 입니다. 현금을 넣어주세요: ");
						int insertedMoney = inputInt.nextInt(); // 사용자가 넣은 금액
						// 수정: 거스름돈 계산
						if (insertedMoney >= totalPrice) {
							int change = insertedMoney - totalPrice; // 거스름돈 계산
							stock[drinkChoice] -= howMany; // 재고차감
							sold[drinkChoice] += howMany; // 판매량차감
							profit[0] += totalPrice; // 이윤계산

							System.out.println(drinks[drinkChoice] + "을(를) " + howMany + "개 구매했습니다.");
							System.out.println("거스름돈: " + change + "원");
							
							// --- 회원 구매 이력 기록 추가 시작 ---
			                if (currentMemberIndex != -1) {  // 로그인 회원일 때만 기록
			                    int idx = purchaseCount[currentMemberIndex];  // 현재 회원 구매 횟수 인덱스
			                    if (idx < purchaseHistory[currentMemberIndex].length) {
			                        purchaseHistory[currentMemberIndex][idx][0] = drinks[drinkChoice];  // 음료명 저장
			                        purchaseHistory[currentMemberIndex][idx][1] = String.valueOf(howMany); // 구매 수량 저장
			                        purchaseCount[currentMemberIndex]++;  // 구매 횟수 증가
			                    } else {
			                        System.out.println("구매 이력 저장 공간이 부족합니다.");
			                    }
			                }

						} else {
							System.out.println("입력하신 금액이 부족합니다."); // 넣은 금액이 안맞을때 뜨는 출력값
							// continue ;//다시입력하게 만든다
						}
					} else {
						System.out.println("재고가 부족합니다."); // 남은재고가 없을때 뜨는 출력값
					}
				} else {
					System.out.println("잘못된 선택입니다.");// 잘못 눌렀을떄 뜨는 출력값
				}
				break;
			case 2:
				// 음료 재고 확인
				System.out.println("===== 재고 현황 =====");
				for (int i = 0; i < drinks.length; i++) { // 배열 공식
					System.out.println(drinks[i] + " 재고: " + stock[i]); // 같은 배열이 출력되니까 drinks[i]stock[i] 로 이 음료는 이만큼의
																		// 재고가 남았다 표시 가능
				}
				break;
			case 3:
				// 사용자 요금 관리
				System.out.println("현재 총 이윤: " + profit+ "원"); // 현재까지의 이윤을 출력한다.
				break;
			case 4:
				// 관리자 호출
				System.out.println("관리자 호출을 위해 관리자 모드로 전환합니다."); // 관리자호출 메서드로 넘어감
				adminMode(drinks, price, stock, sold, profit);
				break;
			case 5:
	            if (currentMemberIndex == -1) {
	                System.out.println("비회원 모드에서는 구매 이력을 확인할 수 없습니다.");
	            } else {
	                System.out.println("=== 구매 이력 ===");
	                int count = purchaseCount[currentMemberIndex];
	                if (count == 0) {
	                    System.out.println("구매 이력이 없습니다.");
	                } else {
	                    for (int i = 0; i < count; i++) {
	                        String drinkName = purchaseHistory[currentMemberIndex][i][0];
	                        String quantity = purchaseHistory[currentMemberIndex][i][1];
	                        System.out.println((i + 1) + ". " + drinkName + " - 수량: " + quantity + "개");
	                    }
	                    
	                }
	            }
	            break;
			case 9:
				userModerun = false; // false를 걸어서 다시 유저모드로 반복하게 만든다.
				break;
			default:
				System.out.println("잘못된 선택입니다."); // 잘못 눌렀을때의 출력값 표시.
			}

		}
	}

	private static void adminMode(String[] drinks, int[] price, int[] stock, int[] sold, int[] profit) {
		// 관리자모드 만들기
		Scanner inputStr = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);

		// 로그인 기능 추가
		String adminUsername = "qwer"; // 아이디
		String adminPassword = "1234"; // 비밀번호
		boolean isLoggedIn = false;
		boolean logincancel = false; // 로그인 캔슬 블리언 만들어서 캔슬키 입력하면 false 로 바뀌면서 로그인창 끄기
		// 관리자 로그인 시도
		while (!isLoggedIn && !logincancel) {
			System.out.print("관리자 아이디를 입력하세요: "); // ID 입력칸 만들기. (뒤로가려면 0입력 : )
			String username = inputStr.nextLine(); // Str값을 키보드로 입력받음.

			if (username.equals("0")) { // 0이라는 캔슬 키 생성
				logincancel = true;
				break;
			}
			System.out.print("비밀번호를 입력하세요: "); // Pw 입력칸 만들기.
			String password = inputStr.nextLine(); // Str값을 키보드로 입력받음.

			if (password.equals("0")) { // 0이라는 캔슬 키 생성
				logincancel = true;
				break;
			}

			if (username.equals(adminUsername) && password.equals(adminPassword)) { // equalsigonercase안쓰는 이유는 로그인은
																					// 대소문자가 구별이 되어야해서.
				isLoggedIn = true;
				System.out.println("로그인 성공!");
				System.out.println("==================");
			} else {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다. 다시 시도해주세요."); // 틀렸을때 뜨는 출력값.
			}

		}
		if (logincancel) {
			System.out.println("로그인 취소, 이전 메뉴로 들어갑니다.");
			return;
		}
		boolean adminModerun = true;
		while (adminModerun) {
			System.out.println("--- 관리자 모드 ---");
			System.out.println("1. 메뉴 변경");
			System.out.println("2. 가격 변경");
			System.out.println("3. 음료 리필");
			System.out.println("4. 통계 보기");
			System.out.println("5. 음료 추가");
			System.out.println("6. 음료 삭제");
			System.out.println("9. 뒤로 가기");
			System.out.print(">>> ");
			int adminChoice = inputInt.nextInt();

			switch (adminChoice) {
			case 1: // 메뉴변경 모드
				for (int i = 0; i < drinks.length; i++) {
					System.out.print(drinks[i] + " → 새 이름 입력: ");
					drinks[i] = inputStr.next(); // Str값으로 새로운 메뉴 이름으로 수정함.
				}
				break;
			case 2:
				for (int i = 0; i < price.length; i++) {
					System.out.print(drinks[i] + "의 새로운 가격 입력: ");
					price[i] = inputInt.nextInt(); // 새로운 가격을 Int값으로 수정함.
				}
				break;
			case 3:
				for (int i = 0; i < stock.length; i++) {
					System.out.print(drinks[i] + " 리필 수량 입력: ");
					stock[i] += inputInt.nextInt(); // 리필할 수량을 Int값으로 수정함.
				}
				break;
			case 4:
				System.out.println("===== 판매 통계 =====");
				for (int i = 0; i < sold.length; i++) { // 배열 공식
					System.out.println(drinks[i] + " 판매량: " + sold[i]); // 음료 배열에 있는 판매량을 나타냄 같은[i]값이 출력됨.
				}
				System.out.println("총 이윤: " + profit[0]+"원");
				break;
			case 5:
				System.out.print("추가할 음료 이름: ");
				String newDrink = inputStr.next();
				System.out.print(newDrink + "의 가격을 입력하세요: ");
				int newPrice = inputInt.nextInt();
				System.out.print(newDrink + "의 초기 재고 수량을 입력하세요: ");
				int newStock = inputInt.nextInt();

				boolean added = false;
				for (int i = 0; i < drinks.length; i++) {
					if (drinks[i] == null || drinks[i].equals("null")) { // 빈 자리 발견
						drinks[i] = newDrink;
						price[i] = newPrice;
						stock[i] = newStock;
						sold[i] = 0;
						added = true;
						System.out.println("음료가 추가되었습니다!");
						break;
					}
				}

				if (!added) {
					System.out.println("더 이상 음료를 추가할 공간이 없습니다.");

				}

				break;
			case 6:
				System.out.println("삭제할 음료를 선택하세요.");
				for (int i = 0; i < drinks.length; i++) {
					if (drinks[i] != null)
						System.out.println((i + 1) + ". " + drinks[i]);
				}
				System.out.print("번호 입력: ");
				int delNum = inputInt.nextInt() - 1;
				if (delNum >= 0 && delNum < drinks.length && drinks[delNum] != null) {
					drinks[delNum] = null;
					price[delNum] = 0;
					stock[delNum] = 0;
					System.out.println("음료가 삭제되었습니다.");
				} else {
					System.out.println("잘못된 선택입니다.");
				}
				break;
			case 9:
				adminModerun = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");

			}// 스위치문 종료

		} // while문 종료

	} // 관리자 모드 메서드 종료

}
// 클래스 종료
