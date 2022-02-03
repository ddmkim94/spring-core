package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPrice = 10;
    @Override
    public int discount(Member member, int price) {
        return (member.getGrade() == Grade.VIP) ? (price * discountPrice) / 100 : 0;
    }
}
