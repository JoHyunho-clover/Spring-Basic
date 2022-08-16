package spring.basic.order;

import spring.basic.discount.DiscountPolicy;
import spring.basic.discount.FixDiscountPolicy;
import spring.basic.member.*;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository= new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy=new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
