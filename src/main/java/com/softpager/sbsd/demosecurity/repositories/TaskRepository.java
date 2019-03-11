package com.softpager.sbsd.demosecurity.repositories;

import com.softpager.sbsd.demosecurity.entities.Task;
import com.softpager.sbsd.demosecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
