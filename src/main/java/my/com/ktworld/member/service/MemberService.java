package my.com.ktworld.member.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import my.com.ktworld.common.ApiResponse;
import my.com.ktworld.member.dto.request.MemberForm;
import my.com.ktworld.member.dto.request.MemberSearchCondition;
import my.com.ktworld.member.dto.response.MemberDto;
import my.com.ktworld.member.entity.Member;
import my.com.ktworld.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(MemberForm memberForm) {
        memberRepository.save(Member.createMember(memberForm));
    }

    @Transactional
    public void updateMember(MemberForm memberForm) {
        Optional<Member> member = memberRepository.findById(memberForm.getMemberId());
        if (member.isPresent()) {
            member.get().updateMember(memberForm);
        } else {
            throw new NoSuchElementException("해당하는 회원 정보를 찾을 수 없습니다.");
        }
    }

    public ApiResponse<MemberDto> selectMember(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
//            return ApiResponse.createSuccess(MemberDto.toDto(member.get()))
                return null;
        } else {
            throw new NoSuchElementException("해당하는 회원 정보를 찾을 수 없습니다.");
        }
    }

    public ApiResponse<Page<MemberDto>> searchMembers(MemberSearchCondition condition, Pageable pageable) {
        Page<MemberDto> members = memberRepository.searchMembers(condition, pageable);
        return ApiResponse.createSuccess(members);
    }

}
