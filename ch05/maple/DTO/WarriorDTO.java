package ch05.maple.DTO;

public class WarriorDTO extends HumanDTO {
	// extends -> 상속한다 HumanDT -> 이라는 객체를
	// 필드

	private String sword; // 칼
	private String armor; // 갑옷
	private String shield; // 방패

	// 생성자

	// 메서드

	public String getSword() {
		return sword;
	}

	public void setSword(String sword) {
		this.sword = sword;
	}

	public String getArmor() {
		return armor;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

	public String getShield() {
		return shield;
	}

	public void setShield(String shield) {
		this.shield = shield;
	}

}
