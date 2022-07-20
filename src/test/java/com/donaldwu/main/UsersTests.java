package com.donaldwu.main;

import com.donaldwu.main.entity.UserEntity;
import com.donaldwu.main.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

        List<UserEntity> userEntities = userRepository.findAll();
        UserEntity lastUser = userEntities.get(userEntities.size() - 1);
        if (lastUser != null) {
            Long userId = lastUser.getUser_id();
            String username = lastUser.getUsername();
            Assert.assertNotNull("userId should not be null", userId);
            Assert.assertNotNull("username should not be null", username);
            Assert.assertEquals("test123123", username);
        }
    }

    @Test
    public void test_002_getAllUser() {
        logger.info("test_002_getAllUser start");

        List<UserEntity> userEntities = userRepository.findAll();
        if (!userEntities.isEmpty()) {
            for (UserEntity	userEntity : userEntities) {
                Long userId = userEntity.getUser_id();
                String username = userEntity.getUsername();
                Assert.assertNotNull("userId should not be null", userId);
                Assert.assertNotNull("username should not be null", username);
            }
        }
    }
}
