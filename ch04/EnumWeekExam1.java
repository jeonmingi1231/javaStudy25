package ch04;

import java.util.Calendar;

public class EnumWeekExam1 {

	public static void main(String[] args) {
		// 이뮴과 내장된 객체(달력)을 연결하여 
		// 날짜를 출력해보자.
		
		Week today = null ;
	 //  타입   변수 =  빈값;
	
		Calendar calendar = Calendar.getInstance(); //Instance<< 객체라는 뜻. getInstance 객체를 가져와서 연결해라. 라는 뜻.
	//	 타입       변수        객체    . 메서드	
	// 캘린더 타입에 객체가 만들어지면서 calendar 변수에 연결됨.            
		
		int year = calendar.get(Calendar.YEAR);// YEAR 같은 다 대문자는 상수(변하지않는 값)
		// 정수 타입의 year 변수에 Calendar 에서 가져온 년도 값을 넣는다.
		
		System.out.println("올해 연도 : " + year);
		
		int month = calendar.get(Calendar.MONTH)+1;
		System.out.println("현재 월은 : " + month + "월 입니다.");
		
		int day = calendar.get(Calendar.DAY_OF_MONTH) ;
		System.out.println("현재 날짜는 : " + day + "일 입니다.");
		int week = calendar.get(calendar.DAY_OF_WEEK) ;
		
		
		switch(week) {
		case 1 : 
			today = Week.SUNDAY ;
			break;
		case 2 :
			today = Week.MONDAY ;
			break;
		case 3 :
			today = Week.TUESDAY ;
			break;
		case 4 : 
			today = Week.WEDNESDAY ;
			break;
		case 5 :
			today = Week.THURSDAY ;
			break;
		case 6 : 
			today = Week.FRIDAY ;
			break;
		case 7 : 
			today = Week.SATURDAY ;
			break;
		}
		System.out.println("현재 날짜는 "+ year + "년" + month + "월" +  day + "일(" + today+")입니다.");
		int hour = calendar.get(calendar.HOUR) ;
		int minute = calendar.get(calendar.MINUTE) ;
		int second = calendar.get(calendar.SECOND) ;
		System.out.println("현재시간은" + hour + "시" + minute + "분" + second + "초 입니다.");
	
		//요일별 스케줄 
		if(today == Week.SUNDAY) {
			System.out.println("일요일입니다. 열심히 집안일을 합시다.");
		}else if (today == Week.MONDAY) {
			System.out.println("월요일입니다. 열심히 자바공부를 합니다.");
		}else if (today == Week.TUESDAY) {
			System.out.println("화요일입니다. 열심히 오라클db공부를 합니다.");
		}else if (today == Week.WEDNESDAY) {
			System.out.println("수요일입니다. 열심히 jsp공부를 합니다");
		}else if (today == Week.THURSDAY) {
			System.out.println("목요일입니다. 열심히 클라우드공부를 합니다.");
		}else if (today == Week.FRIDAY) {
			System.out.println("금요일입니다. 열심히 파이썬공부를 합니다.");
		}else if (today == Week.SATURDAY) {
			System.out.println("토요일입니다. 열심히 영화를 봅니다.");
		}
	}
	

}
