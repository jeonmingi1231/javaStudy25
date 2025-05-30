package ch05.maple.DTO;

public class Account {
	//필드
	private String id ;
	private String pw ; 
	private String nickName ;
	private WarriorDTO warriorDTO ; //전사 
	private ArcherDTO archerDTO; //궁수 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public WarriorDTO getWarriorDTO() {
		return warriorDTO;
	}
	public void setWarriorDTO(WarriorDTO warriorDTO) {
		this.warriorDTO = warriorDTO;
	}
	public ArcherDTO getArcherDTO() {
		return archerDTO;
	}
	public void setArcherDTO(ArcherDTO archerDTO) {
		this.archerDTO = archerDTO;
	}

	// 생성자

	// 메서드
}
