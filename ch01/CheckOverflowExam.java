package ch01;

public class CheckOverflowExam {

	public static void main(String[] args) {
		// ����������� �����÷ο� Ž�� MAX,MIN_VALUE �ڵ带 Ȱ���Ͽ� �����غ���.

		try {  //����ó���ϴ� ��
			int result = safeAdd(2000000000, 2000000000) ;
			System.out.println(result);
		} catch(ArithmeticException e) {
			System.out.println("�����÷ο�߻� : ��� �� �� ����.");
		}
}
public static int safeAdd(int left, int right) {
	if(right>0) {
		if(left>(Integer.MAX_VALUE - right)) {
			throw new ArithmeticException("�����÷ο�߻�");
		}
	}else {
		if(left<(Integer.MIN_VALUE - right)) {
			throw new ArithmeticException("�����÷ο�߻�");
		}
	}
	return left + right ;
}			
		
		}



