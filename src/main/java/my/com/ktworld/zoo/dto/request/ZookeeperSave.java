package my.com.ktworld.zoo.dto.request;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class ZookeeperSave {

    @NotEmpty(message = "{zookeeper.name}")
    private String name;

    @Range(min = 20, max = 60)
    private int age;

    @Range(min = 3000, max = 10000)
    private int salary;
}
