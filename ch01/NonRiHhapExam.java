package ch01;

public class NonRiHhapExam {

	public static void main(String[] args) {
		// 논리합 테스트
		
		int value = 12;
		if( (value%2==0) || (value%3==0 )) {
			System.out.println("2 또는 3의 배수 입니다 " + value);
			
		}
		if((value%2==0) && (value%3==0)) {
			System.out.println("2배수 이고 3의 배수 입니다. " + value);
		}
	}

}
