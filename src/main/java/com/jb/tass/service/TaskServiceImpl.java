package com.jb.tass.service;

import com.jb.tass.dto.TaskDto;
import com.jb.tass.bean.Task;
import com.jb.tass.exception.ErrMsg;
import com.jb.tass.exception.TaskSystemException;
import com.jb.tass.mapper.TaskMapper;
import com.jb.tass.repository.TaasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

//Created by sniryosefof on 29 יוני
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaasRepository taasRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskDto addTask(TaskDto taskDto) throws TaskSystemException {
        if (taasRepository.existsById(taskDto.getId())) {
            throw new TaskSystemException(ErrMsg.ID_ALREADY_EXIST);
        }
        Task task = taskMapper.toDao(taskDto);
        return taskMapper.toDto(taasRepository.save(task));
    }

    @Override
    public TaskDto updateTask(int taskId, TaskDto taskDto) throws TaskSystemException {
        taskDto.setId(taskId);
        if (!taasRepository.existsById(taskId)) {
            throw new TaskSystemException(ErrMsg.ID_NOT_EXIST);
        }
        Task task = taskMapper.toDao(taskDto);
        return taskMapper.toDto( taasRepository.saveAndFlush(task));
    }

    @Override
    public void deleteTask(int taskId) throws TaskSystemException {
        if(!taasRepository.existsById(taskId)){
            throw new TaskSystemException(ErrMsg.ID_NOT_EXIST);
        }
        taasRepository.deleteById(taskId);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskMapper.toDtoList(taasRepository.findAll());
    }

    @Override
    public TaskDto getOneTask(int taskId) throws TaskSystemException {
        return taskMapper.toDto(taasRepository.findById(taskId).orElseThrow(()->new TaskSystemException(ErrMsg.ID_NOT_EXIST)));
    }

    @Override
    public int count() {
        return (int) taasRepository.count();
    }

    @Override
    public List<TaskDto> getAllTasksOrderByTimeAsc() {
        return taskMapper.toDtoList(taasRepository.findByOrderByWhenAsc());
    }

    @Override
    public List<TaskDto> getAllTasksOrderByTimeDesc() {
        return taskMapper.toDtoList(taasRepository.findByOrderByWhenDesc());
    }

    @Override
    public List<TaskDto> getAllTasksBetween(Timestamp startDate, Timestamp endDate) throws TaskSystemException {
        if(endDate.before(startDate)){
            throw new TaskSystemException(ErrMsg.INVALID_DATES);
        }
        return taskMapper.toDtoList(taasRepository.findAllByWhenBetween(startDate, endDate));
    }
}