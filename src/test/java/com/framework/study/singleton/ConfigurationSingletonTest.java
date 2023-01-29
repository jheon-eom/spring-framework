package com.framework.study.singleton;

import com.framework.study.AppConfig;
import com.framework.study.member.MemberRepository;
import com.framework.study.member.MemberServiceImpl;
import com.framework.study.member.MemoryMemberRepository;
import com.framework.study.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemoryMemberRepository memberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());

        System.out.println("memberService = " + memberService.getMemberRepository());
        System.out.println("orderService = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);
    }

}
