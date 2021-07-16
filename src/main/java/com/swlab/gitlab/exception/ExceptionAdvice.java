package com.swlab.gitlab.exception;

import com.swlab.gitlab.utils.ApiResult;

import org.gitlab4j.api.GitLabApiException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.swlab.gitlab.utils.ApiUtils.error;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(GitLabApiException.class)
    public ApiResult gitLabApiException(GitLabApiException e) {
        return error(e.getMessage(), e.getHttpStatus());
    }

    @ExceptionHandler(NotFoundException.class)
    public ApiResult notFoundException(NotFoundException e) {
        return error(e.getMessage(), e.getStatus());
    }
}
