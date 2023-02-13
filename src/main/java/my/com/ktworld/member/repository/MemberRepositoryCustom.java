package my.com.ktworld.member.repository;

import my.com.ktworld.member.dto.request.MemberSearchCondition;
import my.com.ktworld.member.dto.response.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

    Page<MemberDto> searchMembers(MemberSearchCondition condition, Pageable pageable);
}
