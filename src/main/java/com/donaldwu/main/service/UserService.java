package com.donaldwu.main.service;

import com.donaldwu.main.model.User;
import com.donaldwu.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User userEntity, String username) {
        Long id = userEntity.getUser_id();
        if (id != null) {
            Optional<User> user = userRepository.findById(id);
            if (user.isEmpty()) {
                userEntity.setUsername(username);
                userRepository.save(userEntity);
            }
        } else {
            userEntity.setUsername(username);
            userRepository.save(userEntity);
        }
    }

    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getLastUser() {
        List<User> userList = new ArrayList<>();

        Iterable<User> userEntities = userRepository.findAll();
        userEntities.forEach(userList::add);

        return userList.get(userList.size() - 1);
    }

    public User getUserByUsername(String username) {
        User userResult = null;

        List<User> userList = new ArrayList<>();

        Iterable<User> userEntities = userRepository.findAll();
        userEntities.forEach(userList::add);

        if (!userList.isEmpty()) {
            for (User user : userList) {
                String usernameFromDB = user.getUsername();
                if (usernameFromDB.equals(username)) {
                    userResult = user;
                }
            }
        }
        return userResult;
    }
}
