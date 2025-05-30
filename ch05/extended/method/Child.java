package ch05.extended.method;

public class Child extends Parent {

	@Override
	public void method2() {
		System.out.println("자식의 메서드 2 호출");
		System.out.println("Child-method2()");
	}

	public void method3() {
		System.out.println("자식의 메서드 1 호출");
		System.out.println("Child-method3()");
	}

}
