package com.softpager.sbsd.demosecurity.services;

import com.softpager.sbsd.demosecurity.entities.Task;
import com.softpager.sbsd.demosecurity.entities.User;

import java.util.List;

public interface TaskService {

    void createTask(Task task, User user);
    List<Task> findUserTask(User user);
}
