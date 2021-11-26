package com.example.cs5500serverjava.repositories;

import com.example.cs5500serverjava.models.User;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * UserRepository interface includes queries for User.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //queries a list of all users
    @Query(value = "SELECT * FROM User", nativeQuery = true )
    public Iterable<User> findAllUsers();

    //queries the number of users
    @Query(value = "SELECT COUNT(*) FROM User", nativeQuery = true )
    public int findAmountOfUsers();

    //queries a specific user info from the given userId
    @Query(value = "SELECT * FROM User WHERE id=:userId", nativeQuery = true )
    public User findUserById(@Param("userId") Long userId);

    //creates a new user without Id specified
    @Query(value = "INSERT INTO User VALUES (user_id, null)", nativeQuery = true)
    @Modifying
    @Transactional
    public void addNewUser();

    //make a specific user with user_id given
    //adapted from: https://stackoverflow.com/questions/42739566/how-to-use-jpa-query-to-insert-data-into-db
    @Query(value = "INSERT INTO User(user_id, username) VALUES (:userId, null)", nativeQuery = true)
    @Modifying
    @Transactional
    public void addUserWithId(@Param("userId") Long userId);

    //query is right, but can only delete the user you create manually
    @Query(value =  "DELETE from User where user_id=:userId", nativeQuery = true)
    @Modifying
    @Transactional
    public void deleteUserWithId(@Param("userId") Long userId);




}
