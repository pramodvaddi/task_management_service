package com.pramodvaddiraju.task_management_service.service;

import com.pramodvaddiraju.task_management_service.entity.Task;
import com.pramodvaddiraju.task_management_service.exception.ResourceNotFoundException;
import com.pramodvaddiraju.task_management_service.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{


    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Page<Task> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Task not found with id: " + id)
        );
    }

    @Override
    public void deleteTaskById(int id) {
        taskRepository.deleteById(id);

    }
}
