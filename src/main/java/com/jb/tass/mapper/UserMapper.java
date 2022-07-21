package com.jb.tass.mapper;

import com.jb.tass.dto.UserDto;
import com.jb.tass.bean.ClientType;
import com.jb.tass.bean.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//Created by sniryosefof on 30 יוני
@Component
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserDto> {

    private final TaskMapper taskMapper;
    @Override
    public User toDao(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .type(ClientType.valueOf(userDto.getType()))
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .tasks(taskMapper.toDaoList(userDto.getTasks()))
                .build();
    }

    @Override
    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .type(user.getType().name())
                .email(user.getEmail())
                .password(user.getPassword())
                .tasks(taskMapper.toDtoList(user.getTasks()))
                .build();
    }

    @Override
    public List<User> toDaoList(List<UserDto> userDtos) {
        return userDtos.stream().map(this::toDao).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> toDtoList(List<User> userDaos) {
        return userDaos.stream().map(this::toDto).collect(Collectors.toList());
    }
}