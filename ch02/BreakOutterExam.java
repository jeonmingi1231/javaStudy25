package ch02;

public class BreakOutterExam {

	public static void main(String[] args) {
		// break Outter라는 라벨을 생성하고 중지하고 싶은 반복문 앞에
		// 라벨을 적으면 break문이 종료되는 시점을 만들 수 있다.

		for (char upper = 'A'; upper <= 'Z'; upper++) { // A~Z까지 반복용 코드
			Outter: for (char lower = 'a'; lower <= 'z'; lower++) { // a~z까지 반복용 코드

				System.out.println(upper + "_" + lower);
				if (lower == 'c') {
					break Outter;

				}

			} // 소문자반복문 종료

		} // 대문자 반복문 종료

	}// 메인메서드 종료

}// 클래스 종료
