package ch05.extended.overrade.Airplane;

public class SuperSonicExam {

	public static void main(String[] args) {
		SuperSonicAirplane sa = new SuperSonicAirplane();
		sa.takeOff(); // 이륙합니다
		sa.fly(); // 일반비행입니다
		sa.flyMode = SuperSonicAirplane.SUPERSONIC;
		// supersoinc 모드로 변경
		sa.fly(); // 초음속 비행합니다
		sa.flyMode = SuperSonicAirplane.NORMAL;
		sa.land();// 일반비행합니다.

	}

}
