package com.jb.tass.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
//Created by sniryosefof on 30 יוני
public enum SecMsg {
    EMAIL_EXIST("email already exist", HttpStatus.CONFLICT),
    INVALID_TOKEN("invalid token", HttpStatus.UNAUTHORIZED),
    EMAIL_OR_PASSWORD_INCORRECT("email or password incorrect", HttpStatus.UNAUTHORIZED);
    private String msg;
    private HttpStatus status;

    SecMsg(String msg, HttpStatus status) {
        this.msg=msg;
        this.status=status;
    }
}
