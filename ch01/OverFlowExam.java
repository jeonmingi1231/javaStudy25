package ch01;

public class OverFlowExam {

	public static void main(String[] args) {
		// �����÷ο� Ž��
		//int x = 1000000;
		//int y = 1000000;
		//int z = x * y ; // 10000000000000
		//System.out.println(z); //-727379968 (21���� �Ѿ -�� ����)
		long x = 1000000 ;
		long y = 1000000 ;
		long z = x * y ;
		System.out.println(z); //1000000000000 (long���� �ٲ㼭 ����� ��)
		

	}

}
