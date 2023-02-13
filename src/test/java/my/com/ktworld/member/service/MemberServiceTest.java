package my.com.ktworld.member.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import my.com.ktworld.member.dto.request.AddressForm;
import my.com.ktworld.member.dto.request.MemberForm;
import my.com.ktworld.member.entity.Member;
import my.com.ktworld.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    //todo 데이터 베이스 설정(유니크 키 등.)

    @BeforeEach
    public void setUpMembers() {
        MemberForm memberForm = MemberForm.builder()
            .userId("lkt0520")
            .password("1234")
            .email("lkt0520@naver.com")
            .phoneNumber("01083757825")
            .birthDate("19900520")
            .address(new AddressForm("서울 특별시", "관악구"))
            .build();

        memberRepository.save(Member.createMember(memberForm));
    }

    @Test
    @DisplayName("회원 가입")
    public void saveMemberTest() {
        MemberForm memberForm = MemberForm.builder()
            .userId("test1")
            .password("1234")
            .email("test@naver.com")
            .phoneNumber("01012345678")
            .birthDate("19900520")
            .address(new AddressForm("서울 특별시", "관악구"))
            .build();

        Member member = Member.createMember(memberForm);
        Member savedMember = memberRepository.save(member);

        assertThat(member).isEqualTo(savedMember);
    }

    @Test
    @DisplayName("회원 정보 수정")
    public void updateMemberTest() {
        Optional<Member> findMember = memberRepository.findById(1L);
    }

    @Test
    @DisplayName("회원 정보 조회.")
    public void selectMemberInfo() {
        Optional<Member> findMember = memberRepository.findById(1L);
        findMember.ifPresent(member -> assertThat(member.getUserId()).isEqualTo("lkt0520"));
    }

}