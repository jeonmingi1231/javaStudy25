package ch01;

public class StringCahmJoExam {

	public static void main(String[] args) {
		// String���� Ÿ�� ��(���ڿ�)
		String strval1 = "���α�" ;
		String strval2 = "���α�" ;
		String strval3 = new String("���α�") ;
				
		System.out.println(strval1 == strval2) ;		
		System.out.println(strval1 == strval3) ;
		System.out.println("~~~~~~~~~~~~~~~~~~~") ;
		System.out.println(strval1.equals(strval2));
		System.out.println(strval1.equals(strval3));
		
	}

}
