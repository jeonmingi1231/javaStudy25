package ch01;

public class AppleExam {

	public static void main(String[] args) {
		// 사과 갯수 계산
		
		/*
		 * int apple = 1 ; double pieceunit = 0.1 ; int number = 7 ;
		 * 
		 * double result = apple - number*pieceunit ;
		 * System.out.println(number*pieceunit);
		 */
		
		int apple = 1 ;
		//double pieceunit = 0,1 ;
		int totalpieces = apple * 10 ;
		int number = 7 ;
		int temp = totalpieces - number ;
		
		//double result = apple = number*pieceunit ;
		double result = temp / 10.0 ;
		//System.out.println(number*pieceunit);
	
		System.out.println("사과 한개에서");
		System.out.println("0.7조각을 빼면");
		System.out.println(result + "조각이 남는다.");
	}

}
