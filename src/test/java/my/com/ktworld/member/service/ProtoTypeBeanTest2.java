package my.com.ktworld.member.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

@Slf4j
public class ProtoTypeBeanTest2 {

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        log.debug("이름={}, 클래스={}", clientBean1.getName(), clientBean1.getClass());
        log.debug("프로토타입 빈 1 = {}, {}", clientBean1.getPrototypeBean().getClass(), clientBean1.getPrototypeBean().getCount());
        clientBean1.rename();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        log.debug("이름={}, 클래스={}", clientBean2.getName(), clientBean2.getClass());
        log.debug("프로토타입 빈 2 = {}, {}", clientBean2.getPrototypeBean().getClass(), clientBean2.getPrototypeBean().getCount());
        assertThat(count2).isEqualTo(2);
    }

    @Getter
    static class ClientBean {

        private final PrototypeBean prototypeBean; // 주입이 끝남.. 사용할때마다 새로 생성되지 않음.

        private String name = "이름입니다만";

        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }

        public void rename() {
            this.name = "수정입니다만?";
        }
    }


    @Scope("prototype")
    static class PrototypeBean {

        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }

}
