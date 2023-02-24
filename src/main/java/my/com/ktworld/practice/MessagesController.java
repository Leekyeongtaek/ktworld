package my.com.ktworld.practice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MessagesController {

    private final MessageSource messageSource;

    @GetMapping("/msg")
    public String testMessage(ModelAndView modelAndView) {
        String hello = messageSource.getMessage("hello", null, null);
        log.info("메시지={}", hello);
        modelAndView.addObject("hello", hello);
        return "/hello";

    }

}
