package com.jb.tass.security;

import com.jb.tass.bean.User;
import com.jb.tass.exception.SecMsg;
import com.jb.tass.exception.TaskSecurityException;
import com.jb.tass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

//Created by sniryosefof on 30 יוני
@Service
@RequiredArgsConstructor
public class TokenManager {
    private final Map<UUID, Information> map;
    private final UserRepository userRepository;

    public UUID add(String email, String password) {
        User fromDb = userRepository.findTop1ByEmail(email);
        int userId = fromDb.getId();
        System.out.println(userId);
        removePreviousInstances(userId);
        Information information = new Information();
        information.setUserId(userId);
        information.setEmail(email);
        information.setType(fromDb.getType());
        information.setTime(LocalDateTime.now());


        UUID token = UUID.randomUUID();

        map.put(token, information);

        return token;


    }


    public int getUserId(UUID token){
        Information information=map.get(token);
        if (information==null){
            throw new SecurityException(SecMsg.INVALID_TOKEN.getMsg());
        }
        return information.getUserId();
    }

    @Scheduled(fixedRate = 1000 * 60*30)
    public void deleteExpiredTokenOver30Minutes() {
        map.entrySet().removeIf(ins -> ins.getValue().getTime().isAfter(LocalDateTime.now().minusMinutes(30)));
    }

    public void removePreviousInstances(int userId){
        map.entrySet().removeIf(ins-> ins.getValue().getUserId()==userId);
    }

}