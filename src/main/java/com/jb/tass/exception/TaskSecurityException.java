package com.jb.tass.exception;

import lombok.Data;

//Created by sniryosefof on 30 יוני
@Data
public class TaskSecurityException extends Exception{

    private SecMsg secMsg;
    public TaskSecurityException(SecMsg secMsg) {
        super(secMsg.getMsg());
        this.secMsg=secMsg;
    }
}
