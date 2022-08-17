package spring.basic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.basic.AppConfig;

public class MemberServiceTest {
    /*
    //AppConifg라는 설정파일을 적용하기 이전(DIP, OCP위반)의 코드
    MemberService memberService=new MemberServiceImpl();
    */

    //AppConifg라는 설정파일을 적용
    MemberService memberService;
    @BeforeEach //Test실행하기전에 무조건 실행되는 것으로써 마치 생성자의 역할처럼 써보자
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService= appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member=new Member(1L,"member1",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember=memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
