package my.com.ktworld.member.service;

import lombok.extern.slf4j.Slf4j;
import my.com.ktworld.KtWorldApplication;
import my.com.ktworld.practice.SingletonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
@SpringBootTest
public class SingletonTest {

    @Autowired
    private SingletonService singletonService;

    @Test
    public void testA() {
        singletonService.test1();
        singletonService.test2();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(KtWorldApplication.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            log.info(name);
        }
        // 예제에서는 인터페이스, 서비스로직 등을 빈으로 등록했었다...
    }

}
