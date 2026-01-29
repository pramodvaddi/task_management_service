package com.pramodvaddiraju.task_management_service.controller;

import com.pramodvaddiraju.task_management_service.entity.Task;
import com.pramodvaddiraju.task_management_service.service.TaskService;
import com.pramodvaddiraju.task_management_service.service.TaskServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    ResponseEntity<Task> saveTask(@Valid @RequestBody Task task){
        Task savedTask = taskService.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable int id){
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<Page<Task>> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(defaultValue = "id") String sortBy


    ){
        Sort sort = sortDir.equalsIgnoreCase("asc")?
                Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Task> getAllTasks = taskService.getAllTasks(pageable);
        return new ResponseEntity<>(getAllTasks, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTaskById(@PathVariable int id){
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
