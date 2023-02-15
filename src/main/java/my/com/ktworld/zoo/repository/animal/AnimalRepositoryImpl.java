package my.com.ktworld.zoo.repository.animal;

import static my.com.ktworld.zoo.entity.QAnimal.animal;
import static org.springframework.util.StringUtils.hasText;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import my.com.ktworld.zoo.dto.request.AnimalSearchCondition;
import my.com.ktworld.zoo.dto.response.AnimalDto;
import my.com.ktworld.zoo.dto.response.QAnimalDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class AnimalRepositoryImpl implements AnimalRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public AnimalRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<AnimalDto> searchAnimals(AnimalSearchCondition condition, Pageable pageable) {
        List<AnimalDto> content = queryFactory.
            select(new QAnimalDto(
                animal.id,
                animal.name,
                animal.description,
                animal.price,
                animal.age,
                animal.animalTypes
            ))
            .from(animal)
            .where(
                nameEq(condition.getName())
            )
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        Long total = queryFactory
            .select(animal.count())
            .from(animal)
            .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression nameEq(String name) {
        return hasText(name) ? animal.name.eq(name) : null;
    }

}
