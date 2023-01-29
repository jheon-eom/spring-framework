package com.framework.study;

import com.framework.study.discount.DiscountPolicy;
import com.framework.study.discount.RateDiscountPolicy;
import com.framework.study.member.MemberRepository;
import com.framework.study.member.MemberService;
import com.framework.study.member.MemberServiceImpl;
import com.framework.study.member.MemoryMemberRepository;
import com.framework.study.order.OrderService;
import com.framework.study.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
        return null;
    }


    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
