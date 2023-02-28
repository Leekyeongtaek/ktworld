package my.com.ktworld.practice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/validation")
@RestController
public class ValidationController {

    @PostMapping("/test1")
    public Object test1(@Validated @ModelAttribute SaveItem saveItem, BindingResult bindingResult) {

        log.info("진입...");

//        if (saveItem.getQuantity() < 100) {
//            bindingResult.reject("totalQuantityTwo", new Object[]{100}, null);
//            return bindingResult.getAllErrors();
//        }

        return bindingResult.getAllErrors();
    }

}
