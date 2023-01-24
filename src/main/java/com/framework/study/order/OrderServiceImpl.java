package com.framework.study.order;

import com.framework.study.discount.DiscountPolicy;
import com.framework.study.discount.FixDiscountPolicy;
import com.framework.study.member.domain.Member;
import com.framework.study.member.repository.MemberRepository;
import com.framework.study.member.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
