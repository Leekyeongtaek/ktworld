package my.com.ktworld.practice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SingletonService {

    private Singleton singleton;

    public SingletonService(Singleton singleton) {
        this.singleton = singleton;
    }

    public void test1() {
        log.info("싱글톤 네임 = {}", singleton.getName());
        log.info("싱글톤 카운트 = {}", singleton.getCount());
        singleton.rename();
        singleton.addCount();
    }

    public void test2() {
        log.info("싱글톤 네임 = {}", singleton.getName());
        log.info("싱글톤 카운트 = {}", singleton.getCount());
    }

}
