package com.swlab.gitlab.utils;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiResult<T> {

    private final boolean success;

    private final T res;

    private final ApiError apiError;

    public ApiResult(boolean success, T res, ApiError apiError) {
        this.success = success;
        this.res = res;
        this.apiError = apiError;
    }
}
