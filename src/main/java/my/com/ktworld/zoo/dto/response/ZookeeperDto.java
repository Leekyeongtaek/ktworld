package my.com.ktworld.zoo.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.com.ktworld.zoo.entity.Zookeeper;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class ZookeeperDto {

    private Long id;
    private String name;
    private int age;
    private int salary;

    @QueryProjection
    public ZookeeperDto(Long id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static ZookeeperDto toDto(Zookeeper zookeeper) {
        ZookeeperDto zookeeperDto = new ZookeeperDto();
        zookeeperDto.setId(zookeeper.getId());
        zookeeperDto.setName(zookeeper.getName());
        zookeeperDto.setAge(zookeeper.getAge());
        zookeeperDto.setSalary(zookeeper.getSalary());

        return zookeeperDto;
    }
}
