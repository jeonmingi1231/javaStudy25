package ch04;

public class Calculator { // 계산기 프로그램
	// 계산용 라이브러리
	
	void powerOn() {
		System.out.println("계산기의 전원을 켭니다.");
	}

	int plus(int x, int y) { // 덧셈
		int result = x + y;
		return result;
	}

	int minus(int x, int y) { // 뺄셈
		int result = x - y;
		return result;
	}

	int time(int x, int y) { // 곱셈
		int result = x * y;
		return result;
	}

	double divide(int x, int y) { // 나눗셈
		double result = x / y;
		return result;
	}

	int remainder(int x, int y) { // 나머지
		int result = x % y;
		return result;
	}

	void powerOff() {
		System.out.println("전원을 끕니다");
	}

}