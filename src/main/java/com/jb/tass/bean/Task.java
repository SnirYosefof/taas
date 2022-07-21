package com.jb.tass.bean;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

//Created by sniryosefof on 27 יוני
@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false ,name="task_group")
    private String group;
    @Column(name="task_when" )
    private Timestamp when;
    @ManyToOne
    @ToString.Exclude
    private User user;
}
