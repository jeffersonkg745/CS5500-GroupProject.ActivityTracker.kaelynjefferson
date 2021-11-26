package com.example.cs5500serverjava.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Move class is a sub class of Segments.
 */
@Entity
@JsonTypeName("move")
@DiscriminatorValue("M")
public class Move extends Segments {

    protected long move_id;

    @JsonManagedReference
    @OneToMany(mappedBy="move")
    private Collection<Activity> activities;

    //setters/getters and constructor
    public void setName(String name) {
    }
    public Collection<Activity> getActivities() {
        return activities;
    }
    public void setActivities(Collection<Activity> activities) {
        this.activities = activities;
    }

}






