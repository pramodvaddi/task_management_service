package com.pramodvaddiraju.task_management_service.service;

import com.pramodvaddiraju.task_management_service.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    Task saveTask(Task task);
    Page<Task> getAllTasks(Pageable pageable);
    Task getTaskById(int id);
    void deleteTaskById(int id);

}
