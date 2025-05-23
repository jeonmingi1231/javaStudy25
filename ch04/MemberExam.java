package ch04;

import java.util.Scanner;

import javax.security.sasl.SaslClient;

public class MemberExam {

	public static void main(String[] args) {
	    // enum을 사용하여 회원등급을 결정하기.
		Scanner input = new Scanner(System.in); //키보드로 입력받는 객체 만들기.
		
		String[] names = null ; 
		String[] ids = null ;
		String[] pws = null ;
		MemberGrade[] grades = null; //MemberGrade[] << 만든 이늄 을 끌어쓰게 하는 객체
		
		System.out.println("몇명의 회원을 등록 하시겠습니까");
	    System.out.print(">>>");
	    int count = input.nextInt(); //키보드로 입력 받기.
	    names = new String[count] ; // 키보드로 입력받을 names를 count 만큼 받겠다.
	    ids = new String[count] ; // "
	    pws = new String[count] ; // "
	    grades = new MemberGrade[count] ; // "
	    //회원가입 창 만들기
	    System.out.println("회원가입을 시작합니다.");
	    for(int i=0;i<names.length;i++) {
	    	System.out.print("이름 >>>");
	    	names[i]=input.next(); // 입력받은 이름을 names[i]에 넣는다.
	    	System.out.print("id >>>");
	    	ids[i] = input.next();
	    	System.out.print("pw >>>");
	    	pws[i] = input.next();
	    	
	    	System.out.println("등급을 선택하세요.");
	    	  System.out.println("1. GUEST" );
	          System.out.println("2. USER" );
	          System.out.println("3. MANAGER" );
	          System.out.println("4. ADMIN" );
	          System.out.println(">>>");
	          String grade = input.next();
	          switch(grade) {    
	    case "1" :
            grades[i] = MemberGrade.GUEST; 
            System.out.println("손님 등급입니다.");
            break;
         case "2" :
            grades[i] = MemberGrade.USER;
            System.out.println("유저 등급입니다.");
            break;
         case "3" :
            grades[i] = MemberGrade.MANAGER;
            System.out.println("관리자 등급입니다.");
            break;
            
         case "4" :
            grades[i] = MemberGrade.ADMIN;
            System.out.println("최고관리자 등급입니다.");
            break;

	    	
	    	
	    }
		
	    }
	}
	
	}


