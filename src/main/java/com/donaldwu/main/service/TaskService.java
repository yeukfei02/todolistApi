package com.donaldwu.main.service;

import com.donaldwu.main.entity.TaskEntity;
import com.donaldwu.main.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void createTask(TaskEntity taskEntity, String taskMessage, Long userId) {
        Long id = taskEntity.getTask_id();
        if (id != null) {
            Optional<TaskEntity> task = taskRepository.findById(id);
            if (task.isEmpty()) {
                taskEntity.setTaskMessage(taskMessage);
                taskEntity.setUser_id(userId);
                taskRepository.save(taskEntity);
            }
        } else {
            taskEntity.setTaskMessage(taskMessage);
            taskEntity.setUser_id(userId);
            taskRepository.save(taskEntity);
        }
    }

    public List<TaskEntity> getAllTask() {
        List<TaskEntity> taskList = new ArrayList<>();

        Iterable<TaskEntity> taskEntities = taskRepository.findAll();
        taskEntities.forEach(taskList::add);

        return taskList;
    }

    public TaskEntity getTaskById(Long id) {
        TaskEntity result = null;

        Optional<TaskEntity> taskEntity = taskRepository.findById(id);
        if (taskEntity.isPresent()) {
            result = taskEntity.get();
        }
        return result;
    }

    public void updateTaskById(Long id, String taskMessage, Long userId) {
        Optional<TaskEntity> task = taskRepository.findById(id);
        if (task.isPresent()) {
            TaskEntity existingTaskEntity = task.get();
            existingTaskEntity.setTaskMessage(taskMessage);
            existingTaskEntity.setUser_id(userId);
            taskRepository.save(existingTaskEntity);
        }
    }

    public void deleteTaskById(Long id) {
        Optional<TaskEntity> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.deleteById(id);
        }
    }
}
