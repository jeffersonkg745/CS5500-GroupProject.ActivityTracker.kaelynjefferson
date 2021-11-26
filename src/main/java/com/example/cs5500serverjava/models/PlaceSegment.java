package com.example.cs5500serverjava.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Collection;


/**
 * Place Segment is a sub class of Segments that has a one-to-one relationship with Place.
 */
@Entity
@JsonTypeName("place")
@DiscriminatorValue("P")
public class PlaceSegment extends Segments {

    @JsonProperty("id")
    private long place_segment_id;

    @OneToOne
    @JoinColumn(name = "place_id", referencedColumnName = "place_id")
    private Place place;

    //constructors, getter/setters
    public PlaceSegment(){}
    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }
}











