package spring.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.basic.discount.DiscountPolicy;
import spring.basic.discount.FixDiscountPolicy;
import spring.basic.discount.RateDiscountPolicy;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;
import spring.basic.member.MemoryMemberRepository;
import spring.basic.order.OrderService;
import spring.basic.order.OrderServiceImpl;

@Configuration // 자바 코드만 사용하다가 Spring을 이용하기 위한 어노테이션 , 구성정보다라고 알려주는 것 // 설정 정보 또는 구성 정보
public class AppConfig { //애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
    //생성자 주입으로 DI를 적용하면서 OCP를 적용하게 하는 클래스
    //애플리케이션의 실제 동작에 필요한 구현 객체를 생성

    @Bean// 빈을 SpringContainer에 수동 등록하는 어노테이션, 빈의 이름은 메서드 명으로 된다. 빈으로 등록되는 것은 return되는 값이 등록된다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean // 빈을 SpringContainer에 수동 등록
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean // 빈을 SpringContainer에 수동 등록
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean // 빈을 SpringContainer에 수동 등록
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy(); //정액 할인 정책에서 정률 할인 정책으로 바꾸는데에 있어서 AppConfig에 대한 클래스만 수정한다면 전체가 수정이 된다.
        return new RateDiscountPolicy();
    }

}
