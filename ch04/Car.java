package ch04;

import java.util.Scanner;

public class Car {
	// 필드 (객체가 가지고 있어야 하는 값) -> 글로벌 변수(GV)
	// 고유 데이터
	public String company; // 제작 회사(현대,기아,KGM,쉐보레,아우디)
	public String model; // 아반떼,그렌져,쏘나타
	public String color; // 빨강, 은색, 검정색, 흰색
	int maxSpeed; // 최고속도
	int maxOil;
	public String oilType; // 경유,휘발유
	// 상태값(변동가능)
	public int speed;
	public int rpm;
	public int oil;
	// 부품 -> 다른 클래스를 생성하여 연결한다.
//public Body body;
//public Engine engine;
//public Tire tire;

	// 부품에 필드 사용법
	// Car myCar = new Car(); -> 객체 생성(인스턴스)
	// myCay.maxSpeed = 300; -> 객체 있는 maxspeed에 300 정수를 넣는다.
	// -------------------------------------------------------------

	// 기본생성자:생략가능 (객체가 생성할 때 사용되는 메서드 : 클래스명과 같은 이름)
	public Car() {
		speed = 0;
		rpm = 50;
		oil = 100;
		maxSpeed = 300; // 필드 maxSpeed 사용!
		maxOil = 200;
	} // 객체가 생성되면서 변수에 값이 저장됨.

	// 사용자지정 생성자-> 개발자가 응용하는 기법.
	// 사용자지정 생성자 가 만들어지면, 기본생성자는 자동으로 생성되지 않는다.
	public Car(String company, String model, String color) {
		this.company = company;
		this.model = model;
		this.color = color;
	} // Car muCar = new car("벤츠","이클레스","빨강");

	// 메서드 (객체가 수행해야 되는 동작)
	// C(시동) R(차량상태,주행상태) U(가속,감속,주차) D(시동종료)
	public void start() { // 이라는 메서드 생성
		System.out.println(this.model + "가(이) 주행을 시작합니다.");
		System.out.println("현재 속도 : " + this.speed);
		System.out.println("현재 rpm : " + this.rpm);
		System.out.println("현재 주유량 : " + this.oil);
	}

	public void running() {
		Scanner input = new Scanner(System.in);
		boolean running = true;
		final int MINSPEED = 0; // 최저속도 상수

		System.out.println("주행을 시작합니다.");
		System.out.println("==================");
		while (running) {
			if (this.oil <= 0) {
				System.out.println("⚠️ 주유량이 부족하여 더 이상 주행할 수 없습니다.");
				stop(); // 기름이 0 이 되면 시동이 꺼지게 만듬.
				break; // 기름량에 따라 주행 가능여부 확인
			}
			System.out.println("======주행 메뉴======");
			System.out.println("1. 속도 증가");
			System.out.println("2. 속도 감소");
			System.out.println("9. 뒤로가기");
			System.out.print(">>>");
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("속도 증가를 시작합니다.");

				this.speed += 30;

				if (this.speed >= this.maxSpeed) {
					this.speed = this.maxSpeed;

				} // 300이상 출력 안됨.
				this.oil -= 5; // 기름 5씩 감소
				if (this.oil <= 10) {
					System.out.println("⚠️ 기름이 거의 없습니다! (현재 잔량: " + this.oil + ")");
				}
				System.out.println("현재 속도 : " + this.speed + "km/h");
				System.out.println("남은 기름 : " + this.oil);
				break;
			case 2:
				System.out.println("속도 감소를 시작합니다.");
				this.speed -= 10;
				if (this.speed <= MINSPEED) {
					this.speed = MINSPEED;
				}
				System.out.println("현재 속도 : " + this.speed + "km/h");
				break;
			case 9:
				running = false; // false를 걸어서 다시 유저모드로 반복하게 만든다.
				break;

			default:
				System.out.println("잘못된 선택입니다.");

			}// 스위치문종료

		} // 와일문 종료

	}// running메서드 종료

	public void stop() {
		this.speed = 0;
		this.rpm = 0;
		System.out.println("운전을 완전히 중지합니다.");
		System.out.println("현재 속도: " + this.speed);
		System.out.println("현재 RPM: " + this.rpm);

	}// stop메서드 종료

	public void plusoil() {
		Scanner inputInt = new Scanner(System.in);
		boolean oilmenu = true;
		maxOil = 200;
		while (oilmenu) {
			System.out.println("===========================");
			System.out.println("1.oil 잔량 확인하기.");
			System.out.println("2.oil 주유 하기");
			System.out.println("9. 뒤로가기");
			int select = inputInt.nextInt();
			switch (select) {
			case 1:
				System.out.println("현재 oil의 양은 : " + this.oil + "입니다.");
				System.out.println("최대 maxOil : " + this.maxOil + "입니다.");
				if (this.oil >= this.maxOil) {
					System.out.println("최대 max oil입니다. 더이상 주유할수 없습니다.");
				}
				break;
			case 2:
				System.out.println("차량의 Oil 의 종류가 무엇입니까?");
				System.out.println("1.경유");
				System.out.println("2.휘발유");
				System.out.print(">>>");
				int oilselect = inputInt.nextInt();
				int pricePerLiter = 0;
				switch (oilselect) {
                case 1:
                    pricePerLiter = 1500;
                    break;
                case 2:
                    pricePerLiter = 1600;
                    break;
                default:
                    System.out.println("올바르지 않은 기름 종류입니다.");
                    continue;  // 잘못된 기름종류면 다시 메뉴로
            }
            if (this.oil >= this.maxOil) {
                System.out.println("⚠️ 이미 최대 주유량입니다. 주유할 수 없습니다.");
                break;
            }
            System.out.println((oilselect == 1 ? "경유" : "휘발유") + "의 1L당 가격은 : " + pricePerLiter + "원");
            System.out.println("얼마나 주유 하시겠습니까?(단위 :L)");
            int addOil = inputInt.nextInt();
            if (this.oil + addOil > this.maxOil) {
                System.out.println("주유량이 초과됩니다! 현재 주유 가능량: " + (this.maxOil - this.oil) + "L");
            } else {
                this.oil += addOil;
                int totalPrice = pricePerLiter * addOil;
                System.out.println("주유 완료! 현재 기름: " + this.oil + "L");
                System.out.println("총 결제 금액은 " + totalPrice + "원 입니다.");
                System.out.print("결제 하시겠습니까? (1: 예, 2: 아니오) >>> ");
                int payConfirm = inputInt.nextInt();
                if (payConfirm == 1) {
                    System.out.println("결제가 완료되었습니다. 감사합니다!");
                } else {
                    this.oil -= addOil;  // 주유 취소
                    System.out.println("결제가 취소되었습니다. 주유가 취소되었습니다.");
                    System.out.println("현재 기름량: " + this.oil + "L");
                }
            }
            break;
        case 9:
            oilmenu = false; // 메뉴 종료
            break;
        default:
            System.out.println("올바르지않는 번호입니다.");
            System.out.println("프로그램을 종료합니다.");
            oilmenu = false; // 메뉴 종료
            break;
    } // switch 종료
} // while 종료
}// plusoil 종료
}// 클래스 종료