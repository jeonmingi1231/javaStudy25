package ch02;

public class ContinueExam {

	public static void main(String[] args) {
		// 반복문은 for, while, do-while문에서만 사용되는 되는데, 
		// 블록 내부에서 continue문이 실행되면 for문의 증감식 또는 while문의 조건식으로 이동한다.
		// coutinue문은 반복문을 종료하지 않고, 계속 반복을 수행 한다는 점은 break문과 다르다.
		
			for(int i = 1 ; i <= 10 ; i ++) { //i가 1~10까지 1씩 증가
				if(i%2 != 0) { //짝수가 아님
					continue ;
				}
					System.out.println(i);
	}

}

}