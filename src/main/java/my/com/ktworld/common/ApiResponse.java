package my.com.ktworld.common;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    private String status;
    private T data;


    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> ApiResponse<T> createSuccess(T data) {
        return new ApiResponse<>(SUCCESS, data);
    }

    public static <T> ApiResponse<T> createSuccessWithNoData() {
        return new ApiResponse<>(SUCCESS, null);
    }

//    public static <T> ApiResponse<?> createErrors(BindingResult bindingResult) {
////        log.info("에러={}", bindingResult.getAllErrors());
//        List<ApiError> list = new ArrayList<>();
//        for (ObjectError error : bindingResult.getAllErrors()) {
//            ApiError apiError = new ApiError(error.getDefaultMessage(), error.getCode());
//            list.add(apiError);
//        }
//        return new ApiResponse<>(ERROR, null, list);
//    }
//
//    private ApiResponse(String status, T data, List<ApiError> errors) {
//        this.status = status;
//        this.data = data;
//        this.errors = errors;
//    }

    public static class ApiError {

    }

}
