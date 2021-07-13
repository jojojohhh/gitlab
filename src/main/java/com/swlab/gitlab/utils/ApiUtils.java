package com.swlab.gitlab.utils;

public class ApiUtils {

    public static <T>ApiResult<T> success(T res) {
        return new ApiResult<>(true, res, null);
    }

    public static ApiResult<?> error(String msg, int status) {
        return new ApiResult<>(false, null, new ApiError(msg, status));
    }
}
