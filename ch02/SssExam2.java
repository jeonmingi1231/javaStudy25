package ch02;

import java.util.Scanner;

public class SssExam2 {

	public static void main(String[] args) {
		// �ֹι�ȣ 8��° ���ڸ� �����Ͽ� ������ �����Ѵ�.
		// .charAt(����) -> ���ڿ��߿� ���ڿ� �ش��ϴ� ���ڸ� �����Ѵ�.
		
		Scanner in = new Scanner(System.in);
		System.out.print("����� �ֹι�ȣ�� �Է��Ͻÿ�. >>");
		String regNo = in.next() ;
		char gender = regNo.charAt(7) ;
		
		System.out.println(gender);
		
		switch(gender) {
		case '1' : case '3' : case '5' : case '7' :
			System.out.println("����� �����Դϴ�.");
			break ;
			
		case '2' : case '4' : case '6' : case '8' :	
			System.out.println("����� �����Դϴ�.");
			break ;
			
		default :
			System.out.println("����� �ܰ����Դϴ�.!!!");
			System.out.println("����� ���� ���ư�����!!!");
		}
	}

}
