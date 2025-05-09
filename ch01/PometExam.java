package ch01;

import java.util.Scanner;

public class PometExam {

	public static void main(String[] args) {
		// printf 출력 포멧 실습
		
		int i = 97 ;
		String s = "java" ;
		double f = 3.14f ;
		System.out.printf("%d\n", i); //97(10진수)
		System.out.printf("%o\n", i); //141(8진수)
		System.out.printf("%x\n", i); //61(16진수)
		System.out.printf("%c\n", i); //a(char)
		System.out.printf("%5d\n", i); //_ _ _97(앞은 공백 5칸에 97을 넣음 10진수)
		System.out.printf("%05d\n", i); //(앞은0으로 채우고 5칸에 97을 넣음 10진수)
		System.out.printf("%s\n", s); //문자열 java 출력
		System.out.printf("%5s\n", s); //5칸을 제공후 java출력
		System.out.printf("%-5s\n", s); //-는 왼쪽정렬
		System.out.printf("%f\n", f); 
		System.out.printf("%e\n", f);
		System.out.printf("%4.1f\n", f);
		System.out.printf("%04.1f\n", f);
		System.out.printf("%-4.1f\n", f);
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("=============");
		System.out.print("이름 : ");
		String name = input.next() ; //문자열 입력용
		
		System.out.print("나이 : ");
		int age = input.nextInt() ; // 정수 입력용
		
		System.out.print("평균 : ");
		double ave = input.nextDouble() ; // 실수 입력용
		
		System.out.printf("현재 당신의 이름은 %s\n 당신의 나이는 %d\n 평균은 %5.2f\n 입니다.",name,age,ave);
	}

}
