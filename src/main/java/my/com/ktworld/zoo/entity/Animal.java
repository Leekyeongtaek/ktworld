package my.com.ktworld.zoo.entity;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.com.ktworld.common.BaseTime;
import my.com.ktworld.zoo.dto.request.AnimalForm;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Animal extends BaseTime {

    @Id
    @GeneratedValue
    @Column(name = "animal_id")
    private Long id;
    private String name;
    private String description;
    private long price;
    private int age;
    @Enumerated(EnumType.STRING)
    private AnimalTypes animalTypes;

    @ManyToOne(fetch = LAZY)
    private Zookeeper zookeeper;

    public Animal(AnimalForm animalForm) {
        this.name = animalForm.getName();
        this.description = animalForm.getDescription();
        this.price = animalForm.getPrice();
        this.age = animalForm.getAge();
        this.animalTypes = animalForm.getAnimalTypes();
    }

    public void updateAnimal(AnimalForm animalForm) {
        this.name = animalForm.getName();
        this.description = animalForm.getDescription();
        this.price = animalForm.getPrice();
        this.age = animalForm.getAge();
    }

}
