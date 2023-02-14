package my.com.ktworld.zoo.dto.response;

import lombok.Getter;
import lombok.Setter;
import my.com.ktworld.zoo.entity.Zookeeper;

@Getter
@Setter
public class ZookeeperDto {

    private Long id;
    private String name;
    private int age;
    private int salary;

    public static ZookeeperDto toDto(Zookeeper zookeeper) {
        ZookeeperDto zookeeperDto = new ZookeeperDto();
        zookeeperDto.setId(zookeeper.getId());
        zookeeperDto.setName(zookeeper.getName());
        zookeeperDto.setAge(zookeeper.getAge());
        zookeeperDto.setSalary(zookeeper.getSalary());

        return zookeeperDto;
    }
}
