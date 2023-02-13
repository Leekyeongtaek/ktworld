package my.com.ktworld.zoo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Getter;
import my.com.ktworld.common.BaseTime;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Getter
@Entity
public abstract class Animal extends BaseTime {

    @Id @GeneratedValue
    @Column(name = "animal_id")
    private Long id;
    private String name;
    private int age;
    private long price;

    //사육사 관계 설정.

    //공통 메서드.
}
