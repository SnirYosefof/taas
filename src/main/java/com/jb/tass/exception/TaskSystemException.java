package com.jb.tass.exception;

//Created by sniryosefof on 29 יוני
public class TaskSystemException extends  Exception{

    public TaskSystemException(ErrMsg errMsg) {
        super(errMsg.getMsg());
    }
}
