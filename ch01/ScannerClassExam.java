package ch01;

import java.util.Scanner;

public class ScannerClassExam {

	public static void main(String[] args) {
		// Scanner Ŭ����
		
		//  Scanner in = new Scanner(System.in) ;
		  
		 // String strval1 = in.nextLine() ; // ���α� ��� strval1 
		 // String strval2 = in.nextLine() ; // ���� ��ü�� �־ 
		 // String strval3 = new String(in.nextLine()) ;  //���ο� ��ü�� ����
		
		  
		Scanner in = new Scanner (System.in) ;
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = in.nextLine() ;
		System.out.print("���̸� �Է��ϼ��� : ");
		String age = in.nextLine() ;
		System.out.print("�̸����� �Է��ϼ��� : ");
		String email = in.nextLine() ;
		
		System.out.println(name + "�� ��ŷ ���ϽŰ��� ���ϵ帳�ϴ�. ������");
		System.out.println("����� ���̰� " + age + "�̱���");
		System.out.println(email + "�ּ� �� ����ϰڽ��ϴ�. �����մϴ� . ");
		
		
	}

}
