package my.com.ktworld.member.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSearchCondition {

    private String userId;
    private String email;
    private String phoneNumber;
}
