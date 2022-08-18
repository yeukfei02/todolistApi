package com.donaldwu.main;

import com.donaldwu.main.model.Task;
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

        Task task = new Task();
        task.setTaskMessage("taskMessage123");
        task.setUser_id(1L);
        taskRepository.save(task);

        List<Task> taskList = new ArrayList<>();

        Iterable<Task> taskEntities = taskRepository.findAll();
        taskEntities.forEach(taskList::add);

        Task lastTask = taskList.get(taskList.size() - 1);
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

        List<Task> taskList = new ArrayList<>();

        Iterable<Task> taskEntities = taskRepository.findAll();
        taskEntities.forEach(taskList::add);

        if (!taskList.isEmpty()) {
            for (Task task : taskList) {
                Long taskId = task.getTask_id();
                String taskMessage = task.getTaskMessage();
                Long userId = task.getUser_id();
                Assertions.assertNotNull(taskId, "taskId should not be null");
                Assertions.assertNotNull(taskMessage, "taskMessage should not be null");
                Assertions.assertNotNull(userId, "userId should not be null");
            }
        }
    }

    @Test
    void test_003_getTaskById() {
        logger.info("test_003_getTaskById start");

        Optional<Task> taskEntityOptional = taskRepository.findById(1L);
        if (taskEntityOptional.isPresent()) {
            Task task = taskEntityOptional.get();

            Long taskId = task.getTask_id();
            String taskMessage = task.getTaskMessage();
            Long userId = task.getUser_id();
            Assertions.assertNotNull(taskId, "taskId should not be null");
            Assertions.assertNotNull(taskMessage, "taskMessage should not be null");
            Assertions.assertNotNull(userId, "userId should not be null");
        }
    }

    @Test
    public void test_004_updateTaskById() {
        logger.info("test_004_updateTaskById start");

        Optional<Task> taskEntityOptional = taskRepository.findById(1L);
        if (taskEntityOptional.isPresent()) {
            Task task = taskEntityOptional.get();
            task.setTaskMessage("taskMessage567");
            task.setUser_id(1L);
            taskRepository.save(task);

            Long taskId = task.getTask_id();
            String taskMessage = task.getTaskMessage();
            Long userId = task.getUser_id();
            Assertions.assertNotNull(taskId, "taskId should not be null");
            Assertions.assertNotNull(taskMessage, "taskMessage should not be null");
            Assertions.assertNotNull(userId, "userId should not be null");
            Assertions.assertEquals("taskMessage567", taskMessage);
            Assertions.assertEquals(1L, (long) userId);
        }
    }
}
