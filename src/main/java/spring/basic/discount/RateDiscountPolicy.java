package spring.basic.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring.basic.member.Grade;
import spring.basic.member.Member;

@Component
//@Qualifier("mainDiscountPolicy") //Autowired할 때 같은 타입의 빈이 2개 일때 발생하는 오류로 사용하는 방법중 2번째 방법
@Primary //Autowired할 때 같은 타입의 빈이 2개 일때 발생하는 오류로 사용하는 방법중 3번째 방법
//@MainDiscountPolicy // 어노테이션 직접 등록해서 하는 것.
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent=10;

    @Override
    public int discount(Member member, int price) { //ctrl + shift + T 누르면 test생성
        if(member.getGrade()== Grade.VIP){
            return price*discountPercent/100;
        }else {
            return 0;
        }
    }
}
