package com.example.cs5500serverjava.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Location class that is used within Place.
 */
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loc_id;

    private String lat;
    private String lng;

    @JsonIgnore
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "place_id")
    private PlaceSegment placeSegment;

    //constructors, setters/getters
    public Location() { }
    public Integer getLoc_id() {
        return loc_id;
    }
    public void setLoc_id(Integer loc_id) {
        this.loc_id = loc_id;
    }
    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLng() {
        return lng;
    }
    public void setLng(String lng) {
        this.lng = lng;
    }

    public PlaceSegment getPlace() {
        return placeSegment;
    }
    public void setPlace(PlaceSegment placeSegment) {
        this.placeSegment = placeSegment;
    }

}





