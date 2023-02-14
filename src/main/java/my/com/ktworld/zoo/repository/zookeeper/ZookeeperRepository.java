package my.com.ktworld.zoo.repository.zookeeper;

import my.com.ktworld.zoo.entity.Zookeeper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZookeeperRepository extends JpaRepository<Zookeeper, Long>, ZookeeperRepositoryCustom {

}
