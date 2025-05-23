package ch04;

public class EnumWeekExam2 {
	// name() 메서드
	// 열거 객체가 가지고 있는 문자열을 리턴한다.
	// 이때 리턴되는 문자열은 열거 타입을 정의할 때 사용한 상수 이름과 동일하다.

	public static void main(String[] args) {
		Week today = Week.SUNDAY;
		String name = today.name();
		System.out.println("객체의 이름은 : " + name);

		int ordinal = today.ordinal();
		System.out.println("열거순서는 : " + ordinal);

	
		Week day1 = Week.MONDAY ;
		Week day2 = Week.WEDNESDAY ;
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		System.out.println(result1);
		System.out.println(result2);
		
		Week weekday = Week.valueOf("MONDAY");
		if(weekday == Week.SATURDAY || weekday.equals(Week.SUNDAY) ) {
			System.out.println("주말이군요 푹 쉬시고 평일에 힘냅시다!!");
			} else {
				System.out.println("평일이군요 학습을 위해 8시간 이상은 주무세요!!!");
			}
	
	Week[] days = Week.values() ; //Week에 열거상수를 days 배열로 생성
	for(Week a : days) {
		System.out.print(a + " ");
	}
	
	}

	
}