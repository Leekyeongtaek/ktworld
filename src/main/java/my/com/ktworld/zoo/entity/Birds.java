package my.com.ktworld.zoo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;

@DiscriminatorValue("B")
@Getter
@Entity
public class Birds extends Animal {

}
