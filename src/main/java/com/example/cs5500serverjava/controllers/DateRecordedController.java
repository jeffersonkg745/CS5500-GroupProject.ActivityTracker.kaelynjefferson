package com.example.cs5500serverjava.controllers;

import com.example.cs5500serverjava.models.DateRecorded;
import com.example.cs5500serverjava.models.Place;
import com.example.cs5500serverjava.models.Segments;
import com.example.cs5500serverjava.models.Summary;
import com.example.cs5500serverjava.repositories.DateRecordedRepository;
import com.example.cs5500serverjava.services.DateRecordedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that provides api's for everything within a DateRecorded object (for the DateRecorded Model, Summary
 * Model, Segments Model, Place Model).
 */
@RestController
public class DateRecordedController {

    @Autowired
    DateRecordedRepository repository;
    @Autowired
    DateRecordedService service;

//DATE RECORDED
    @GetMapping("/api/user/{user_id}/date-recorded")
    public Iterable<DateRecorded> findAllCollectionDateInfo(@PathVariable("user_id") long userId) {
        return service.getAllCollectionDates(userId);
    }

//SUMMARY
    @GetMapping("/api/user/all/date-recorded/summary")
    public Iterable<Summary> findAllSummaryInfo() {
        return service.getAllSummaryInfo();
    }

    @GetMapping("/api/user/{user_id}/date-recorded/summary")
    public Iterable<Summary> getSummaryForUser(@PathVariable("user_id") long userId) {
        return service.getSummaryForUser(userId);
    }


//SEGMENTS
    @GetMapping("/api/user/all/date-recorded/segments")
    public Iterable<Segments> findAllSegmentInfo() {
        return service.getAllSegmentInfo();
    }

    @GetMapping("/api/user/{user_id}/date-recorded/segments")
    public Iterable<Segments> getSegmentsForUser(@PathVariable("user_id") long userId) {
        return service.getSegmentsForUser(userId);
    }

//PLACE
    @GetMapping("/api/user/all/date-recorded/segments/place")
    public Iterable<Place> findAllPlaceInfo() {
        return service.getAllPlaceInfo();
    }


}
