package ch04;

public class Car2Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car2 myCar1 = new Car2();
		System.out.print("(기본생성자)차량정보 : " + myCar1.model);
		System.out.print(myCar1.company+myCar1.color+myCar1.maxSpeed);;
		System.out.println();
	
		Car2 myCar2 = new Car2("SUV");
		System.out.print("차량정보 : " + myCar2.model);
		System.out.print(myCar2.company+myCar2.color+myCar2.maxSpeed);;
		System.out.println();
	
		Car2 myCar3 = new Car2("SUV","빨강");
		System.out.print("차량정보 : " + myCar3.model);
		System.out.print(myCar3.company+myCar3.color+myCar3.maxSpeed);;
		System.out.println();
	
		Car2 myCar4 = new Car2("세단","파랑",400);
		System.out.print("차량정보 : " + myCar4.model);
		System.out.print(myCar4.company+myCar4.color+myCar4.maxSpeed);;
		System.out.println();
	
	
	
	
	
	
	
	
	
	
	}

}
