package ch02;

import java.util.Scanner;

public class SwitchExam2 {

	public static void main(String[] args) {
		// SwitchExam �����ϱ�.
		// �౸ ���� Ȩ������ �����
		
		Scanner input = new Scanner(System.in);
		System.out.println("===========================");
		System.out.println("mbcFC����Ʈ�� ���Ű��� ȯ���մϴ�.");
		System.out.println("� �޴��� Ȯ���ұ��?");
		System.out.println("a. player");
		System.out.println("b. shop");
		System.out.println("c. ������");
		System.out.println("z. â �ݱ�");
		System.out.print("(a~z)>>>");
		char site = input.next().charAt(0) ;
		System.out.println("������ ���� : " + site);
		
		switch(site) { // if������ ����� if(site == a || site == A ){
		case 'a' :
		case 'A' :
			System.out.println("plyer �� �����մϴ�.");
			System.out.println("1. ������");
			System.out.println("2. ��Ī ������");
			System.out.println("3. �� ������");
			System.out.print("(1~3)>>>");
			int subSelete = input.nextInt() ;
			switch(subSelete) { // ����
			case 1 : // if(subSelete == 1) {
				System.out.println("1. ������ ������� �����մϴ�.");
				break; //����
			case 2 : // else if (subSelete == 2) {
				System.out.println("2. ��Ī ������ ������� �����մϴ�.");
				break; //����
			case 3 : // else if (subSelete == 3) {
				System.out.println("3. �� ������ ������� �����մϴ�.");	
				break;//����
			default : //����Ʈ ��� else�� �ƴҶ��� �� �Է�
				System.out.println("(1~3)�� �Է����ּ���. ");
				System.out.println("�ùٸ������� ��ȣ �Դϴ�. ó������ �ٽ� ���ּ���.");
			}
		
			break;//����
		case 'b' : // switch ���� if/else������ �����ϱ�.
		case 'B' :
			System.out.println("shop ���� �����մϴ�.");
			System.out.println("1. Ƽ��");
			System.out.println("2. ������");
			System.out.println("3. ����");
			System.out.print("(1~3)>>>");
			int subSelete2 = input.nextInt() ;
			
			if (subSelete2 == 1) { // case ��� if�� �ؼ� ���� 1������ true�� �ٲ��ش�
			
				System.out.println("1. Ƽ�� ������� �����մϴ�.");
			
			}else if (subSelete2 == 2) { // 1������ �ƴҶ� 2������ true�� �ǰ� else if�� ���ش�.
				System.out.println("2. ������ ������� �����մϴ�.");
				
			}else if (subSelete2 == 3) { // 1,2�� ���� �ƴҶ� 3���� true�� �ǰ� else if�� ���ش�.
				System.out.println("3. ���� ������� �����մϴ�.");	
				
			}else { //�´� �ƴ� ��찡 �����Ƿ� else�� ���ش�.
				System.out.println("(1~3)�� �Է����ּ���. ");
				System.out.println("�ùٸ������� ��ȣ �Դϴ�. ó������ �ٽ� ���ּ���.");
			}
			break;
		case 'c' :
		case 'C' :
			System.out.println("������ �� �����մϴ�.");
			System.out.println("1. �¶��� ���");
			System.out.println("2. ��ȭ ���");
			System.out.println("3. �Խ���");
			System.out.print("(1~3)>>>");
			int subSelete3 = input.nextInt() ;
			switch(subSelete3) {
			case 1 :
				System.out.println("1. �¶��� ��� ������� �����մϴ�.");
				break;
			case 2 :
				System.out.println("2. ��ȭ ��� ������� �����մϴ�.");
				break;
			case 3 :
				System.out.println("3. �Խ��� ������� �����մϴ�.");	
				break;
			default :
				System.out.println("(1~3)�� �Է����ּ���. ");
				System.out.println("�ùٸ������� ��ȣ �Դϴ�. ó������ �ٽ� ���ּ���.");
			}	//��ȣ �ݱ�.
			break;
			
		case 'z' :
		case 'Z' :
			System.out.println("â �� �ݽ��ϴ�.");
			break;	
		
		default :
			System.out.println("�޴��� ���� ���ڸ� �־����ϴ�.");
			System.out.println("���α׷��� �ٽ� ������ �ּ���.");
			break;
		
		}
	}

}

	
	
