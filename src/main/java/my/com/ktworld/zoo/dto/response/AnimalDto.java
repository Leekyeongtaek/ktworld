package my.com.ktworld.zoo.dto.response;

import lombok.Getter;
import lombok.Setter;
import my.com.ktworld.zoo.entity.Animal;
import my.com.ktworld.zoo.entity.AnimalTypes;

@Getter
@Setter
public class AnimalDto {

    private Long id;
    private String name;
    private String description;
    private long price;
    private int age;
    private AnimalTypes animalTypes;

    public static AnimalDto toDto(Animal animal) {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(animal.getId());
        animalDto.setName(animal.getName());
        animalDto.setAge(animal.getAge());
        animalDto.setPrice(animal.getPrice());
        animalDto.setDescription(animal.getDescription());
        animalDto.setAnimalTypes(animal.getAnimalTypes());

        return animalDto;
    }
}
