package ch02;

import java.util.Scanner;

public class SsnExam {

	public static void main(String[] args) {
		// �ֹι�ȣ ����
		
		System.out.println("당신의 주민번호를 입력하시오 : ");
		Scanner in = new Scanner(System.in);
		
		String ssn = in.next();
	
		char ssn2 = ssn.charAt(6);//성별 확인 추출
		int num = Character.getNumericValue(ssn2);
		
		if(num % 2 == 0) {
			System.out.println("여자");	
		} else if (num % 2 == 1 ) {
			System.out.println("남자");
		
		} else {
			System.out.println("다시 작성해주세요");
		} 
		
		int year = Integer.parseInt(ssn.substring(0,2));
		
		if(num == 1 || num == 2 || num == 5 || num == 6 ) {
				System.out.println("나이는 " + (2023 - (1900 + year) + 1) + "입니다.");
		} else if(num == 3 || num == 4 || num == 7 || num == 8 ) {
				System.out.println("나이는" + (2023 - (2000 + year) + 1 ) + "입니다." );
		} else {
			System.out.println("잘못입력하셨습니다.");
		}	
		
		int month = Integer.parseInt(ssn.substring(2,4));
		
		if(month <= 0 || month >= 13) {
			System.out.println("다시 작성해주세요.");
		} else if(month >= 3 && month <= 5) {
			System.out.println("봄에 태어났습니다.");
		} else if(month >= 6 && month <= 8) {
			System.out.println("여름에 태어났습니다.");
		} else if(month >= 9 && month <= 11) {
			System.out.println("가을에 태어났습니다.");
		} else {
			System.out.println("겨울에 태어났습니다.");	
		
		}
		

	} 

} 
