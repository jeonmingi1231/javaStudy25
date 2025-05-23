package ch02;

import java.util.Scanner;

public class LotooExam {

	public static void main(String[] args) {
		
		
		
		
		
		Scanner in = new Scanner(System.in);
		//키보드로 입력받을 객체
		System.out.println("로또 1부터 45까지의 번호중 6개를 입력해주세요.");
		
		int mynum1 = in.nextInt();
		System.out.println("첫번째 번호 :" + mynum1);
		int mynum2 = in.nextInt();
		System.out.println("두번째 번호 :" + mynum2);
		int mynum3 = in.nextInt();
		System.out.println("세번째 번호 :" + mynum3);
		int mynum4 = in.nextInt();
		System.out.println("네번째 번호:" + mynum4);
		int mynum5 = in.nextInt();
		System.out.println("다섯번째 번호 :" + mynum5);
		int mynum6 = in.nextInt();
		System.out.println("6번째 번호 :" + mynum6);
		//키보드로 6개의 번호를 입력받아 저장
		
		int num1 = (int)(Math.random()*45)+1;
		int num2 = (int)(Math.random()*45)+1;
		int num3 = (int)(Math.random()*45)+1;
		int num4 = (int)(Math.random()*45)+1;
		int num5 = (int)(Math.random()*45)+1;
		int num6 = (int)(Math.random()*45)+1;
		//6개의 랜덤번호 생성후 저장
		
		int x = 0; 
		//맞은숫자
		
		if(mynum1 ==num1 || mynum1 == num2 || mynum1 ==num3 || mynum1 == num4 || mynum1 ==num5 || mynum1 == num6) {
			++x ;
			
		}
		if(mynum2 ==num1 || mynum2 == num2 || mynum2 ==num3 || mynum2 == num4 || mynum2 ==num5 || mynum2 == num6) {
			++x ;
		}
		if(mynum3 ==num1 || mynum3 == num2 || mynum3 ==num3 || mynum3 == num4 || mynum3 ==num5 || mynum3 == num6) {
			++x ;	
		}
		if(mynum4 ==num1 || mynum4 == num2 || mynum4 ==num3 || mynum4 == num4 || mynum4 ==num5 || mynum4 == num6) {
			++x ;
		}
		if(mynum5 ==num1 || mynum5 == num2 || mynum5 ==num3 || mynum5 == num4 || mynum5 ==num5 || mynum5 == num6) {
			++x ;
		}
		if(mynum6 ==num1 || mynum6 == num2 || mynum6 ==num3 || mynum6 == num4 || mynum6 ==num5 || mynum6 == num6) {
			++x ;
		}		
		System.out.println("======================================");
		System.out.println("이번주의 로또 당첨 번호입니다.");
		System.out.println(num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 +
		  " " +num6 + " ");
		System.out.println("======================================");
		
		if(x == 0 ) {
			System.out.println("번호가 하나도 맞지 않았습니다.");
		}else if(x == 1 ) {
			System.out.println("축하합니다.번호가1개 맞았습니다.");
		}else if(x == 2 ) {
			System.out.println("축하합니다.번호가2개 맞았습니다.");
		}else if(x == 3 ) {
			System.out.println("축하합니다.번호가3개 맞았습니다.");
		}else if(x == 4 ) {
			System.out.println("축하합니다.번호가4개 맞았습니다.");
		}else if(x == 5 ) {
			System.out.println("축하합니다.번호가5개 맞았습니다.");
		}else if(x == 6 ) {
			System.out.println("축하합니다.번호가6개 맞았습니다");	
	}else {
		System.out.println("시스템이 아파요");
		
	}
	
	
	}	
	
}



