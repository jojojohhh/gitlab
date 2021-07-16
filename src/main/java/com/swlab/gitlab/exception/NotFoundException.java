package com.swlab.gitlab.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final int status;

    public NotFoundException(int status, String message) {
        super(message);
        this.status = status;
    }
}
