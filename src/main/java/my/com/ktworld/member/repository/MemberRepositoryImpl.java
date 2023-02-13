package my.com.ktworld.member.repository;

import static my.com.ktworld.member.entity.QMember.member;
import static org.springframework.util.StringUtils.hasText;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import my.com.ktworld.member.dto.request.MemberSearchCondition;
import my.com.ktworld.member.dto.response.MemberDto;
import my.com.ktworld.member.dto.response.QMemberDto;
import my.com.ktworld.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@Slf4j
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<MemberDto> searchMembers(MemberSearchCondition condition, Pageable pageable) {
        List<MemberDto> content = queryFactory
            .select(new QMemberDto(
                member.id,
                member.userId,
                member.email,
                member.phoneNumber,
                member.birthDate,
                member.address))
            .from(member)
            .where(userIdEq(condition.getUserId()),
                emailEq(condition.getEmail()),
                phoneNumberEq(condition.getPhoneNumber()))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        Long total = queryFactory
            .select(member.count())
            .from(member)
            .fetchOne();

        log.info("totalCount={}", total);

        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression userIdEq(String userId) {
        return hasText(userId) ? member.userId.eq(userId) : null;
    }

    private BooleanExpression emailEq(String email) {
        return hasText(email) ? member.email.eq(email) : null;
    }

    private BooleanExpression phoneNumberEq(String phoneNumber) {
        return hasText(phoneNumber) ? member.phoneNumber.eq(phoneNumber) : null;
    }

}
