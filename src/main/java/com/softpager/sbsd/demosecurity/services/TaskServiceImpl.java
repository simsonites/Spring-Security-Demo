package com.softpager.sbsd.demosecurity.services;

import com.softpager.sbsd.demosecurity.entities.Task;
import com.softpager.sbsd.demosecurity.entities.User;
import com.softpager.sbsd.demosecurity.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void createTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    @Override
    public List<Task> findUserTask(User user){
        return taskRepository.findByUser(user);
    }
}
