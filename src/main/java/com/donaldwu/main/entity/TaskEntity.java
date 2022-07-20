package com.donaldwu.main.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Data
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    @Column(name="task_message")
    private String taskMessage;

    @Column(name="user_id")
    private Long userId;
}
