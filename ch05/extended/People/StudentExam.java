package ch05.extended.People;

public class StudentExam {

	public static void main(String[] args) {
		Student st = new Student("전민기", "123456-1234567", 1);

		System.out.println("name : " + st.name);
		System.out.println("ssn : " + st.ssn);
		System.out.println("학번 : " + st.studentNo);
	}

}
