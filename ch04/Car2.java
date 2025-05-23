package ch04;

public class Car2 { //Car2 클래스를 공용으로 생성한다.
	//필드 (객체의 데이터가 저장되는 곳)
	String company = "볼보" ;
	String model;
	String color;
	int maxSpeed;
	
	//생성자 (객체 생성시 초기화 역할 담당)
	Car2() { //기본생성자
		
	}
	Car2(String model) { //모델값만 받는 생성자
		this.model=model;
	}
	Car2(String model,String color){ //모델과 색상정보를 받는 생성자
		this.model=model;
		this.color=color;
	}
	Car2(String model,String color,int maxSpeed){
		//모델과 색상정보를 받는 생성자
		this.model=model;
		this.color=color;
		this.maxSpeed =maxSpeed;
	}










}
