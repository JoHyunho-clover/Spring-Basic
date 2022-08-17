package spring.basic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.basic.AppConfig;
import spring.basic.member.Grade;
import spring.basic.member.Member;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;

public class OrderServiceTest {
    /*
    //AppConifg라는 설정파일을 적용하기 이전(DIP, OCP위반)의 코드
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    */

    //AppConifg라는 설정파일을 적용
    MemberService memberService;
    OrderService orderService;
    @BeforeEach //Test실행하기전에 무조건 실행되는 것으로써 마치 생성자의 역할처럼 써보자
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService= appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId=1L;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item1", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
