package com.framework.study.order;

import com.framework.study.AppConfig;
import com.framework.study.discount.FixDiscountPolicy;
import com.framework.study.member.Grade;
import com.framework.study.member.Member;
import com.framework.study.member.MemberService;
import com.framework.study.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void fieldInjectionTest() {
        OrderServiceImpl orderService1 = new OrderServiceImpl(
                new MemoryMemberRepository(), new FixDiscountPolicy());

        orderService1.createOrder(1L, "itemA", 10000);
    }

}
