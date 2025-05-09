package ch01;

public class DanHangExam {

	public static void main(String[] args) {
		// 단항 연산자

		int x = -100 ; // 음수에 100을 x에 넣는다
		int result1 = +x ; //음수에 +부호가 붙어서 부호가 유지된다.
		int result2 = -x ; //음수에 -부호가 붙어서 부호가 변견된다.
		
		System.out.println(result1);
		System.out.println(result2);
		
		short s = 100 ;
		//short result3 = -s ; 계산에 기본탑입은 int 이기 때문에 오류
		int result3 = -s ;
		System.out.println(result3);
		
		
		
	}

}
