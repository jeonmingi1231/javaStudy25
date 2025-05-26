package ch04.marioKart.dto;

public class MemberDTO {
    public String nickName;
    public String id;
    public String pw;
    public String email;

    public MemberDTO() {
    }

    public MemberDTO(String nickName, String userId, String password) {
        this.nickName = nickName;
        this.id = userId;
        this.pw = password;
    }

    public void display() {
        System.out.println("닉네임: " + nickName);
        System.out.println("아이디: " + id);
        System.out.println("---------------------------");
    }
}
