package ch05.extended.People;

public class Student extends People {
	public int studentNo ;
	
	public Student(String name, String ssn, int studentNo) {
		super(name,ssn);
		// this.name = name; 부모에 생성자가 존재함
		// this.ssn = ssn; 기본 생성자가 아니면 super로 호출
		this.studentNo = studentNo;
	}
}
