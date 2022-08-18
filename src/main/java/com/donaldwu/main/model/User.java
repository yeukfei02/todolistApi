package com.donaldwu.main.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name="user_name")
    private String username;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;
}
