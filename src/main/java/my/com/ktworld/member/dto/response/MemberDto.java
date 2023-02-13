package my.com.ktworld.member.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.com.ktworld.member.entity.Address;
import my.com.ktworld.member.entity.Member;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private long memberId;
    private String userId;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private AddressDto address;

    @QueryProjection
    public MemberDto(long memberId, String userId, String email, String phoneNumber, String birthDate,
        Address address) {
        this.memberId = memberId;
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = AddressDto.toDto(address);
    }

    public static MemberDto toDto(Member member) {
        MemberDto dto = new MemberDto();
        dto.setMemberId(member.getId());
        dto.setUserId(member.getUserId());
        dto.setEmail(member.getEmail());
        dto.setPhoneNumber(member.getPhoneNumber());
        dto.setBirthDate(member.getBirthDate());
        dto.setAddress(AddressDto.toDto(member.getAddress()));

        return dto;
    }
}
