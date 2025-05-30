package ch04;

public class Television {
	static String company = "LG";
	static String model = "4K";
	static String info;

	static { // 정적블록
		info = company + "-" + model;

	}

}
