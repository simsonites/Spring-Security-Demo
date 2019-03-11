package com.softpager.sbsd.demosecurity.repositories;

import com.softpager.sbsd.demosecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByFirstNameLike(String name);
}
