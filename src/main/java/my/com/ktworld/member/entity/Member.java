package my.com.ktworld.member.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.com.ktworld.member.dto.request.MemberForm;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String userId;
    private String password;
    private String email;
    private String phoneNumber;
    private String birthDate;
    @Embedded
    private Address address;

    public static Member createMember(MemberForm memberForm) {
        Member member = new Member();
        member.userId = memberForm.getUserId();
        member.password = memberForm.getPassword();
        member.email = memberForm.getEmail();
        member.phoneNumber = memberForm.getPhoneNumber();
        member.birthDate = memberForm.getBirthDate();
        member.address = new Address(memberForm.getAddress());

        return member;
    }

    public void updateMember(MemberForm memberForm) {
        password = memberForm.getPassword();
        email = memberForm.getEmail();
        phoneNumber = memberForm.getPhoneNumber();
        birthDate = memberForm.getBirthDate();
        address = new Address(memberForm.getAddress());
    }

}
