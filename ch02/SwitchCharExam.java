package ch02;

import java.util.Scanner;

public class SwitchCharExam {

	public static void main(String[] args) {
		// ��ҹ����� �Է¿� ���� ��� ���
		// switch���� ����� �����ڷ� ����(char)�� ����� �Ҽ��ִ�.
	 
		Scanner inChar = new Scanner(System.in);
		
		System.out.print("ȸ�� ����� �Է��ϼ��� (A~C) : "); // print(ln)���� ���� �ؿ��ٷ� �Ѿ�ϱ� ln����
		
		//String gradeStr = inChar.next() ; // ���ڿ��� �����͸� �Է¹޾� String �� ����
		//char gradeChr = gradeStr.charAt(0); //���ڿ� 0�� �ε��� ���ڸ� char Ÿ�� ������ ����.
		
		char gradeChaStr = inChar.next().charAt(0); //���ڿ��� ���� ���� ���� ó����.
		System.out.println("�����ڵ��(1��) : " + gradeChaStr) ; 
	 
		switch(gradeChaStr) { 
		
		case 'a' :
		case 'A' :
			System.out.println("���ȸ�� �Դϴ�.");
			break ;
		case 'b' :
		case 'B' :
			System.out.println("�Ϲ�ȸ�� �Դϴ�.");
			break ;
		case 'c' :
		case 'C' :
			System.out.println("�����ȸ�� �Դϴ�.");
			break ;	
		
		default :
			System.out.println("�մ� ó�� �̽ʴϱ�?");
			System.out.println("ȸ�� ���� �Ͻ÷��� Yes �� �Է��� �ּ���.");
			String newMember = inChar.next() ;
			if(newMember.equalsIgnoreCase("yes")) {
				System.out.println("ȸ�������� �����մϴ�.");
				System.out.print("���̵� : ");
				String id = inChar.next() ;
				System.out.println(id + "�� ȸ�������� ���ϵ帳�ϴ�.");
				break ;
			}else {
				System.out.println("�ȳ��� ������ !! ���� ��ȸ�� �˰ڽ��ϴ�.");
				System.out.println("��, �ι� �ٽ� �� �� ���� �ֽ��ϴ�.");
				break ;
			} // ȸ������ if�� ����.
			
		

} //switch �� ����
	
	
	}
	
	
	
}
	