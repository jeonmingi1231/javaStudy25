package ch01;

public class TypeExam {

	public static void main(String[] args) {
		
		byte bytevalue = 10 ;
		int intvalue = bytevalue ; //�ڵ�Ÿ�Ժ�ȯ
		System.out.println(intvalue); //10�� ���
		//byte bytevalue1= intvalue ; ūŸ�Կ��� ���� Ÿ���� ����
		
		char charvalue = '��' ;
		intvalue = charvalue ;
		System.out.println("���� �����ڵ� �� = " + intvalue);
		
		intvalue = 500 ;
		long longvalue = intvalue ; //int(4)�� ūŸ���� long(8)�� ��ȯ
		System.out.println(longvalue);
		
		intvalue = 200 ;
		double doublevalue = intvalue ;
		System.out.println(doublevalue);
		
		

	}

}
