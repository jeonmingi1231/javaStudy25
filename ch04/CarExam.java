package ch04;

import java.util.Scanner;

public class CarExam {

	public static void main(String[] args) {
		// 자동차 주 실행 프로그램
		Scanner input = new Scanner(System.in);
		boolean run = true;
		
		System.out.println("===차량정보 입력===");
		Car myCar = new Car(); // 기본생성자로 객체 생성
		// 생성시 speed(속도), rpm, oil량은 기본값으로 생성
		System.out.print("제조회사 : ");
		myCar.company = input.next();

		System.out.print("모델 : ");
		myCar.model = input.next();

		System.out.print("색상 : ");
		myCar.color = input.next();

		while (run) {
			System.out.println("1. 차량 정보확인");
			System.out.println("2. 차량 시동걸기");
			System.out.println("3. 차량 주행시작");
			System.out.println("4. 차량 주행종료");
			System.out.println("5. 차량 oil메뉴");
			System.out.print(">>>");
			String select = input.next();
			switch (select) {
			case "1":
				System.out.println("차량 명 : " + myCar.company);
				System.out.println("모델 명 : " + myCar.model);
				System.out.println("색상 : " + myCar.color);
				break;
			case "2":
				System.out.println("차량에 시동이 걸렸습니다.");
				myCar.start();
				break;
			case "3":
				System.out.println("차량 주행을 시작합니다.");
				myCar.running();
				break;
			case "4":
				System.out.println("차량 주행을 종료합니다.");
				myCar.stop();
				break;
			case "5" :
				System.out.println("차량 oil메뉴로 진입합니다.");
				myCar.plusoil();
			}// 스위치문 종료

		} // while문 종료

	}// 메인메서드 종료

}// 클레스 종료
