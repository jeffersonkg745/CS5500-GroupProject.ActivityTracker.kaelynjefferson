package com.example.cs5500serverjava.services;

import com.example.cs5500serverjava.models.User;
import com.example.cs5500serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService class acts as a service for the User class.
 */
@Service
public class UserService {

    @Autowired
    UserRepository repository;

    //creates a user object
    public User createUser(User user) {
        return repository.save(user);
    }

    //updates a user
    public Integer updateUser(Long id, User newUser) {
        User originalUser =  repository.findUserById(id);
        originalUser.setUsername(newUser.getUsername());
        repository.save(originalUser);
        return 1;
    }

    //deletes a user
    public Integer deleteUser(Long id) {
        repository.deleteById(id);
        return 1;
    }

    //makes a list of all users
    public Iterable<User> findAllUsers() {
        return repository.findAllUsers();
    }

    //finds the amount of users
    public int findAmountOfUsers() {
        return repository.findAmountOfUsers();
    }


}
