package com.jb.tass.controller;

import com.jb.tass.dto.TaskDto;
import com.jb.tass.dto.UserDto;
import com.jb.tass.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Created by sniryosefof on 30 יוני
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    @GetMapping("/tasks/count")
    public int countTasks(){
        return adminService.countTasks();
    }
    @GetMapping("/users/count")
    public int countUsers(){
        return adminService.countUsers();
    }
    @GetMapping("/users")
    public List<UserDto> getAllUsers(){
        return adminService.getAllUsers();
    }
    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks(){
        return adminService.getAllTasks();
    }
}
