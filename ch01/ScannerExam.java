package ch01;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		// Sacnner �޼��带 Ȱ���Ͽ� Ű����� �Է� �޴� ���� ó���ϰ� �����Ѵ�.
		
		Scanner in = new Scanner(System.in) ;
		int x = in.nextInt() ;
		int y = in.nextInt() ;
		System.out.printf("%d * %d�� %d �Դϴ�. \n" , x , y, x * y);
		//10 ���� > 20 ���� > sysout �� ����ǰ� ����� �����.
	}

}
