package com.donaldwu.main.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private Long user_id;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;
}
