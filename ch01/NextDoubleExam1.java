package ch01;

import java.util.Scanner;

public class NextDoubleExam1 {

	public static void main(String[] args) {
		// �Ǽ����� �ڷḦ �Է¹޾� ó��
		double w, h, area ;
		Scanner in = new Scanner(System.in) ;
		System.out.println("���簢���� ���� ���̸� �Է��ϼ���!!");
		w = in.nextDouble() ;
		System.out.println("���簢���� ���� ���̸� �Է��ϼ���!!!");
		h = in.nextDouble() ;
		area = w * h ;
		System.out.println("���簢���� ���̴� " + area + "�Դϴ�");

	}

}
