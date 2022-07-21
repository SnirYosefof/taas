package com.jb.tass.controller;

import com.jb.tass.dto.LoginReqDto;
import com.jb.tass.dto.LoginResDto;
import com.jb.tass.dto.RegisterReqDto;
import com.jb.tass.exception.TaskSecurityException;
import com.jb.tass.exception.TaskSystemException;
import com.jb.tass.service.WelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

//Created by sniryosefof on 30 יוני
@RestController
@RequestMapping("/api/welcome")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WelComeController {


    private final WelcomeService welcomeService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegisterReqDto registerReqDto) throws TaskSecurityException, TaskSystemException {
        String email = registerReqDto.getEmail();
        String password = registerReqDto.getPassword();
        welcomeService.register(email, password);

    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResDto login(@Valid @RequestBody LoginReqDto loginReqDto) throws TaskSecurityException {
        String email = loginReqDto.getEmail();
        String password = loginReqDto.getPassword();
        UUID token = welcomeService.login(email, password);
        return new LoginResDto(token,email);
    }

}
