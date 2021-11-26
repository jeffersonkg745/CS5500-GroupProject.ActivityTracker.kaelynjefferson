package com.example.cs5500serverjava.controllers;

import com.example.cs5500serverjava.models.Activity;
import com.example.cs5500serverjava.repositories.ActivityRepository;
import com.example.cs5500serverjava.services.DateRecordedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that provides Activity api's.
 */
@RestController
public class ActivityController {

    @Autowired
    ActivityRepository repository;
    @Autowired
    DateRecordedService service;

    //gets all activity data
    @GetMapping("/api/user/date-recorded/segments/move/activity")
    public Iterable<Activity> findAllActivityData() {
        return service.findAllActivityData();
    }

    //gets all activity data for user
    @GetMapping("/api/user/{userId}/date-recorded/segments/move/activity")
    public Iterable<Activity> findAllActivityDataForUser(@PathVariable("userId") long id) {
        return service.getAllActivitiesForUser(id);
    }

//methods used for general data calling (not for our visualizations)
    //get all entries of activities that are walking
    @GetMapping("/api/user/date-recorded/segments/move/activity/walking")
    public Iterable<Activity> findAllWalkingActivities() {
        return service.getAllWalkingActivities();
    }

    //get all entries of activities that are running
    @GetMapping("/api/user/date-recorded/segments/move/activity/running")
    public Iterable<Activity> findAllRunningActivities() {
        return service.getAllRunningActivities();
    }

    //get all entries of activties that are transport
    @GetMapping("/api/user/date-recorded/segments/move/activity/transport")
    public Iterable<Activity> findAllTransportActivities() {
        return service.getAllTransportActivities();
    }

    //get all entries of activities that are cycling
    @GetMapping("/api/user/date-recorded/segments/move/activity/cycling")
    public Iterable<Activity> findAllCyclingActivities() {
        return service.getAllCyclingActivities();
    }

    //get all entries of activities that are kayaking
    @GetMapping("/api/user/date-recorded/segments/move/activity/kayaking")
    public Iterable<Activity> findAllKayakingActivities() {
        return service.getAllKayakingActivities();
    }

    //get all entries of activities that are not cycling, transport, running, and walking
    @GetMapping("/api/user/date-recorded/segments/move/activity/other")
    public Iterable<Activity> findAllOtherActivities() {
        return service.getAllOtherActivities();
    }



//methods used for visualization 1
    //get the total number of activities
    @GetMapping("/api/user/date-recorded/segments/move/activity/count")
    public Integer findNumberOfActivities() {
        return service.getNumberOfActivities();
    }

    //get the total number of walking activities
    @GetMapping("/api/user/date-recorded/segments/move/activity/walking/count")
    public Integer findNumberOfWalkingActivities() {
        return service.getNumberOfWalkingActivities();
    }

    //get the total number of running activities
    @GetMapping("/api/user/date-recorded/segments/move/activity/running/count")
    public Integer findNumberOfRunningActivities() {
        return service.getNumberOfRunningActivities();
    }

    //get the total number of running activities
    @GetMapping("/api/user/date-recorded/segments/move/activity/transport/count")
    public Integer findNumberOfTransportActivities() {
        return service.getNumberOfTransportActivities();
    }

    //get the total number of cycling activities
    @GetMapping("/api/user/date-recorded/segments/move/activity/cycling/count")
    public Integer findNumberOfCyclingActivities() {
        return service.getNumberOfCyclingActivities();
    }

    //get the total number of other activities (not walking, cycling, running, transport)
    @GetMapping("/api/user/date-recorded/segments/move/activity/other/count")
    public Integer findNumberOfOtherActivities() {
        return service.getNumberOfOtherActivities();
    }

    //get the total number of other activities (not walking, cycling, running, transport)
    @GetMapping("/api/user/date-recorded/segments/move/activity/kayaking/count")
    public Integer findNumberOfKayakingActivities() {
        return service.getNumberOfKayakingActivities();
    }



//methods used for visualization 3
    @GetMapping("/api/user/date-recorded/segments/move/activity/walking/calories/average")
    public Integer findAverageCaloriesForWalking() {
        return service.getAverageCaloriesForWalking();
    }

    @GetMapping("/api/user/date-recorded/segments/move/activity/running/calories/average")
    public Integer findAverageCaloriesForRunning() {
        return service.getAverageCaloriesForRunning();
    }

    @GetMapping("/api/user/date-recorded/segments/move/activity/cycling/calories/average")
    public Integer findAverageCaloriesForCycling() {
        return service.getAverageCaloriesForCycling();
    }

    @GetMapping("/api/user/date-recorded/segments/move/activity/kayaking/calories/average")
    public Integer findAverageCaloriesForKayaking() {
        return service.getAverageCaloriesForKayaking();
    }

    @GetMapping("/api/user/date-recorded/segments/move/activity/crosscountryskiing/calories/average")
    public Integer findAverageCaloriesForCrossCountrySkiing() {
        return service.getAverageCaloriesForCrossCountrySkiing();
    }


//methods used for visualization 2
    //get the total time spend walking
    @GetMapping("/api/user/date-recorded/segments/move/activity/walking/total-time")
    public Integer findTotalTimeSpentWalking() {
        return service.getTimeWalkingTotal();
    }

    @GetMapping("/api/user/date-recorded/segments/move/activity/running/total-time")
    public Integer findTotalTimeSpentRunning() {
        return service.getTimeRunningTotal();
    }

    @GetMapping("/api/user/date-recorded/segments/move/activity/cycling/total-time")
    public Integer findTotalTimeSpentCycling() {
        return service.getTimeCyclingTotal();
    }

    @GetMapping("/api/user/date-recorded/segments/move/activity/transport/total-time")
    public Integer findTotalTimeSpentTransport() {
        return service.getTimeTransportTotal();
    }

    @GetMapping("/api/user/date-recorded/segments/move/activity/other/total-time")
    public Integer findTotalTimeSpentOther() {
        return service.getTimeOtherTotal();
    }

}


