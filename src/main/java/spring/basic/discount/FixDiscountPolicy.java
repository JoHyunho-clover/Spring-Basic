package spring.basic.discount;

import spring.basic.member.Grade;
import spring.basic.member.Member;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount=1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
