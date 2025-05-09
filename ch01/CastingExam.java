package ch01;

public class CastingExam {

	public static void main(String[] args) {
		
		int intvalue = 100 ;
		byte bytevalue = (byte) intvalue ; //int(4byte) >> byte(1byte)로 강제타입변환
		System.out.println(intvalue);
		System.out.println(bytevalue);
		
		intvalue = 44032 ;
		char charvalue = (char) intvalue ; //int(4byte) >> char(2byte)로 강제타입변환
		System.out.println(charvalue);

		double doublevalue = 3.14 ;
		intvalue =(int) doublevalue ; //double(8byte) >> int(4byte)로 강제타입변환
		System.out.println(intvalue);
		
		int i = 128 ;
		if( (i<Byte.MIN_VALUE) || (i>Byte.MAX_VALUE)) {
			//i의 값이 Byte의 최소값보다 작거나 최대값보다 크면
			System.out.println("byte타입으로 변환할 수 없습니다.");
			System.out.println(Byte.MIN_VALUE + "값보다 작거나");
			System.out.println(Byte.MAX_VALUE + "값보다 큽니다");
		} else {
			byte b = (byte) i ; //int를 byte로 강제타입변환
			System.out.println(b);
		}
		
		
		
	}

}
