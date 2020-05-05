package com.donaldwu.main.service;

import com.donaldwu.main.entity.UserEntity;
import com.donaldwu.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(UserEntity userEntity, String username) {
        Optional<UserEntity> user = userRepository.findById(userEntity.getId());
        if (!user.isPresent()) {
            userEntity.setUsername(username);
            userRepository.save(userEntity);
        }
    }
}
