package ch02;

import java.util.Scanner;

public class IfExam2 {

	public static void main(String[] args) {
		// 점수확인프로그램
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요.");
		System.out.print(">>> ");
		String name = input.nextLine();
		
		System.out.println("점수를 입력하세요");
		System.out.print("국어 : ");
	    int kor = input.nextInt(); { //���� ���� �Է�
	    if(kor < 0 || kor >100) {
	    	System.out.println("다시입력해주세요."); //���� ����
	    }
		
	   System.out.print("수학 : ");
	   int mat = input.nextInt();
	   if(mat < 0 ||mat > 100) {
		   System.out.println("다시입력해주세요."); //���� ����
	   }
		
	   System.out.print("영어 : ");
	   int eng = input.nextInt();
	   if(eng < 0 || eng > 100) {
		   System.out.println("다시입력해주세요."); //���� ���� 
	   }
		
	   int total = kor + mat + eng ;
	   double avg = total / 3 ;
	   System.out.println("확인되었습니다.");
	   System.out.print("평균을 확인하시겠습니까? (yes/no):");
	   String answer = input.next();
	   if(answer.equalsIgnoreCase("yes")) {
		   System.out.println("===처리중===");
		   System.out.println("평균 : " + avg );
	   }else {
	   System.out.println("다시입력해주세요.");
	   
	   }
	   	System.out.print("프로그램을 종료하시겠습니까? (yes / no) : ");
	    String answer2 = input.next();
	    if(answer2.equalsIgnoreCase("yes")) {
	    System.out.println("프로그램을 종료합니다");
	     
	    
	 	}else { 
	    System.out.println("다시 입력해주세요!!");
	 	}
	    	
	    }

}
	
}
