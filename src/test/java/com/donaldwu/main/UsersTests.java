package com.donaldwu.main;

import com.donaldwu.main.entity.UserEntity;
import com.donaldwu.main.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
public class UsersTests {
    private static final Logger logger = Logger.getLogger(UsersTests.class.toString());

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_001_createUser() {
        logger.info("test_001_createUser start");

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test123123");
        userRepository.save(userEntity);

        List<UserEntity> userList = new ArrayList<>();

        Iterable<UserEntity> userEntities = userRepository.findAll();
        userEntities.forEach(userList::add);

        UserEntity lastUser = userList.get(userList.size() - 1);
        if (lastUser != null) {
            Long userId = lastUser.getUser_id();
            String username = lastUser.getUsername();
            Assertions.assertNotNull(userId, "userId should not be null");
            Assertions.assertNotNull(username, "username should not be null");
            Assertions.assertEquals("test123123", username);
        }
    }

    @Test
    public void test_002_getAllUser() {
        logger.info("test_002_getAllUser start");

        List<UserEntity> userList = new ArrayList<>();

        Iterable<UserEntity> userEntities = userRepository.findAll();
        userEntities.forEach(userList::add);

        if (!userList.isEmpty()) {
            for (UserEntity	userEntity : userList) {
                Long userId = userEntity.getUser_id();
                String username = userEntity.getUsername();
                Assertions.assertNotNull(userId, "userId should not be null");
                Assertions.assertNotNull(username, "username should not be null");
            }
        }
    }
}
