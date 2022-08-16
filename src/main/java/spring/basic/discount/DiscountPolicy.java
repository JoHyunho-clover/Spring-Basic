package spring.basic.discount;

import spring.basic.member.Member;

public interface DiscountPolicy {
    /*
    * return값은 할인 금액
    * */
    int discount(Member member, int price);
}
