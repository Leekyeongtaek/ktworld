package my.com.ktworld.zoo.entity;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import lombok.Getter;
import my.com.ktworld.common.BaseTime;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Getter
@Entity
public abstract class Animal extends BaseTime {

    @Id
    @GeneratedValue
    @Column(name = "animal_id")
    private Long id;
    private String name;
    private String feature;
    private int age;
    private int weight;
    private long price;

    @ManyToOne(fetch = LAZY)
    private Zookeeper zookeeper;

    //todo 공통 추상 기능.
    //todo 공통 기능. private, protected, public

}
