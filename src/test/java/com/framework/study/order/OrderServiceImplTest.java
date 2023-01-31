package com.framework.study.order;

import com.framework.study.discount.FixDiscountPolicy;
import com.framework.study.member.Grade;
import com.framework.study.member.Member;
import com.framework.study.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "memberA", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());

        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getItemPrice()).isEqualTo(10000);
    }

}