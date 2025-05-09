package ch01;

public class VarExam {

	public static void main(String[] args) {
		// 변수선언 테스트
		
		int x = 1 ;
		
		char y = 65 ;
				
		char z = 'A' ;
		
		System.out.println("int x = " + x);
		System.out.println("char y = " + y);
		System.out.println("char z = " + z);
		
		char z1 = 'b' ;
		
		int x1 ;
		x1 = 10 ;
		System.out.println(x1);
		
		int kor, mat, eng, total, avg ; 
		
		kor = 90 ;
		mat = 80 ;
		eng = 70 ;
		total = kor + mat+ eng ; // 총점
		avg = total / 3 ; //평균

		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		
		
		
		
		int literal1 = 75 ; // 10진수
		int literal2 = 075 ; // 8진수
		int literal3 = 0b0011 ; // 2진수
		int literal4 = 0xA ; // 16진수
		System.out.println("10진수 75: " + literal1);
		System.out.println("8진수 75 : " + literal2);
		System.out.println("2진수 0011 : " + literal3);
		System.out.println("16진수 A : " + literal4);
		
	}

}
