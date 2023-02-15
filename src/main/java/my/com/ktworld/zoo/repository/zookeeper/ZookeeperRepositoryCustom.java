package my.com.ktworld.zoo.repository.zookeeper;

import my.com.ktworld.zoo.dto.request.ZookeeperSearchCondition;
import my.com.ktworld.zoo.dto.response.ZookeeperDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ZookeeperRepositoryCustom {

    Page<ZookeeperDto> searchZookeepers(ZookeeperSearchCondition condition, Pageable pageable);
}
