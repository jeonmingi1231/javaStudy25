package ch03;

import java.util.Scanner;

public class ArrayExam {

	public static void main(String[] args) {
		// 키보드로 입력받은 값을 배열에 저장 후 CRUD 테스트
		// C 성적을 입력하기
		// R 성적을 보기 (전체 보기, 1개 보기)
		// U 성적을 수정하기
		// D 성적을 삭제하기
		// 개선사항 -> 성적 입력시 NULL 값을 보고 넣어보기

		Scanner inputInt = new Scanner(System.in); // 정수받을 키보드 객체

		System.out.println("=====1학년 성적처리=====");
		System.out.println("학생수를 입력해 주세요.");
		System.out.print(">>>");
		int count = inputInt.nextInt(); // 키보드로 받을 학생수 카운트 객체 만들기
		System.out.println(count + "명 의 학생수를 입력합니다. ");

		// 이름,국,수,영 과목의 점수를 받아야 하니까 배열객체 만들기

		String[] names = new String[count]; // 이름 배열
		int[] kors = new int[count]; // 국어 배열
		int[] mats = new int[count]; // 수학 배열
		int[] engs = new int[count]; // 영어 배열
		// 국,수,영 점수의 배열을 학생 수 만큼 만듬

		boolean run = true; // while (run)을 사용해 반복문을 만들꺼니까 boolean만들기

		while (run) {
			System.out.println("=====성적처리=====");
			System.out.println("1. 성적입력");
			System.out.println("2. 전체성적보기");
			System.out.println("3. 개인성적보기");
			System.out.println("4. 성적수정하기");
			System.out.println("5. 성적삭제하기");
			System.out.println("9. 성적프로그램 종료");
			System.out.print(">>>");
			int select = inputInt.nextInt(); // 키보드로 번호 입력 받을 객체 만들기

			switch (select) {
			case 1:
				System.out.println("성적입력화면입니다.");
				// 메서드 생성할 때는 입력 값과 출력 값을 먼저 생각 해야 한다.
				scoreAdd(names, kors, mats, engs); // scoreAdd 처럼 제목하나만들고 필요한 항목()에 넣기
				break;

			case 2:
				System.out.println("전체성적 보기화면입니다.");

				scoreAll(names, kors, mats, engs);
				break;

			case 3:
				System.out.println("개인성적 보기화면입니다.");

				scoreOne(names, kors, mats, engs);
				break;

			case 4:
				System.out.println("개인성적 수정화면입니다.");
				scoremod(names, kors, mats, engs); // 성적 수정 메서드 만들기(메서드 이름에 수정할 객체 넣기))
				break;

			case 5:
				System.out.println("성적 삭제화면입니다.");
				scoreDle(names, kors, mats, engs);
				break;

			case 9:
				System.out.println("성적처리 종료! 프로그램이 종료됩니다.");
				run = false;
				break;

			default:
				System.out.println("1~9까지 만 입력하세요.");
			}// switch문 종료

		} // while문 종료

	}// 메인 메서드 종료

	private static void scoreDle(String[] names, int[] kors, int[] mats, int[] engs) {
		// 성적 삭제 메서드 만들기
		Scanner inputStr = new Scanner(System.in); // 스캐너 객체를 만들때 같은 괄호가 아니면 같은 이름을 써서 만들어도됨.
		Scanner inputInt = new Scanner(System.in);

		System.out.println("삭제할 학생의 이름을 입력하세요.");
		System.out.print(">>>");
		String name = inputStr.next(); // 이름 입력받을 객체 만들고
		String YesNo = inputStr.next();
		for (int i = 0; i < names.length; i++) {// 배열 문장 쓰기
			if (names[i].equals(name)) { // 이퀄스로 이름확인하기
				System.out.println(names[i] + "학생 점수");
				System.out.println("국어 :" + kors[i]);
				System.out.println("수학 :" + mats[i]);
				System.out.println("영어 :" + engs[i]);
				System.out.println("================");
				System.out.println("삭제하시겠습니까?.");
				System.out.println("1.네");
				System.out.println("2.아니요");
				
				
				//삭제 멘트 만들기
					
				}
					
				

				System.out.print("===삭제중===");
				kors[i] = 0;
				mats[i] = 0;
				engs[i] = 0;
				
				System.out.println("삭제완료!!!! ");

				System.out.println("국어 :" + kors[i]); // 수정된 점수 다시 출력하기
				System.out.println("수학 :" + mats[i]);
				System.out.println("영어 :" + engs[i]);
				break;

			}

		
	}// 성적 삭제 메서드 종료

