package com.jb.tass.repository;

import com.jb.tass.bean.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

//Created by sniryosefof on 29 יוני
public interface TaasRepository extends JpaRepository<Task,Integer> {
    List<Task> findByOrderByWhenAsc();
    List<Task> findByOrderByWhenDesc();
    List<Task> findAllByWhenBetween(Timestamp startDate, Timestamp endDate);
    List<Task> findByUserId(int userId);
}

