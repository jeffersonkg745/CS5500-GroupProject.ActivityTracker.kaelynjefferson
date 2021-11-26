package com.example.cs5500serverjava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Map;

/**
 * Place class holds information under the "place" category in the json.
 */
@Entity
public class Place {

   @Id
   @JsonProperty("id")
    Long place_id;
    @JsonProperty("name")
    String place_name;
    @JsonProperty("type")
    String place_type;

    Double lat;
    Double lon;

    @SuppressWarnings("unchecked")
    @JsonProperty("location")
    private void unpackNestedLoc(Map<String, Object> location) {
        this.lat = (Double)location.get("lat");
        this.lon = (Double)location.get("lon");
    }

    //getters/setters
    public Long getPlace_id() {
        return place_id;
    }
    public void setPlace_id(Long place_id) {
        this.place_id = place_id;
    }
    public String getPlace_name() {
        return place_name;
    }
    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }
    public String getPlace_type() {
        return place_type;
    }
    public void setPlace_type(String place_type) {
        this.place_type = place_type;
    }
}
