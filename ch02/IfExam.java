package ch02;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		// if(���ǹ�){  ���๮  }
				//    ���ǹ��� true�� ó���Ǹ� �߰�ȣ ������ ����ȴ�.
				//    ���ǹ��� false�� ó���Ǹ� �߰�ȣ ������ ������� �ʴ´�.
				
				Scanner input = new Scanner(System.in);
				// Ű����� �Է� ���� �� �ִ� ��ü�� �������Ͽ� input ������ ����
				
				System.out.println("귀하의 이름을 입력하시오!!!!");
				System.out.print(">>>");
				String name = input.next(); // Ű����� �Է¹��� �̸��� name�� ������ ����.
				
				
				System.out.println("귀하의 점수를 입력하시오!");
				System.out.print(">>>");
				int score = input.nextInt(); // Ű����� �Է¹޴� ������ score�� ����.
				
				if (score > 0 && score <= 100) { // 0���� ũ�ų� 100�����̸� true.
					if (score >= 90) { // score ������ �Էµ� ���� 90 �̻��̳�???
						System.out.println(name +"님 점수가 90점 이상입니다");
						System.out.println("점수 : " + score + " : 등급 (A)");
					} else if (score >= 80) {
						System.out.println(name + "님 점수가 89~80점 입니다");
						System.out.println("점수 : " + score + " : 등급 (B)");
					} else if (score >= 70) {
						System.out.println(name + "님 점수가 79~70점 입니다");
						System.out.println("점수 : " + score + " : 등급 (C)");
					} else if (score >= 60) {
						System.out.println(name + "님 점수가 69~60점 입니다");
						System.out.println("점수 : " + score + " : 등급 (D)");
					} else {
						System.out.println("점수가 60점 미만입니다..");
						System.out.println("점수 : " + score + " : 등급 (F)");
					} // ������ �Է� �Ǿ��� �� ���๮ 
				}else {
					System.out.println(name + "님, 입력값을 확인해 주세요.");
					System.out.println("잘못 입력된 점수는 " + score + "입니다.");
				}
					System.out.println("프로그램을 종료합니다.");
				
				
			}  // main �޼��� ���� -> ������ input, name, score �� �����

		} //class ���� -> �޼��尡 �����. -> ���α׷� ����




		