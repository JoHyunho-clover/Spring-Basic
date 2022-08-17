package spring.basic;

import spring.basic.discount.DiscountPolicy;
import spring.basic.discount.FixDiscountPolicy;
import spring.basic.discount.RateDiscountPolicy;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;
import spring.basic.member.MemoryMemberRepository;
import spring.basic.order.OrderService;
import spring.basic.order.OrderServiceImpl;

public class AppConfig { //애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
    //생성자 주입으로 DI를 적용하면서 OCP를 적용하게 하는 클래스
    //애플리케이션의 실제 동작에 필요한 구현 객체를 생성

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy(); //정액 할인 정책에서 정률 할인 정책으로 바꾸는데에 있어서 AppConfig에 대한 클래스만 수정한다면 전체가 수정이 된다.
        return new RateDiscountPolicy();
    }

}
