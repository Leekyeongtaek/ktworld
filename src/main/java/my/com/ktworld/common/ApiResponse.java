package my.com.ktworld.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String FAIL = "fail";

    private String status;
    private T data;
    private ApiError error;

    public static <T> ApiResponse<T> createSuccess(T data) {
        return new ApiResponse<>(SUCCESS, data, null);
    }

    public static ApiResponse<?> createSuccessNoData() {
        return new ApiResponse<>(SUCCESS, null, null);
    }

    public ApiResponse(String status, T data, ApiError error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static class ApiError {

        private String errorMsg;
    }
}
