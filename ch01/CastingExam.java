package ch01;

public class CastingExam {

	public static void main(String[] args) {
		
		int intvalue = 100 ;
		byte bytevalue = (byte) intvalue ; //int(4byte) >> byte(1byte)�� ����Ÿ�Ժ�ȯ
		System.out.println(intvalue);
		System.out.println(bytevalue);
		
		intvalue = 44032 ;
		char charvalue = (char) intvalue ; //int(4byte) >> char(2byte)�� ����Ÿ�Ժ�ȯ
		System.out.println(charvalue);

		double doublevalue = 3.14 ;
		intvalue =(int) doublevalue ; //double(8byte) >> int(4byte)�� ����Ÿ�Ժ�ȯ
		System.out.println(intvalue);
		
		int i = 128 ;
		if( (i<Byte.MIN_VALUE) || (i>Byte.MAX_VALUE)) {
			//i�� ���� Byte�� �ּҰ����� �۰ų� �ִ밪���� ũ��
			System.out.println("byteŸ������ ��ȯ�� �� �����ϴ�.");
			System.out.println(Byte.MIN_VALUE + "������ �۰ų�");
			System.out.println(Byte.MAX_VALUE + "������ Ů�ϴ�");
		} else {
			byte b = (byte) i ; //int�� byte�� ����Ÿ�Ժ�ȯ
			System.out.println(b);
		}
		
		
		
	}

}
