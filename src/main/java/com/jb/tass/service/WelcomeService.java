package com.jb.tass.service;

import com.jb.tass.exception.TaskSecurityException;
import com.jb.tass.exception.TaskSystemException;

import java.util.UUID;

//Created by sniryosefof on 30 יוני
public interface WelcomeService {

    void register(String email, String password) throws TaskSystemException, TaskSecurityException;
    UUID login(String email, String password) throws TaskSecurityException;
}
