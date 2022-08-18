package com.donaldwu.main.service;

import com.donaldwu.main.model.Task;
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

    public void createTask(Task taskEntity, String taskMessage, Long userId) {
        Long id = taskEntity.getTask_id();
        if (id != null) {
            Optional<Task> task = taskRepository.findById(id);
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

    public List<Task> getAllTask() {
        List<Task> taskList = new ArrayList<>();

        Iterable<Task> taskEntities = taskRepository.findAll();
        taskEntities.forEach(taskList::add);

        return taskList;
    }

    public Task getTaskById(Long id) {
        Task result = null;

        Optional<Task> taskEntity = taskRepository.findById(id);
        if (taskEntity.isPresent()) {
            result = taskEntity.get();
        }
        return result;
    }

    public void updateTaskById(Long id, String taskMessage, Long userId) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setTaskMessage(taskMessage);
            existingTask.setUser_id(userId);
            taskRepository.save(existingTask);
        }
    }

    public void deleteTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.deleteById(id);
        }
    }
}
