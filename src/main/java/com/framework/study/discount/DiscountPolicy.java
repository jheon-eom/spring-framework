package com.framework.study.discount;

import com.framework.study.member.domain.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 금액
     */
    int discount(Member member, int price);

}
