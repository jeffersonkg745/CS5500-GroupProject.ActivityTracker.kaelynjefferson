package com.example.cs5500serverjava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Activity class that holds all information from the json under "activity".
 */
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long activity_id;

    private String activity;
    @JsonProperty("group")
    private String activityGroup;
    private boolean manual;
    @JsonProperty("startTime")
    private String startTimeActivity;
    @JsonProperty("endTime")
    private String endTimeActivity;
    private String duration;
    private String distance;
    private Integer steps;
    private Integer calories;
    //private String trackPoints;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "move_id")
    private Move move;


    //constructors, getters/setters
    public Activity() {

    }
    public long getActivity_id() {
        return activity_id;
    }
    public void setActivity_id(long activity_id) {
        this.activity_id = activity_id;
    }
    public String getActivity() {
        return activity;
    }
    public void setActivity(String activity) {
        this.activity = activity;
    }
    public String getActivityGroup() {
        return activityGroup;
    }
    public void setActivityGroup(String activityGroup) {
        this.activityGroup = activityGroup;
    }
    public boolean isManual() {
        return manual;
    }
    public void setManual(boolean manual) {
        this.manual = manual;
    }
    public String getStartTimeActivity() {
        return startTimeActivity;
    }
    public void setStartTimeActivity(String startTimeActivity) {
        this.startTimeActivity = startTimeActivity;
    }
    public String getEndTimeActivity() {
        return endTimeActivity;
    }
    public void setEndTimeActivity(String endTimeActivity) {
        this.endTimeActivity = endTimeActivity;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
    public Integer getSteps() {
        return steps;
    }
    public void setSteps(Integer steps) {
        this.steps = steps;
    }
    public Integer getCalories() {
        return calories;
    }
    public void setCalories(Integer calories) {
        this.calories = calories;
    }
    public Move getMove() {
        return move;
    }
    public void setMove(Move move) {
        this.move = move;
    }

}



