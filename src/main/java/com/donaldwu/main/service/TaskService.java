package com.donaldwu.main.service;

import com.donaldwu.main.entity.TaskEntity;
import com.donaldwu.main.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void createTask(TaskEntity taskEntity, String taskMessage, Long userId) {
        Optional<TaskEntity> task = taskRepository.findById(taskEntity.getId());
        if (!task.isPresent()) {
            taskEntity.setTaskMessage(taskMessage);
            taskEntity.setUserId(userId);
            taskRepository.save(taskEntity);
        }
    }

    public List<TaskEntity> getAllTask() {
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void updateTaskById(Long id, String taskMessage, Long userId) {
        Optional<TaskEntity> task = taskRepository.findById(id);
        if (task.isPresent()) {
            TaskEntity existingTaskEntity = task.get();
            existingTaskEntity.setTaskMessage(taskMessage);
            existingTaskEntity.setUserId(userId);
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
