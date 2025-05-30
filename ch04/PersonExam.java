package ch04;

public class PersonExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("123456-1234567", "김기원");
		
		System.out.println(p1.nation);
		System.out.println(p1.name);
		System.out.println(p1.ssn);
		
		// p1.nation = "USA"; << 오류뜸 이유: final로 생성했기 때문에 초기값 변경XX
	
		p1.name = "엠아이티"; // 이건 final 로 선언x 그래서 변경 가능
		System.out.println(p1.nation);
		System.out.println(p1.name);
		System.out.println(p1.ssn);
	
	
	
	}

}
