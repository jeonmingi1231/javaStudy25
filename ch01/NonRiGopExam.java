package ch01;

import java.util.Scanner;

public class NonRiGopExam {

	public static void main(String[] args) {
		// ���� �׽�Ʈ
		// & < �� �Ѵ� true ���� �� true�� ����ȴ�.
		
		Scanner input = new Scanner(System.in); // Ű����� �Է¹��� ��ü ����
		System.out.print("������ �Է��Ͻø� ��ҹ��ڳ� ���ڸ� �Ǵ��մϴ� : ");
		
		int charCode = input.nextInt(); // Ű����� �Է� ���� ���� charcode ������ ����
		
		if( (charCode >= 65 ) && (charCode <= 90) ) { //charCode �� 65�̻� 90�����̸�
				System.out.println("�Է°��� �빮�� �Դϴ� : " + (char)charCode)  ;
				//������� �ϸ� ���϶��� ��� ���� ����.
				//�׷��� else if �� �Ἥ �ٸ� ��°��� ����� �����
				
		}else if((charCode >= 97 ) && (charCode <= 122)) {
			System.out.println("�Է°��� �ҹ��� �Դϴ� : " + (char)(charCode)) ;
			
		}else if( !(charCode < 48 ) && !(charCode > 57) ) { //NAND
			// (!�� �־ ����)48���� ���� �ʰ� 57���� ũ�� ����
				System.out.println("�Է°��� ���� �Դϴ� : " + ((char)charCode)) ;
			//���� �����ڵ� ��ҹ���,���� ���� �Է�������,�ƴҽ��� ��°��� ����������
			//else + sysout ����ؼ� �ƴҶ��� �ƴϴ�. ��� ��°��� ����� ��.
				
		}else {
			System.out.println("��ҹ��ڳ� ���ڰ� �ƴմϴ�.");
			
		}

	}
	
}	
