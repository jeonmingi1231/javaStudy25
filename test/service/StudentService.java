package test.service;

import test.DTO.StudentDTO;

public class StudentService {
	private StudentDTO[] students;
	private int count = 0;

	public StudentService(StudentDTO[] students) {
		this.students = students;
	}

	// 1. 성적등록
	public void insertStudent(String name, int kor, int eng, int mat) {
		if (count >= students.length) {
			System.out.println("더 이상 등록할 수 없습니다.");
			return;
		} // if문 종료
		students[count++] = new StudentDTO(name, kor, eng, mat);

		System.out.println("학생 성적이 등록되었습니다.");
	}// 성적등록 메서드 종료

	// 2. 성적 보기
	public void viewStudents() {
		System.out.println("전체 학생 성적 보기");
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				System.out.println("이름: " + students[i].getName());
				System.out.println("국어: " + students[i].getKor());
				System.out.println("영어: " + students[i].getEng());
				System.out.println("수학: " + students[i].getMat());
				System.out.println("총점 : " + students[i].getTotal());
				System.out.println("평균 : " + students[i].getAvg());
				System.out.println("등급 : " + students[i].getGrade());
				System.out.println("--------------");
			} // if문 종료
		} // for문 종료

	}// 전체 성적 보기 종료

	public void viewStudentByname(String name) {
		boolean find = false;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getName().equals(name)) {
				System.out.println(students[i]);
				find = true;
				break;

			}

		}
		if (!find ) {
			System.out.println("해당 이름의 학생이 없습니다.");
		}
	}
	// 3. 성적수정 메서드 시작

	public void updateStudent(String name, int newKor, int newEng, int newMat) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getName().equals(name)) {
				students[i].setKor(newKor);
				students[i].setEng(newEng);
				students[i].setMat(newMat);
				
				System.out.println(name + " 학생의 성적이 수정되었습니다.");
				return;
			} // if문 종료
		} // for문 종료
		System.out.println("학생을 찾을수 없습니다.");
	}// 성적수정 메서드 종료

	// 4. 성적삭제 메서드 시작.
	public void deleteStudent(String name) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getName().equals(name)) {
				students[i] = null;
				System.out.println(name + " 학생의 성적이 삭제되었습니다.");
				return;
			} // if문 종료
		} // for문종료
	}// 성적 삭제 메서드 종료
} // 클래스 종료
