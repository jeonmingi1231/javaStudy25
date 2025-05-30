package ch04;

public class CcalculatorExam {

	public static void main(String[] args) {
		// Ccalculator my Calc = new Ccalculator(); 스태틱으로 만들었기 때문에
		// new 생성 x
		double result1 = 10 * 10 * Ccalculator.pi;
		int result2 = Ccalculator.plus(10, 20);
		int result3 = Ccalculator.minus(50, 30);

		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);

	}

}
