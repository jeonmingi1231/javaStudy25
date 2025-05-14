package ch02;

import java.util.Scanner;

public class SwitchStringExam {

	public static void main(String[] args) {
		// 기본타입 값(int, long, char)만 switch문에 사용할 수 있었지만,
		// 현재 버전은 String 타입도 switch문으로 활용할 수 있다.
	

		Scanner in = new Scanner(System.in);

		System.out.print("직급을 입력하시오 : ");

		String position = in.next();

		switch (position) {
		case "부장":
			System.out.println(position + " 성과급은 1000만원");
			break;

		case "과장":
			System.out.println(position + "성과급은 1500만원");
			break;

		case "대리":
			System.out.println(position + "성과급은 2000만원");
			break;
		default:
			System.out.println("성과급 없음.");
		}

	}

}
