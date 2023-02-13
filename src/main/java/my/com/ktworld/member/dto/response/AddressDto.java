package my.com.ktworld.member.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.com.ktworld.member.entity.Address;

@NoArgsConstructor
@Getter
@Setter
public class AddressDto {

    private String city;
    private String streets;

    public static AddressDto toDto(Address address) {
        AddressDto dto = new AddressDto();
        dto.setCity(address.getCity());
        dto.setStreets(address.getStreets());

        return dto;
    }
}
