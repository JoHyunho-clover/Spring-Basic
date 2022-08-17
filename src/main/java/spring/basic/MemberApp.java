package spring.basic;

import spring.basic.member.Grade;
import spring.basic.member.Member;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;

public class MemberApp {// 이렇게 테스트 하는 것은 한계가 있어 좋은 방법이 아니라서 JUnit으로 하는 것이 좋다.

    public static void main(String[] args) {
        /*
        //AppConifg라는 설정파일을 적용하기 이전(DIP, OCP위반)의 코드
        MemberService memberService = new MemberServiceImpl();
        */

        //AppConifg라는 설정파일을 적용
        AppConfig appConfig= new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = "+findMember.getName());
    }
}
