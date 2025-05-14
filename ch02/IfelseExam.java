package ch02;

import java.util.Scanner;

public class IfelseExam {

	public static void main(String[] args) {
		// 게임 아이템 착용 레벨 if문 만들어보기
		
		Scanner inputInt = new Scanner(System.in) ; //정수 입력 객체
		Scanner inputStr = new Scanner(System.in); //문자 입력 객체
		
		System.out.print("현재 레벨을 입력하세요 : ");
		int lv = inputInt.nextInt(); // 레벨 입력받기.
		System.out.println("회원님의 레벨은 : "+lv +"레벨 입니다.");
		System.out.println("=========================");
		
		
		System.out.println("어느 장비를 착용 하시겠습니까???"); //아이템 입력받기
		System.out.println("=========================");
		System.out.println("빨간색 우산");
		System.out.println("파란색 우산");
		System.out.println("노란색 우산");
		System.out.println("====================");
		System.out.print("장착 하실 아이템 이름을 입력하시오.>>>");
		String item = inputStr.nextLine();
		//키보드로 입력받을 문자 객체 만들기
		 if (item.equals("빨간색 우산")) {
	         if (lv >= 50) {   
			 System.out.println("빨간색 우산을 장착할 수 있습니다.");
	            System.out.println("장착 하시겠습니까? (yes / no)");
	            System.out.println(">>>>>>");
	            String answer = inputStr.nextLine(); //yes/no를 받기위해 입력 객체를 또 만듬.
	            if (answer.equalsIgnoreCase("yes")) { //equalsIgnoreCase 를 사용해 대소문자 구분없이 사용할수 있게 만듬.
	                System.out.println("아이템을 장착했습니다.");
	            } else {
	                System.out.println("아이템 장착을 취소했습니다.");
	            }
	            
	         } else {
	        	 System.out.println("레벨이 50 이상이어야 빨간색 우산을 장착할 수 있습니다.");
	         }
	        
		 } else if (item.equals("파란색 우산")) {
	        	  if (lv >= 30) {
	        	System.out.println("파란색 우산을 장착할 수 있습니다.");
	        	System.out.println("장착 하시겠습니까? (yes / no)");
	            System.out.println(">>>>>>");
	            String answer = inputStr.nextLine();
	            if (answer.equalsIgnoreCase("yes")) {
	                System.out.println("아이템을 장착했습니다.");
	            } else {
	                System.out.println("아이템 장착을 취소했습니다.");
	            }
	            
	        } else {
	            System.out.println("레벨이 30 이상이어야 파란색 우산을 장착할 수 있습니다.");  
	       
	        }
	        } else if (item.equals("노란색 우산")) {
	        	 if (lv >= 10) {
	            System.out.println("노란색 우산을 장착할 수 있습니다.");
	            System.out.println("장착 하시겠습니까? (yes / no)");
	            System.out.println(">>>>>>");
	            String answer = inputStr.nextLine();
	            if (answer.equalsIgnoreCase("yes")) {
	                System.out.println("아이템을 장착했습니다.");
	            } else {
	                System.out.println("아이템 장착을 취소했습니다.");
	            }
	        	 } else {
	                 System.out.println("레벨이 10 이상이어야 노란색 우산을 장착할 수 있습니다.");
	        	 }
	        	 } else {
	        		 System.out.println("알 수 없는 아이템입니다. 다시 시도해 주세요.");
	        }
		
		
		
	   
		 
	 }
	
}


