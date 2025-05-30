package ch04.mbcbank.DTO;

public class AccountDTO {

	// 개인적 필드
	private String ano;
	private String owner;
	private int balance;
	private String bankname;

	// 생성자

	public AccountDTO(String ano, String owner, int balance, String bankname) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		this.bankname = bankname;
	} // private에 있는거 this 로 다 끌어서 적용하게 함.

	public AccountDTO() {// 기본 생성자
		// AccountDTO accountDTO = new AccountDTO
		// super();
	}

	

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	@Override
	public String toString() {
		return "AccountDTO [ano=" + ano + ", owner=" + owner + ", balance=" + balance + ", bankname=" + bankname + "]";
	}
}
