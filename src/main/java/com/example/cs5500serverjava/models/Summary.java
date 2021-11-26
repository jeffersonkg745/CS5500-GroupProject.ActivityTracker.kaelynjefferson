package com.example.cs5500serverjava.models;


import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;


/**
 * Summary class is a collection in the DateRecorded class.
 */
@Entity
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long summary_id;

    @Column(name = "Activity")
    private String activity;
    @Column(name = "GroupOfActivity")
    private String actgroup;
    @Column(name = "Duration")
    private String duration;
    @Column(name = "Distance")
    private String distance;
    @Column(name = "Steps")
    private String steps;
    @Column(name = "Calories")
    private String calories;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="dateRecorded")
    private DateRecorded dateRecorded;


    //constructors, getters/setters
    public DateRecorded getDateRecorded() {
        return dateRecorded;
    }
    public void setDateRecorded(DateRecorded dateRecorded) {
        this.dateRecorded = dateRecorded;
    }
    public long getSummary_id() {
        return summary_id;
    }
    public void setSummary_id(long summary_id) {
        this.summary_id = summary_id;
    }
    public String getActgroup() {
        return actgroup;
    }
    public void setActgroup(String actgroup) {
        this.actgroup = actgroup;
    }
    public String getActivity() {
        return activity;
    }
    public void setActivity(String activity) {
        this.activity = activity;
    }
    public String getGroup() {
        return actgroup;
    }
    public void setGroup(String group) {
        this.actgroup = group;
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
    public String getSteps() {
        return steps;
    }
    public void setSteps(String steps) {
        this.steps = steps;
    }
    public String getCalories() {
        return calories;
    }
    public void setCalories(String calories) {
        this.calories = calories;
    }
    public Summary() { }
}
