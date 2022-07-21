package com.jb.tass.service;

import com.jb.tass.dto.TaskDto;
import com.jb.tass.dto.UserDto;
import com.jb.tass.mapper.TaskMapper;
import com.jb.tass.mapper.UserMapper;
import com.jb.tass.repository.TaasRepository;
import com.jb.tass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//Created by sniryosefof on 30 יוני
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
    private final UserRepository userRepository;
    private final TaasRepository taasRepository;
    private TaskMapper taskMapper;
    private UserMapper userMapper;

    @Override
    public int countUsers() {
        return (int) userRepository.count();
    }

    @Override
    public int countTasks() {
        return (int) taasRepository.count();
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskMapper.toDtoList(taasRepository.findAll());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }
}
