package ch01;

import java.util.Scanner;

public class SamHangExam1 {

	public static void main(String[] args) {
		// ���׿����ڸ� �̿��� Ȧ¦ ���
		Scanner in = new Scanner(System.in) ;
		
		System.out.print("������ �Է��ϼ��� : ");
		int num = in.nextInt() ;
		System.out.println(num % 2 == 0 ? "¦��" : "Ȧ�� ");
	}

}
