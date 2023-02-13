package my.com.ktworld.zoo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;

@DiscriminatorValue("R")
@Getter
@Entity
public class Reptile extends Animal {

}
