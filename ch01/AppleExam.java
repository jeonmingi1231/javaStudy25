package ch01;

public class AppleExam {

	public static void main(String[] args) {
		// ��� ���� ���
		
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
	
		System.out.println("��� �Ѱ�����");
		System.out.println("0.7������ ����");
		System.out.println(result + "������ ���´�.");
	}

}
