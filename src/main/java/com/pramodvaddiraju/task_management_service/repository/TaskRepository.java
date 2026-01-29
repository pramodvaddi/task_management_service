package com.pramodvaddiraju.task_management_service.repository;

import com.pramodvaddiraju.task_management_service.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {


}
