package spring.basic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.basic.member.Grade;
import spring.basic.member.Member;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId=1L;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item1", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
