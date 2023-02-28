package my.com.ktworld.common;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Slf4j
@Getter
public class ErrorResponse {

    List<InError> errors = new ArrayList<>();

    public void createErrors(BindingResult bindingResult) {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
            InError inError = new InError();
            inError.setErrorCode(error.getCode());
            inError.setErrorMsg(error.getDefaultMessage());
            errors.add(inError);
        }
    }

    @Setter
    @Getter
    static class InError {

        private String errorCode;
        private String errorMsg;
    }
}
