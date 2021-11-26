package com.example.cs5500serverjava.controllers;

import com.example.cs5500serverjava.models.User;
import com.example.cs5500serverjava.repositories.UserRepository;
import com.example.cs5500serverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

/**
 * Controller class used for api's relating to Users.
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserRepository repository;
    @Autowired
    com.example.cs5500serverjava.repositories.DateRecordedRepository dateRecordedRepository;
    @Autowired
    UserService service;


    // find all users
    @GetMapping("/api/users")
    public Iterable<User> listOfUsers() {
        return service.findAllUsers();
    }

    //get amount of users
    @GetMapping("/api/users/all/count")
    public int getAmountOfUsers() {
        return service.findAmountOfUsers();
    }

    // finds data for a specific user
    @GetMapping("/api/users/{userId}")
    public Optional<User> findUserById(@PathVariable("userId") long id) {
        return repository.findById(id);
    }


    //adds a user with the next available user_id
    @RequestMapping(value = "api/users/newUser", method = RequestMethod.POST)
    public void makeUserWithNoIdSpecified() {
        repository.addNewUser();
    }


    //adds a user with the given id
    @RequestMapping(value = "api/users/newUser/{newUserId}", method = RequestMethod.POST)
    public void makeUser(@PathVariable("newUserId") long id) {
            repository.addUserWithId(id);
    }



    //deletes a user with the given id (only works for things not embedded. to test: create one then delete it)
    //adapted from: https://popsql.com/learn-sql/mysql/how-to-delete-in-mysql
    @RequestMapping(value = "api/users/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") long id) {
        repository.deleteUserWithId(id);
    }


    /*
    //** updates a user's username
    @PutMapping("/api/users/update/{userId}")
    public Integer updateUser( @PathVariable("userId") Long id, @RequestBody User user) {
        return service.updateUser(id,user);
    }
     */

}
