package ch04.marioKart.service;

import java.util.Scanner;
import ch04.marioKart.dto.MemberDTO;

public class MemberService {
    // 회원관리용 CRUD + 로그인 상태 관리

    // 회원관리 메뉴
    public MemberDTO menu(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
        System.out.println("==== 회원관리 메뉴에 진입하였습니다 ====");
        boolean subrun = true;
        while (subrun) {
            System.out.println("1. 가입 | 2. 로그인 | 3. 수정 | 4. 삭제 | 5. 종료");
            System.out.print(">>> ");
            String select = input.next();

            switch (select) {
                case "1":
                    System.out.println("계정을 생성합니다.");
                    create(input, memberDTOs);
                    break;
                case "2":
                    System.out.println("로그인합니다.");
                    loginState = login(input, memberDTOs, loginState);
                    break;
                case "3":
                    System.out.println("계정을 수정합니다.");
                    modify(input, memberDTOs, loginState);
                    break;
                case "4":
                    System.out.println("계정을 삭제합니다.");
                    delete(input, memberDTOs, loginState);
                    break;
                case "5":
                    System.out.println("회원관리메뉴를 종료합니다.");
                    System.out.println("메인메뉴로 복귀합니다.");
                    subrun = false;
                    break;
                default:
                    System.out.println("1~5 사이의 값만 허용합니다.");
            }
        }
        return loginState;
    }

    // 회원가입
    public void create(Scanner input, MemberDTO[] memberDTOs) {
        System.out.println("회원가입용 메서드에 오신걸 환영합니다.");
        MemberDTO memberDTO = new MemberDTO();

        System.out.print("사용할 id를 입력하세요 >>> ");
        memberDTO.id = input.next();

        System.out.print("사용할 pw를 입력하세요 >>> ");
        memberDTO.pw = input.next();

        System.out.print("사용할 닉네임을 입력하세요 >>> ");
        memberDTO.nickName = input.next();

        System.out.print("사용할 이메일을 입력하세요 >>> ");
        memberDTO.email = input.next();

        // 빈 공간에 회원 추가
        for (int i = 0; i < memberDTOs.length; i++) {
            if (memberDTOs[i] == null) {
                memberDTOs[i] = memberDTO;
                System.out.println(memberDTO.nickName + "님 회원가입을 축하드립니다.");
                return;
            }
        }
        System.out.println("회원가입 공간이 부족합니다.");
    }

    // 로그인
    public MemberDTO login(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
        System.out.print("사용할 id를 입력하세요 >>> ");
        String id = input.next();

        System.out.print("사용할 pw를 입력하세요 >>> ");
        String pw = input.next();

        boolean isLoginOk = false;
        for (int i = 0; i < memberDTOs.length; i++) {
            if (memberDTOs[i] != null && memberDTOs[i].id.equals(id) && memberDTOs[i].pw.equals(pw)) {
                System.out.println("로그인 성공");
                loginState = memberDTOs[i];
                isLoginOk = true;
                break;
            }
        }
        if (!isLoginOk) {
            System.out.println("로그인 실패. id 또는 pw가 틀렸습니다.");
            loginState = null;
        } else {
            System.out.println(loginState.nickName + "님 로그인 성공!");
        }
        return loginState;
    }

    // 회원정보 수정
    public void modify(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
        if (loginState == null) {
            System.out.println("로그인 상태가 아닙니다. 로그인 후 이용해주세요.");
            return;
        }

        System.out.print("현재 id를 입력하세요 >>> ");
        String id = input.next();

        System.out.print("현재 pw를 입력하세요 >>> ");
        String pw = input.next();

        if (loginState.id.equals(id) && loginState.pw.equals(pw)) {
            System.out.print("변경할 pw를 입력하세요 >>> ");
            String newPw = input.next();
            loginState.pw = newPw;
            System.out.println("비밀번호가 수정되었습니다.");
        } else {
            System.out.println("id 또는 pw가 일치하지 않습니다.");
        }
    }

    // 회원정보 삭제
    public void delete(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
        if (loginState == null) {
            System.out.println("로그인 상태가 아닙니다. 로그인 후 이용해주세요.");
            return;
        }

        System.out.print("id를 입력하세요 >>> ");
        String id = input.next();

        System.out.print("pw를 입력하세요 >>> ");
        String pw = input.next();

        if (loginState.id.equals(id) && loginState.pw.equals(pw)) {
            System.out.print("계정을 삭제하시겠습니까? (1. yes / 2. no) >>> ");
            String answer = input.next();

            switch (answer) {
                case "1":
                    for (int i = 0; i < memberDTOs.length; i++) {
                        if (memberDTOs[i] != null && memberDTOs[i].id.equals(id)) {
                            memberDTOs[i] = null;
                            System.out.println("계정이 삭제되었습니다.");
                            break;
                        }
                    }
                    break;
                case "2":
                    System.out.println("계정 삭제가 취소되었습니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 계정 삭제가 취소됩니다.");
                    break;
            }

        } else {
            System.out.println("id 또는 pw가 일치하지 않습니다.");
        }
    }
}
