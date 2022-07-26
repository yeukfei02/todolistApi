package com.donaldwu.main;

import com.donaldwu.main.entity.TaskEntity;
import com.donaldwu.main.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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
        taskEntity.setUser_id(1L);
        taskRepository.save(taskEntity);

        List<TaskEntity> taskList = new ArrayList<>();

        Iterable<TaskEntity> taskEntities = taskRepository.findAll();
        taskEntities.forEach(taskList::add);

        TaskEntity lastTask = taskList.get(taskList.size() - 1);
        if (lastTask != null) {
            Long taskId = lastTask.getTask_id();
            String taskMessage = lastTask.getTaskMessage();
            Long userId = lastTask.getUser_id();
            Assertions.assertNotNull(taskId, "taskId should not be null");
            Assertions.assertNotNull(taskMessage, "taskMessage should not be null");
            Assertions.assertNotNull(userId, "userId should not be null");
            Assertions.assertEquals("taskMessage123", taskMessage);
            Assertions.assertEquals(1L, (long) userId);
        }
    }

    @Test
    public void test_002_getAllTask() {
        logger.info("test_002_getAllTask start");

        List<TaskEntity> taskList = new ArrayList<>();

        Iterable<TaskEntity> taskEntities = taskRepository.findAll();
        taskEntities.forEach(taskList::add);

        if (!taskList.isEmpty()) {
            for (TaskEntity	taskEntity : taskList) {
                Long taskId = taskEntity.getTask_id();
                String taskMessage = taskEntity.getTaskMessage();
                Long userId = taskEntity.getUser_id();
                Assertions.assertNotNull(taskId, "taskId should not be null");
                Assertions.assertNotNull(taskMessage, "taskMessage should not be null");
                Assertions.assertNotNull(userId, "userId should not be null");
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
            Long userId = taskEntity.getUser_id();
            Assertions.assertNotNull(taskId, "taskId should not be null");
            Assertions.assertNotNull(taskMessage, "taskMessage should not be null");
            Assertions.assertNotNull(userId, "userId should not be null");
        }
    }

    @Test
    public void test_004_updateTaskById() {
        logger.info("test_004_updateTaskById start");

        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(1L);
        if (taskEntityOptional.isPresent()) {
            TaskEntity taskEntity = taskEntityOptional.get();
            taskEntity.setTaskMessage("taskMessage567");
            taskEntity.setUser_id(1L);
            taskRepository.save(taskEntity);

            Long taskId = taskEntity.getTask_id();
            String taskMessage = taskEntity.getTaskMessage();
            Long userId = taskEntity.getUser_id();
            Assertions.assertNotNull(taskId, "taskId should not be null");
            Assertions.assertNotNull(taskMessage, "taskMessage should not be null");
            Assertions.assertNotNull(userId, "userId should not be null");
            Assertions.assertEquals("taskMessage567", taskMessage);
            Assertions.assertEquals(1L, (long) userId);
        }
    }
}
