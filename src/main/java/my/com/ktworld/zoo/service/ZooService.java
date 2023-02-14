package my.com.ktworld.zoo.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import my.com.ktworld.common.ApiResponse;
import my.com.ktworld.zoo.dto.request.AnimalForm;
import my.com.ktworld.zoo.dto.request.ZookeeperForm;
import my.com.ktworld.zoo.dto.response.AnimalDto;
import my.com.ktworld.zoo.entity.Animal;
import my.com.ktworld.zoo.entity.Zookeeper;
import my.com.ktworld.zoo.repository.AnimalRepository;
import my.com.ktworld.zoo.repository.ZookeeperRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ZooService {

    private final ZookeeperRepository zookeeperRepository;
    private final AnimalRepository animalRepository;

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

    @Transactional
    public void createAnimal(AnimalForm animalForm) {
        Animal animal = new Animal(animalForm);
        animalRepository.save(animal);
    }

    @Transactional
    public void updateAnimal(AnimalForm animalForm) {
        Optional<Animal> animal = animalRepository.findById(animalForm.getAnimalId());
        if (animal.isPresent()) {
            animal.get().updateAnimal(animalForm);
        } else {
            throw new NoSuchElementException("해당하는 동물 정보를 찾을 수 없습니다.");
        }
    }

    public ApiResponse<AnimalDto> selectAnimal(Long animalId) {
        Optional<Animal> animal = animalRepository.findById(animalId);
        if (animal.isPresent()) {
            return ApiResponse.createSuccess(AnimalDto.toDto(animal.get()));
        } else {
            throw new NoSuchElementException("해당하는 동물 정보를 찾을 수 없습니다.");
        }
    }

}
