package com.jb.tass.service;

import com.jb.tass.dto.TaskDto;
import com.jb.tass.bean.Task;
import com.jb.tass.bean.User;
import com.jb.tass.exception.ErrMsg;
import com.jb.tass.exception.TaskSystemException;
import com.jb.tass.mapper.TaskMapper;
import com.jb.tass.repository.TaasRepository;
import com.jb.tass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//Created by sniryosefof on 30 יוני
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final TaasRepository taasRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;

    @Override

    public List<TaskDto> getAllTasks(int userId) {
        return taskMapper.toDtoList(taasRepository.findByUserId(userId));
    }

    @Override
    public void addTask(int userId, TaskDto taskDto) throws TaskSystemException {
        Task toAdd = taskMapper.toDao(taskDto);
        User user = userRepository.findById(userId).orElseThrow(() -> new TaskSystemException(ErrMsg.ID_NOT_EXIST));
        toAdd.setUser(user);

        taasRepository.save(toAdd);
    }

    @Override
    public TaskDto updateTask(int taskId, TaskDto taskDto) throws TaskSystemException {
        taskDto.setId(taskId);
        if (!taasRepository.existsById(taskId)) {
            throw new TaskSystemException(ErrMsg.ID_NOT_EXIST);
        }
        Task task = taskMapper.toDao(taskDto);
        return taskMapper.toDto(taasRepository.saveAndFlush(task));
    }

    @Override
    public void deleteTask(int taskId) throws TaskSystemException {
        if (!taasRepository.existsById(taskId)) {
            throw new TaskSystemException(ErrMsg.ID_NOT_EXIST);
        }
        taasRepository.deleteById(taskId);
    }

    @Override
    public int countById() {
        return (int) userRepository.count();
    }
}