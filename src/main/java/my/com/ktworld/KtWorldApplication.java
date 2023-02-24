package my.com.ktworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KtWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(KtWorldApplication.class, args);
    }
}
