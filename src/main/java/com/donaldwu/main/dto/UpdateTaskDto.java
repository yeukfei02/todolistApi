package com.donaldwu.main.dto;

import lombok.Data;

@Data
public class UpdateTaskDto {
    private String taskMessage;
    private Long user_id;
}
