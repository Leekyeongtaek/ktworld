package my.com.ktworld.zoo.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.com.ktworld.zoo.entity.Animal;
import my.com.ktworld.zoo.entity.AnimalTypes;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class AnimalDto {

    private Long id;
    private String name;
    private String description;
    private long price;
    private int age;
    private AnimalTypes animalTypes;

    @QueryProjection
    public AnimalDto(Long id, String name, String description, long price, int age, AnimalTypes animalTypes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.age = age;
        this.animalTypes = animalTypes;
    }

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
