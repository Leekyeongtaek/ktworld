package my.com.ktworld.zoo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.com.ktworld.common.BaseTime;
import my.com.ktworld.zoo.dto.request.ZookeeperForm;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Zookeeper extends BaseTime {

    @Id
    @GeneratedValue
    @Column(name = "zookeeper_id")
    private Long id;
    private String name;
    private int age;
    private int salary;

    @OneToMany(mappedBy = "zookeeper")
    private List<Animal> animals = new ArrayList<>();

    public static Zookeeper createZookeeper(ZookeeperForm zookeeperForm) {
        Zookeeper zookeeper = new Zookeeper();
        zookeeper.name = zookeeperForm.getName();
        zookeeper.salary = zookeeperForm.getSalary();
        zookeeper.age = zookeeperForm.getAge();

        return zookeeper;
    }

    public void updateZookeeper(ZookeeperForm zookeeperForm) {
        name = zookeeperForm.getName();
        age = zookeeperForm.getAge();
        salary = zookeeperForm.getSalary();
    }

}
