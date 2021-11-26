package com.example.cs5500serverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * User class is the highest level, and has a one to many relationship with DateRecorded.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String username;

    @OneToMany(mappedBy= "user")
    @JsonManagedReference
    private Collection<DateRecorded> dates = new ArrayList<>();


    //getters and setters and constructors
    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public Collection<DateRecorded> getDates() {
        return dates;
    }
    public void setDates(Collection<DateRecorded> dates) {
        this.dates = dates;
    }
    public long getId() { return user_id; }
    public void setId(long id) { this.user_id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public User(){ }

}
