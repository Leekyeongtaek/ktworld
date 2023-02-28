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
import my.com.ktworld.zoo.dto.request.ZookeeperForm;
import my.com.ktworld.zoo.dto.request.ZookeeperSave;
import my.com.ktworld.zoo.entity.Zookeeper;
import my.com.ktworld.zoo.repository.zookeeper.ZookeeperRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class InitDB {

    private final InitService initService;

//    @PostConstruct
//    public void init() {
//        initService.createMembers();
//        initService.createZookeepers();
//    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    public static class InitService {

        private final MemberRepository memberRepository;
        private final ZookeeperRepository zookeeperRepository;

        public void createMembers() {
            List<Member> members = new ArrayList<>();
            for (int i = 1; i < 101; i++) {
                MemberForm memberForm = new MemberForm();
                memberForm.setUserId("userId" + i);
                memberForm.setPassword("1234");
                memberForm.setEmail("email" + i + "naver.com");
                memberForm.setBirthDate("900520");
                memberForm.setAddress(new AddressForm("서울 특별시", "관악구"));
                memberForm.setPhoneNumber("01012345678");
                members.add(Member.createMember(memberForm));
            }

            memberRepository.saveAll(members);
        }

        public void createZookeepers() {
            List<Zookeeper> zookeepers = new ArrayList<>();
            for (int i = 1; i < 101; i++) {
                ZookeeperSave zookeeperSave = new ZookeeperSave();
                zookeeperSave.setName("사육사" + i);
                zookeeperSave.setAge(i);
                zookeeperSave.setSalary(10000 + i);
                zookeepers.add(Zookeeper.createZookeeper(zookeeperSave));
            }
            zookeeperRepository.saveAll(zookeepers);
        }

    }

}
