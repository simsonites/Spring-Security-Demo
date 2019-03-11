package com.softpager.sbsd.demosecurity.services;


import com.softpager.sbsd.demosecurity.entities.User;

import java.util.List;

public interface UserService{

    List<User> getUsers(String name);

    void createUser(User theUSer);

    void createAdmin(User theUSer);

    User getUser(String email);

    boolean userExists(String email);
}
