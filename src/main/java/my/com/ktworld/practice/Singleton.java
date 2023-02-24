package my.com.ktworld.practice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Singleton {

    private String name = "나비다옹";
    private int count = 1;

    public void rename() {
        this.name = "방울이다옹~";
    }

    public void addCount() {
        this.count = 10;
    }
}
