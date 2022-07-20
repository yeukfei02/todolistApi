package com.donaldwu.main;

import com.donaldwu.main.entity.TaskEntity;
import com.donaldwu.main.repository.TaskRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@SpringBootTest
public class TaskTests {
    private static final Logger logger = Logger.getLogger(TaskTests.class.toString());

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void test_001_createTask() {
        logger.info("test_001_createTask start");

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskMessage("taskMessage123");
        taskEntity.setUserId(1L);
        taskRepository.save(taskEntity);

        List<TaskEntity> taskEntities = taskRepository.findAll();
        TaskEntity lastTask = taskEntities.get(taskEntities.size() - 1);
        if (lastTask != null) {
            Long taskId = taskEntity.getTask_id();
            String taskMessage = taskEntity.getTaskMessage();
            Long userId = taskEntity.getUserId();
            Assert.assertNotNull("taskId should not be null", taskId);
            Assert.assertNotNull("taskMessage should not be null", taskMessage);
            Assert.assertNotNull("userId should not be null", userId);
            Assert.assertEquals("taskMessage123", taskMessage);
            Assert.assertEquals(1L, (long) userId);
        }
    }

    @Test
    public void test_002_getAllTask() {
        logger.info("test_002_getAllTask start");

        List<TaskEntity> taskEntities = taskRepository.findAll();
        if (!taskEntities.isEmpty()) {
            for (TaskEntity	taskEntity : taskEntities) {
                Long taskId = taskEntity.getTask_id();
                String taskMessage = taskEntity.getTaskMessage();
                Long userId = taskEntity.getUserId();
                Assert.assertNotNull("taskId should not be null", taskId);
                Assert.assertNotNull("taskMessage should not be null", taskMessage);
                Assert.assertNotNull("userId should not be null", userId);
            }
        }
    }

    @Test
    void test_003_getTaskById() {
        logger.info("test_003_getTaskById start");

        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(1L);
        if (taskEntityOptional.isPresent()) {
            TaskEntity taskEntity = taskEntityOptional.get();
            Long taskId = taskEntity.getTask_id();
            String taskMessage = taskEntity.getTaskMessage();
            Long userId = taskEntity.getUserId();
            Assert.assertNotNull("taskId should not be null", taskId);
            Assert.assertNotNull("taskMessage should not be null", taskMessage);
            Assert.assertNotNull("userId should not be null", userId);
        }
    }

    @Test
    public void test_004_updateTaskById() {
        logger.info("test_004_updateTaskById start");

        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(1L);
        if (taskEntityOptional.isPresent()) {
            TaskEntity taskEntity = taskEntityOptional.get();
            taskEntity.setTaskMessage("taskMessage567");
            taskEntity.setUserId(1L);
            taskRepository.save(taskEntity);

            Long taskId = taskEntity.getTask_id();
            String taskMessage = taskEntity.getTaskMessage();
            Long userId = taskEntity.getUserId();
            Assert.assertNotNull("taskId should not be null", taskId);
            Assert.assertNotNull("taskMessage should not be null", taskMessage);
            Assert.assertNotNull("userId should not be null", userId);
            Assert.assertEquals("taskMessage567", taskMessage);
            Assert.assertEquals(1L, (long) userId);
        }
    }
}
