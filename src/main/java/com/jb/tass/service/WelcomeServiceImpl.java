package com.jb.tass.service;

import com.jb.tass.bean.ClientType;
import com.jb.tass.bean.User;
import com.jb.tass.exception.SecMsg;
import com.jb.tass.exception.TaskSecurityException;
import com.jb.tass.repository.UserRepository;
import com.jb.tass.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

//Created by sniryosefof on 30 יוני
@Service
@RequiredArgsConstructor
public class WelcomeServiceImpl implements WelcomeService{
    private final UserRepository userRepository;
    private final TokenManager tokenManager;
    @Override
    public void register(String email, String password) throws TaskSecurityException {

        User user = User.builder()
                .email(email)
                .password(password)
                .type(ClientType.USER)
                .build();

        if(userRepository.existsByEmail(email)){
            throw new TaskSecurityException(SecMsg.EMAIL_EXIST);
        }


        userRepository.save(user);
    }

    @Override
    public UUID login(String email, String password) throws TaskSecurityException {
        if(!userRepository.existsByEmailAndPassword(email,password)){
            throw new TaskSecurityException(SecMsg.EMAIL_OR_PASSWORD_INCORRECT);
        }
        return tokenManager.add(email,password);
    }
}
