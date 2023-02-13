package my.com.ktworld;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.com.ktworld.member.dto.request.AddressForm;
import my.com.ktworld.member.dto.request.MemberForm;
import my.com.ktworld.member.entity.Member;
import my.com.ktworld.member.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.createMembers();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    public static class InitService {

        private final MemberRepository memberRepository;

        public void createMembers() {
            List<Member> members = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                MemberForm memberForm = new MemberForm();
                memberForm.setUserId("userId" + (i+1));
                memberForm.setPassword("1234");
                memberForm.setEmail("email" + (i+1) + "naver.com");
                memberForm.setBirthDate("900520");
                memberForm.setAddress(new AddressForm("서울 특별시", "관악구"));
                memberForm.setPhoneNumber("01012345678");
                members.add(Member.createMember(memberForm));
            }

            memberRepository.saveAll(members);
        }
    }

}
