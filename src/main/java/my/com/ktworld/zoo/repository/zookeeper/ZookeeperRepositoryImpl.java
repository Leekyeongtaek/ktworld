package my.com.ktworld.zoo.repository.zookeeper;

import static my.com.ktworld.zoo.entity.QZookeeper.zookeeper;
import static org.springframework.util.StringUtils.hasText;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import my.com.ktworld.zoo.dto.request.ZookeeperSearchCondition;
import my.com.ktworld.zoo.dto.response.QZookeeperDto;
import my.com.ktworld.zoo.dto.response.ZookeeperDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class ZookeeperRepositoryImpl implements ZookeeperRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ZookeeperRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<ZookeeperDto> searchZookeepers(ZookeeperSearchCondition condition, Pageable pageable) {
        List<ZookeeperDto> content = queryFactory
            .select(
                new QZookeeperDto(
                    zookeeper.id,
                    zookeeper.name,
                    zookeeper.age,
                    zookeeper.salary))
            .from(zookeeper)
            .where(nameEq(condition.getName()))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        Long total = queryFactory
            .select(zookeeper.count())
            .from(zookeeper)
            .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression nameEq(String name) {
        return hasText(name) ? zookeeper.name.eq(name) : null;
    }

}
