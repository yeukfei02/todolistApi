package com.donaldwu.main.responsebody;

import com.donaldwu.main.entity.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class GetAllUserResponseBody {
    private String message;
    private List<UserEntity> users;
}
