package com.softpager.sbsd.demosecurity.services;
import com.softpager.sbsd.demosecurity.entities.Role;
import com.softpager.sbsd.demosecurity.entities.User;
import com.softpager.sbsd.demosecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

  @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers(String name) {
        return userRepository.findByFirstNameLike("%"+name+"%");
    }

    //This method will create user with the role of USER
    @Override
    public void createUser(User theUSer) {
     theUSer.setPassword(passwordEncoder.encode(theUSer.getPassword()));
      Role newRole = new Role("USER");
      Set<Role> userRoles = new HashSet<>();
      userRoles.add(newRole);
      theUSer.setRoles(userRoles);
      userRepository.save(theUSer);
    }

    //This method will create user with the role of ADMIN
    @Override
    public void createAdmin(User theUSer) {
        theUSer.setPassword(passwordEncoder.encode(theUSer.getPassword()));
        Role newRole = new Role("ADMIN");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(newRole);
        theUSer.setRoles(userRoles);
        userRepository.save(theUSer);
    }

    @Override
    public User getUser(String email) {
       return userRepository.getOne(email);
    }

    @Override
    public boolean userExists(String email) {
        Optional<User> user = userRepository.findById(email);
        return user.isPresent();
    }
}
