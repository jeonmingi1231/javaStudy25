package ch01;

public class NonRiHhapExam {

	public static void main(String[] args) {
		// ���� �׽�Ʈ
		
		int value = 12;
		if( (value%2==0) || (value%3==0 )) {
			System.out.println("2 �Ǵ� 3�� ��� �Դϴ� " + value);
			
		}
		if((value%2==0) && (value%3==0)) {
			System.out.println("2��� �̰� 3�� ��� �Դϴ�. " + value);
		}
	}

}
