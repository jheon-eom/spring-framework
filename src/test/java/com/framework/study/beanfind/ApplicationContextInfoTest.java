package com.framework.study.beanfind;

import com.framework.study.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String springBean : beanDefinitionNames) {
            Object bean = ac.getBean(springBean);
            System.out.println("name = " + springBean + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String springBean : beanDefinitionNames) {
            BeanDefinition bean = ac.getBeanDefinition(springBean);
            System.out.println("name = " + springBean + " object = " + bean);

            if (bean.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean2 = ac.getBean(springBean);
                System.out.println("name = " + springBean + " object = " + bean2);
            }
        }
    }

}
