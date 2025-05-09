package ch01;

public class OverFlowExam {

	public static void main(String[] args) {
		// 오버플로우 탐지
		//int x = 1000000;
		//int y = 1000000;
		//int z = x * y ; // 10000000000000
		//System.out.println(z); //-727379968 (21억이 넘어서 -로 역행)
		long x = 1000000 ;
		long y = 1000000 ;
		long z = x * y ;
		System.out.println(z); //1000000000000 (long으로 바꿔서 제대로 뜸)
		

	}

}
