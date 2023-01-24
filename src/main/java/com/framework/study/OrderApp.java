package com.framework.study;

import com.framework.study.member.domain.Grade;
import com.framework.study.member.domain.Member;
import com.framework.study.member.service.MemberService;
import com.framework.study.member.service.MemberServiceImpl;
import com.framework.study.order.Order;
import com.framework.study.order.OrderService;
import com.framework.study.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }

}
