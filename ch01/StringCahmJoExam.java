package ch01;

public class StringCahmJoExam {

	public static void main(String[] args) {
		// String참조 타입 비교(문자열)
		String strval1 = "전민기" ;
		String strval2 = "전민기" ;
		String strval3 = new String("전민기") ;
				
		System.out.println(strval1 == strval2) ;		
		System.out.println(strval1 == strval3) ;
		System.out.println("~~~~~~~~~~~~~~~~~~~") ;
		System.out.println(strval1.equals(strval2));
		System.out.println(strval1.equals(strval3));
		
	}

}
