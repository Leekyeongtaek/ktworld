package my.com.ktworld.member.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressForm {

    private String city;
    private String streets;

    public AddressForm(String city, String streets) {
        this.city = city;
        this.streets = streets;
    }
}
