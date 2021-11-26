package com.example.cs5500serverjava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

/**
 * DateRecorded class holds the highest level data for the json file including
 * "Summary, Segments, CaloriesIdle, Lastupdate".
 */
@Entity
public class DateRecorded {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dateRecordedId;

    @OneToMany(mappedBy = "dateRecorded")
    @Column(nullable = true)
    @JsonManagedReference
    private Collection<Summary> summaries;


    @OneToMany(mappedBy = "dateRecordedSeg")
    @JsonManagedReference
    private Collection<Segments> segments;

    private Integer caloriesIdle;
    private String lastUpdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


    //constructor, getters/setters
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Collection<Summary> getSummaries() {
        return summaries;
    }
    public void setSummaries(Collection<Summary> summaries) {
        this.summaries = summaries;
    }
    public Collection<Segments> getSegments() {
        return segments;
    }
    public void setSegments(Collection<Segments> segments) {
        this.segments = segments;
    }
    public Integer getCaloriesIdle() {
        return caloriesIdle;
    }
    public void setCaloriesIdle(Integer caloriesIdle) {
        this.caloriesIdle = caloriesIdle;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Long getDateRecordedId() {
        return dateRecordedId;
    }
    public void setDateRecordedId(Long collectionDateId) {
        this.dateRecordedId = collectionDateId;
    }
    //public DateRecorded(){}
}
