package ch01;

import java.util.Scanner;

public class PometExam {

	public static void main(String[] args) {
		// printf ��� ���� �ǽ�
		
		int i = 97 ;
		String s = "java" ;
		double f = 3.14f ;
		System.out.printf("%d\n", i); //97(10����)
		System.out.printf("%o\n", i); //141(8����)
		System.out.printf("%x\n", i); //61(16����)
		System.out.printf("%c\n", i); //a(char)
		System.out.printf("%5d\n", i); //_ _ _97(���� ���� 5ĭ�� 97�� ���� 10����)
		System.out.printf("%05d\n", i); //(����0���� ä��� 5ĭ�� 97�� ���� 10����)
		System.out.printf("%s\n", s); //���ڿ� java ���
		System.out.printf("%5s\n", s); //5ĭ�� ������ java���
		System.out.printf("%-5s\n", s); //-�� ��������
		System.out.printf("%f\n", f); 
		System.out.printf("%e\n", f);
		System.out.printf("%4.1f\n", f);
		System.out.printf("%04.1f\n", f);
		System.out.printf("%-4.1f\n", f);
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("=============");
		System.out.print("�̸� : ");
		String name = input.next() ; //���ڿ� �Է¿�
		
		System.out.print("���� : ");
		int age = input.nextInt() ; // ���� �Է¿�
		
		System.out.print("��� : ");
		double ave = input.nextDouble() ; // �Ǽ� �Է¿�
		
		System.out.printf("���� ����� �̸��� %s\n ����� ���̴� %d\n ����� %5.2f\n �Դϴ�.",name,age,ave);
	}

}