	private static void scoreOne(String[] names, int[] kors, int[] mats, int[] engs) {
		// 개인 성적확인 메서드 만들기
		Scanner inputStr = new Scanner(System.in); // 스캐너 객체를 만들때 같은 괄호가 아니면 같은 이름을 써서 만들어도됨.
		Scanner inputInt = new Scanner(System.in);
		System.out.println("확인할 학생의 이름을 입력하세요.");
		System.out.print(">>>");
		String name = inputStr.next();
		for (int i = 0; i < names.length; i++) {

			if (names[i].equals(name)) {
				System.out.println(names[i] + "학생 점수");
				System.out.println("국어 :" + kors[i]);
				System.out.println("수학 :" + mats[i]);
				System.out.println("영어 :" + engs[i]);
				System.out.println("================");
			} // if문 종료
		} // for문 종료

	} // 개인 성적확인 메서드 종료

	private static void scoreAll(String[] names, int[] kors, int[] mats, int[] engs) {
		// 전체 성적확인하는 메서드 만들기
		Scanner inputStr = new Scanner(System.in); // 스캐너 객체를 만들때 같은 괄호가 아니면 같은 이름을 써서 만들어도됨.
		Scanner inputInt = new Scanner(System.in);

		System.out.println("전체 학생의 성적을 확인합니다.");
		System.out.print(">>>");

		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + "학생 점수");
			System.out.println("국어 :" + kors[i]);
			System.out.println("수학 :" + mats[i]);
			System.out.println("영어 :" + engs[i]);
			System.out.println("================");
		}
	}

	private static void scoremod(String[] names, int[] kors, int[] mats, int[] engs) {
		// 점수 수정 메서드 만들기
		Scanner inputStr = new Scanner(System.in); // 스캐너 객체를 만들때 같은 괄호가 아니면 같은 이름을 써서 만들어도됨.
		Scanner inputInt = new Scanner(System.in);

		System.out.println("수정할 학생의 이름을 입력하세요.");
		System.out.print(">>>");
		String name = inputStr.next(); // 키보드로 입력받을 이름객체 생성
		for (int i = 0; i < names.length; i++) { // 배열 공식 만들기
			if (names[i].equals(name)) { // 배열 되어있는names 이름들중에 .eauals로 맞는 name을 찾는다.
				System.out.println(names[i] + "학생 점수");
				System.out.println("국어 :" + kors[i]);
				System.out.println("수학 :" + mats[i]);
				System.out.println("영어 :" + engs[i]);
				System.out.println("================");
				System.out.println("수정할 점수를 입력하세요.");

				System.out.print("국어수정 점수 : ");
				kors[i] = inputInt.nextInt();

				System.out.print("수학수정 점수 : ");
				mats[i] = inputInt.nextInt();

				System.out.print("영어수정 점수 : ");
				engs[i] = inputInt.nextInt();
				System.out.println("수정완료!!!! ");

				System.out.println("국어 :" + kors[i]); // 수정된 점수 다시 출력하기
				System.out.println("수학 :" + mats[i]);
				System.out.println("영어 :" + engs[i]);
				break;
			}
		}

	}// 점수 수정 메서드 종료

	private static void scoreAdd(String[] names, int[] kors, int[] mats, int[] engs) {
		// 점수 입력할 메서드 만들기 // 메인에서 만든 배열4개를 키보드값을 넣는다.
		Scanner inputStr = new Scanner(System.in); // 스캐너 객체를 만들때 같은 괄호가 아니면 같은 이름을 써서 만들어도됨.
		Scanner inputInt = new Scanner(System.in);
		// 반복해서 성적을 입력해야하니까 for문으로 만든다.
		for (int i = 0; i < names.length; i++) {
			System.out.println("이름을 입력하세요");
			System.out.print(">>>");
			names[i] = inputStr.next(); // 이름 키보드값 넣기

			System.out.print("국어점수 : ");
			kors[i] = inputInt.nextInt(); // 국어 키보드값

			System.out.print("수학점수 : ");
			mats[i] = inputInt.nextInt(); // 수학 키보드값

			System.out.print("영어점수 : ");
			engs[i] = inputInt.nextInt(); // 영어 키보드값
		} // 반복 성적 입력 메서드 종료
		System.out.println("성적입력이 완료 되었습니다.");
	}// 성적입력 메서드 종료

}// 클래스 종료
