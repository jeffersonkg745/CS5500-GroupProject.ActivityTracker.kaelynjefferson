package com.example.cs5500serverjava.services;

import com.example.cs5500serverjava.models.*;
import com.example.cs5500serverjava.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * DateRecordedService class acts as a service for all things under the DateRecorded. This includes dateRecorded,
 * Segments, Summary, Place, Move, and Activity.
 */
@Service
public class DateRecordedService {

    @Autowired
    private UserRepository userrepository;
    @Autowired
    private DateRecordedRepository dateRecordedRepository;
    @Autowired
    private SegmentsRepository segmentsRepository;
    @Autowired
    private SummaryRepository summaryRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private ActivityRepository activityRepository;


    //method that parses the json format into database using models
    public void createCollectionDate(DateRecorded datesRecorded) {

        //saves each date
        dateRecordedRepository.save(datesRecorded);

        //saves each segment
        for (Segments segment : datesRecorded.getSegments()
             ) {
            if (segment instanceof PlaceSegment) {
                Place updatedPlace = placeRepository.save(((PlaceSegment) segment).getPlace());
            }
            if (segment instanceof Move) {
                segmentsRepository.save(segment);
                Collection<Activity> activities = ((Move)segment).getActivities();
                for (Activity activity : activities ) {
                    Activity act = activityRepository.save(activity);
                    activity.setActivity_id(act.getActivity_id());
                    activityRepository.save(activity);
                }
            }
        }
        segmentsRepository.saveAll(datesRecorded.getSegments());

        try {
            for (Summary summary : datesRecorded.getSummaries()) {
            summaryRepository.save(summary);
            }
        } catch(NullPointerException npe) {

        }
    }


//ACTIVITY SERVICES
    //get all activity data
    public Iterable<Activity> findAllActivityData() {
        return activityRepository.getAllActivityData();
    }

    //get all activity data for a user
    public Iterable <Activity> getAllActivitiesForUser(long id) { return activityRepository.getAllActivitiesForUser(id); }

    //get all activities by category: walking, running, transport, cycling, kayaking, other(not walking, run, transp, cycling)
    public Iterable <Activity> getAllWalkingActivities() {
        return activityRepository.getAllWalkingActivities();
    }
    public Iterable <Activity> getAllRunningActivities() {
        return activityRepository.getAllRunningActivities();
    }
    public Iterable <Activity> getAllTransportActivities() {
        return activityRepository.getAllTransportActivities();
    }
    public Iterable <Activity> getAllCyclingActivities() {
        return activityRepository.getAllCyclingActivities();
    }
    public Iterable <Activity> getAllKayakingActivities() {
        return activityRepository.getAllKayakingActivities();
    }
    public Iterable <Activity> getAllOtherActivities() {
        return activityRepository.getAllOtherActivities();
    }

    //get the total number of activities
    public Integer getNumberOfActivities() {
        return activityRepository.findNumberOfActivities();
    }

    //get the total number of activities by category
    public Integer getNumberOfWalkingActivities() {
        return activityRepository.findNumberOfWalkingActivities();
    }
    public Integer getNumberOfRunningActivities() {
        return activityRepository.findNumberOfRunningActivities();
    }
    public Integer getNumberOfTransportActivities() {
        return activityRepository.findNumberOfTransportActivities();
    }
    public Integer getNumberOfCyclingActivities() {
        return activityRepository.findNumberOfCyclingActivities();
    }
    public Integer getNumberOfOtherActivities() {
        return activityRepository.findNumberOfOtherActivities();
    }
    public Integer getNumberOfKayakingActivities() {
        return activityRepository.findNumberOfKayakingActivities();
    }

    //get the total time of doing activities by category
    public Integer getTimeWalkingTotal() {
        return activityRepository.findTotalTimeSpentOnWalking();
    }
    public Integer getTimeRunningTotal() {
        return activityRepository.findTotalTimeSpentOnRunning();
    }
    public Integer getTimeCyclingTotal() {
        return activityRepository.findTotalTimeSpentOnCycling();
    }
    public Integer getTimeTransportTotal() {
        return activityRepository.findTotalTimeSpentOnTransport();
    }
    public Integer getTimeOtherTotal() {
        return activityRepository.findTotalTimeSpentOnOther();
    }


    //get the average calories doing each activity by category
    public Integer getAverageCaloriesForWalking() {
        return activityRepository.findAverageCaloriesForWalking();
    }
    public Integer getAverageCaloriesForRunning() {
        return activityRepository.findAverageCaloriesForRunning();
    }
    public Integer getAverageCaloriesForCycling() {
        return activityRepository.findAverageCaloriesForCycling();
    }
    public Integer getAverageCaloriesForCrossCountrySkiing() { return activityRepository.findAverageCaloriesForCrossCountrySkiing(); }
    public Integer getAverageCaloriesForKayaking() {
        return activityRepository.findAverageCaloriesForKayaking();
    }



//DATE RECORDED SERVICES

    //find all activities on the Summary table that have the collection_date_id that you give
    public Iterable<Summary> findAllActivities(long collectionDateId) {
        return summaryRepository.getAllActivitiesForCollectionDateId(collectionDateId);
    }

    //adds a new activity in the Summary table for a specific collection_date_id
    public Iterable<Summary> addNewActivity(long id, String activity) {
        return summaryRepository.insertNewActivityForUser(id, activity);
    }


    //returns a list of all collection dates
    public Iterable<DateRecorded> getAllCollectionDates(long userId) {
        return dateRecordedRepository.getAllCollectionDates(userId);
    }

//SUMMARY SERVICES
    public Iterable<Summary> getSummaryForUser(long userId) {
        return summaryRepository.getSummaryForUser(userId);
    }
    public Iterable<Summary> getAllSummaryInfo() {
        return summaryRepository.getAllSummary();
    }

//SEGMENT SERVICES
    public Iterable<Segments> getAllSegmentInfo() { return segmentsRepository.getAllSegments(); }
    public Iterable<Segments> getSegmentsForUser(long userId) { return segmentsRepository.getSegmentsForUser(userId); }

//PLACE SERVICES
    public Iterable<Place> getAllPlaceInfo() {return placeRepository.getAllPlaceInfo(); }


}
