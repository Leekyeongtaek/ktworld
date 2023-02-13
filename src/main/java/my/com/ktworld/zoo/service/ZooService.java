package my.com.ktworld.zoo.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import my.com.ktworld.zoo.dto.request.ZookeeperForm;
import my.com.ktworld.zoo.entity.Zookeeper;
import my.com.ktworld.zoo.repository.ZookeeperRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ZooService {

    private final ZookeeperRepository zookeeperRepository;

    @Transactional
    public void createZookeeper(ZookeeperForm zookeeperForm) {
        Zookeeper zookeeper = Zookeeper.createZookeeper(zookeeperForm);
        zookeeperRepository.save(zookeeper);
    }

    @Transactional
    public void updateZookeeper(ZookeeperForm zookeeperForm) {
        Optional<Zookeeper> zookeeper = zookeeperRepository.findById(zookeeperForm.getZookeeperId());
        if (zookeeper.isPresent()) {
            zookeeper.get().updateZookeeper(zookeeperForm);
        } else {
            throw new NoSuchElementException("해당하는 사육사 정보를 찾을 수 없습니다.");
        }
    }

}
