package my.com.ktworld.zoo.repository.animal;

import my.com.ktworld.zoo.dto.request.AnimalSearchCondition;
import my.com.ktworld.zoo.dto.response.AnimalDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimalRepositoryCustom {

    Page<AnimalDto> searchAnimals(AnimalSearchCondition condition, Pageable pageable);
}
