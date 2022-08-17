package spring.basic;

import spring.basic.member.Grade;
import spring.basic.member.Member;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;
import spring.basic.order.Order;
import spring.basic.order.OrderService;
import spring.basic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        /*
        //AppConifg라는 설정파일을 적용하기 이전(DIP, OCP위반)의 코드
        MemberService memberService= new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        */

        //AppConifg라는 설정파일을 적용
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService=appConfig.orderService();

        Long memberId=1L;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item1", 20000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());

    }
}
