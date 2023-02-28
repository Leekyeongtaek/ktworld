package my.com.ktworld.practice;

import javax.validation.constraints.Max;
import lombok.Data;

@Data
public class SaveItem {

    private String itemName;
    private int price;
    @Max(value = 9999)
    private int quantity;
}
