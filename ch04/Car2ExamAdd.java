package ch04;

public class Car2ExamAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car2 myCar1 = new Car2();
		System.out.println("myCar1.company" + myCar1.company);
		System.out.println();
	
		Car2 myCar2 = new Car2("자가용");
		System.out.println("myCar2.company : " + myCar2.company);
		System.out.println("myCar2.model : " + myCar2.model);
		System.out.println();
	
		Car2 myCar3 = new Car2("SUV","빨강");
		System.out.println("myCar3.company : " + myCar3.company);
		System.out.println("myCar3.model : " + myCar3.model);
		System.out.println("myCar3.color : " + myCar3.color);
		System.out.println();
	
		Car2 myCar4 = new Car2("슈퍼카","검정", 400);
		System.out.println("myCar4.company : " + myCar4.company);
		System.out.println("myCar4.model : " + myCar4.model);
		System.out.println("myCar4.color : " + myCar4.color);
		System.out.println("myCar4.maxSpeed : " + myCar4.maxSpeed);
		System.out.println();
	}

}
