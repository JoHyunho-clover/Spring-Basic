package spring.basic.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.basic.member.Grade;
import spring.basic.member.Member;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다") //이거 설정안해주면 Test명이 메서드명으로 된다 이 어노테이션은 Junit5부터 적용된다
    void vip_o(){
        //given
        Member member=new Member(1L,"memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test//하나의 상황에대해서만 하는게 아니라 반대되는 즉, 실패되는 경우도 Test를 짜야한다.
    @DisplayName("VIP는 10% 할인이 적용되지 않아야한다")
    void vip_x(){
        //given
        Member member=new Member(2L,"memberBASIC", Grade.Basic);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}