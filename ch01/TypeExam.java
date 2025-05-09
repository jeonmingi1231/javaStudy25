package ch01;

public class TypeExam {

	public static void main(String[] args) {
		
		byte bytevalue = 10 ;
		int intvalue = bytevalue ; //자동타입변환
		System.out.println(intvalue); //10이 출력
		//byte bytevalue1= intvalue ; 큰타입에서 작은 타입은 오류
		
		char charvalue = '가' ;
		intvalue = charvalue ;
		System.out.println("가의 유니코드 값 = " + intvalue);
		
		intvalue = 500 ;
		long longvalue = intvalue ; //int(4)를 큰타입인 long(8)로 변환
		System.out.println(longvalue);
		
		intvalue = 200 ;
		double doublevalue = intvalue ;
		System.out.println(doublevalue);
		
		

	}

}
