package ch01;

public class StringConcatExam {

	public static void main(String[] args) {
		// ���ڿ� ���� ������

		String str1 = "jdk" + 8.8 ;
		String str2 = str1 + "����" ;
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("------------------");
		String str3 = "qwe" + 5 + 5.5 ;
		String str4 = 5 + 5.5 + "qwe" ;
		System.out.println(str3);
		System.out.println(str4);
		
		
	}

}
