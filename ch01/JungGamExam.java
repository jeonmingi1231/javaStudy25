package ch01;

public class JungGamExam {

	public static void main(String[] args) {
		// �ٸ������ڿ��� ����������
		int x = 10 ;
		x++ ; // x = x + 1 -> 11
		++x ; // x = x + 1 -> 12
		System.out.println("x = " + x ); //12
		
		int y = 10 ;
		y-- ; // y = y - 1 > 9
 		--y ; // y = y - 1 > 8
		System.out.println("y = " + y); // 8
		
		
		int z = x++ ; // x���� z�� �ְ� x�� 1���� ��Ų��
		System.out.println("z = " + z ); // 12
		System.out.println("x = " + x); // 13
		
		z = ++x ;
		System.out.println("z = " + z); //14 
		System.out.println("x = " + x); //14
		
		z = ++x + y++ ; // (z = (++14) + 8)++
		System.out.println("z = " + z); //23 = z = ++14 + 8
		System.out.println("x = " + x); //15 = ++15
		System.out.println(" y = " + y); //9 = 8++

	}

}
