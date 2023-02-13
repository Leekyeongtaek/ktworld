package my.com.ktworld.zoo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;

@DiscriminatorValue("M")
@Getter
@Entity
public class Mammal extends Animal {


}
