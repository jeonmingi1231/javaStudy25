package ch05.extended.method;

public class ChildExam {

	public static void main(String[] args) {
		Child ch = new Child();
		Parent pr = ch;
		
		pr.method1();
		pr.method2();
		//pr.method3(); // 자식에 있는 메서드3은 호출 불가

	}

}
