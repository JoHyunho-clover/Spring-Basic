package spring.basic.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.basic.discount.DiscountPolicy;
import spring.basic.discount.FixDiscountPolicy;
import spring.basic.discount.RateDiscountPolicy;
import spring.basic.member.*;

@Component
public class OrderServiceImpl implements OrderService{

    /*
    private final MemberRepository memberRepository= new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy=new FixDiscountPolicy(); //원래의 코드는 DIP위반
    //private final DiscountPolicy discountPolicy=new RateDiscountPolicy(); //이것으로 변경한 것 자체가 OCP위반이며, 바꾼 코드는 DIP위반이다.
    private DiscountPolicy discountPolicy; //DIP원칙을 지키도록 변경하였다. 나중에 보면 이렇게 바꾼 것이 OCP원칙도 지키는 것이 된다.
    // 이것만 있다면 객체화된 것이 아니라서 그냥 실행하면, null point exception이 나온다
    // 그래서 이것을 해결하기 위해 위의 것에 대신 객체를 주입해주는 DI를 적용하면 된다.
    //구체화에 의존하는 것은 역할 하나가 추가 되는 거랑 마찬가지이다. 구현체로써 설정을 해주어야하기 때문이다. ->SRP 위반
    */

    private final MemberRepository memberRepository; //DIP원칙을 지키며, DI 적용 - 해당 인터페이스를 구현한 구현체 중 아무거나 들어와도 된다. 이렇게 됨으로써 유연한 변경이 가능해짐
    private final DiscountPolicy discountPolicy;

    @Autowired //안붙여도 되긴해 왜냐하면 생성자가 하나라서
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) { //이것으로 SRP 원칙 지키게 된다. (책임 분리)
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
