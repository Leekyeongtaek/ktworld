package my.com.ktworld.zoo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZookeeperForm {

    private Long zookeeperId;
    private String name;
    private int age;
    private int salary;
}
