package my.com.ktworld.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MemberForm {

    private long memberId;
    private String userId;
    private String password;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private AddressForm address;
}
