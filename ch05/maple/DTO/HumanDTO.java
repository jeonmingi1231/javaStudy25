package ch05.maple.DTO;

public class HumanDTO {
	// 부모 역할을 하는 객체

	// 필드
	private String sex;
	private String level;
	private int hp;
	private int mp;
	private int money;

	// 생성자

	// 메서드 (게터 : 출력용 메서드, 세터 : 입력용 메서드)

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
