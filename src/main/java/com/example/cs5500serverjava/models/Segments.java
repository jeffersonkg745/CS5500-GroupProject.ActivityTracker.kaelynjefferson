package com.example.cs5500serverjava.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

/**
 * Segments class is abstract, and child classes are PlaceSegment, and Move.
 */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PlaceSegment.class, name = "place"),
        @JsonSubTypes.Type(value = Move.class, name = "move"),
        @JsonSubTypes.Type(value = Move.class, name = "off") //off has the same fields as move, so can use the Move class
})

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="segment_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Segments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long segment_id;
    private String startTime;
    private String endTime;
    private String lastUpdate;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="dateRecordedSeg")
    private DateRecorded dateRecordedSeg;


    //constructor, getter/setters
    public Segments() {
    }
    public long getSegment_id() {
        return segment_id;
    }
    public void setSegment_id(long segment_id) {
        this.segment_id = segment_id;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public DateRecorded getDateRecordedSeg() {
        return dateRecordedSeg;
    }
    public void setDateRecordedSeg(DateRecorded dateRecorded) {
        this.dateRecordedSeg = dateRecorded;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}








