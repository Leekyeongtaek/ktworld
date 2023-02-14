package my.com.ktworld.zoo.dto.request;

import lombok.Getter;
import lombok.Setter;
import my.com.ktworld.zoo.entity.AnimalTypes;

@Getter
@Setter
public class AnimalForm {

    private Long animalId;
    private String name;
    private String description;
    private long price;
    private int age;
    private AnimalTypes animalTypes;
}
