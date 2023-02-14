package my.com.ktworld.zoo.repository.animal;

import my.com.ktworld.zoo.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long>, AnimalRepositoryCustom {

}
