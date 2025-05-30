package test;

import java.util.Scanner;

import test.DTO.StudentDTO;
import test.service.StudentService;

public class testExam {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// 성적프로그램 만들기
		StudentDTO[] students = new StudentDTO[10];
		StudentService service = new StudentService(students);

		boolean run = true;
		while (run) {
			System.out.println("===성적처리 프로그램 입니다===");
			System.out.println("1.성적등록 | 2. 성적보기 | 3. 성적수정 | 4.성적삭제 | 5.종료");
			System.out.print(">>>");
			String select = input.next();
			switch (select) {
			case "1":
				System.out.println("성적등록으로 진입합니다.");
				System.out.println("이름 : ");
				String name = input.next();
				System.out.println("국어점수 : ");
				int kor = input.nextInt();
				System.out.println("수학점수 : ");
				int mat = input.nextInt();
				System.out.println("영어점수 : ");
				int eng = input.nextInt();
				service.insertStudent(name, kor, eng, mat);
				break;
			case "2":
				boolean run2 = true;
				while (run2) {
					System.out.println("성적보기으로 진입합니다.");
					System.out.println("뒤로가기 1,2번을 제외한 아무 키.");
					System.out.println("1. 전체보기 | 2. 개인보기");
					String choice = input.next();
					switch (choice) {
					case "1":
						System.out.println("전체보기 메뉴로 진입합니다.");
						service.viewStudents();
						break;
					case "2":
						System.out.println("개인보기 메뉴로 진입합니다."); // 개인보기 to string 사용
						System.out.println("조회할 학생 이름 입력 : ");
						String findName = input.next();
						service.viewStudentByname(findName);
						break;
					default:
						run2 = false;
						System.out.println("다시 입력 해주세요");
						break;
					}

				}
				break;
			case "3":
				System.out.println("성적수정으로 진입합니다.");
				System.out.print("수정할 학생 이름 입력: ");
				String updateName = input.next();
				System.out.print("새 국어 점수: ");
				int newKor = input.nextInt();
				System.out.print("새 영어 점수: ");
				int newEng = input.nextInt();
				System.out.print("새 수학 점수: ");
				int newMat = input.nextInt();
				service.updateStudent(updateName, newKor, newEng, newMat);
				break;

			case "4":
				System.out.println("성적삭제으로 진입합니다.");
				System.out.print("삭제할 학생 이름 입력: ");
				String deleteName = input.next();
				service.deleteStudent(deleteName);
				break;
			case "5":
				System.out.println("프로그램을 종료 합니다.");
				run = false;
				break;

			}// switch종료
		} // while 종료

	}// 메인메서드종료

}// 클래스 종료
