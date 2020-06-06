package com.donaldwu.main.service;

import com.donaldwu.main.entity.UserEntity;
import com.donaldwu.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(UserEntity userEntity, String username) {
        Long id = userEntity.getUser_id();
        if (id != null) {
            Optional<UserEntity> user = userRepository.findById(id);
            if (!user.isPresent()) {
                userEntity.setUsername(username);
                userRepository.save(userEntity);
            }
        } else {
            userEntity.setUsername(username);
            userRepository.save(userEntity);
        }
    }

    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    public UserEntity getLastUser() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.get(userEntities.size() - 1);
    }

    public UserEntity getUserByUsername(String username) {
        UserEntity userEntityResult = null;

        List<UserEntity> userEntities = userRepository.findAll();
        if (!userEntities.isEmpty()) {
            for (UserEntity userEntity : userEntities) {
                String usernameFromDB = userEntity.getUsername();
                if (usernameFromDB.equals(username)) {
                    userEntityResult = userEntity;
                }
            }
        }
        return userEntityResult;
    }
}
