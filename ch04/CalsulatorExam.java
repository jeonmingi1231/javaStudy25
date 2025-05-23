package ch04;

import java.util.Scanner;

import javax.security.sasl.SaslClient;

public class CalsulatorExam {

	public static void main(String[] args) {
		// 계산기 실행용
		
		Calculator myCalc = new Calculator();
		
		int resulrt1 = myCalc.plus(10,20);
		System.out.println("10 + 20 = " + resulrt1);
		int x = 40;
		int y = 20;
		int resulrt2= myCalc.minus(x, y);
		System.out.println(x + " - " + y + " = " + resulrt2);
		 
		//키보드로 숫자를 입력 받아 곱하기를 진행해보세요
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int result3 = myCalc.time(a,b);
		System.out.println(a + " x " + b + " = " + result3);
		
		myCalc.powerOff();

	}

}
