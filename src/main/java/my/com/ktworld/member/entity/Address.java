package my.com.ktworld.member.entity;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.com.ktworld.member.dto.request.AddressForm;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class Address {

    private String city;
    private String streets;

    public Address(AddressForm dto) {
        this.city = dto.getCity();
        this.streets = dto.getStreets();
    }
}
