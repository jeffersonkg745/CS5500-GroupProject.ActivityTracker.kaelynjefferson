package com.example.cs5500serverjava.repositories;

import com.example.cs5500serverjava.models.Activity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ActivityRepository interface includes queries for activities.
 */
@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

//General queries
    //get all activity data
    @Query(value= "SELECT * FROM Activity", nativeQuery = true)
    public Iterable<Activity> getAllActivityData();

    //get all activity data for user
    @Query(value = "SELECT * FROM Activity WHERE move_id=:id", nativeQuery = true)
    public Iterable<Activity> getAllActivitiesForUser(@Param("id") Long id);

    //get all activities that are walking
    @Query(value = "SELECT * FROM Activity WHERE activity = 'walking'", nativeQuery = true)
    public Iterable<Activity> getAllWalkingActivities();

    //get all activities that are running
    @Query(value = "SELECT * FROM Activity WHERE activity = 'running'", nativeQuery = true)
    public Iterable<Activity> getAllRunningActivities();

    //get all activities that are transportation
    @Query(value = "SELECT * FROM Activity WHERE activity = 'transport'", nativeQuery = true)
    public Iterable<Activity> getAllTransportActivities();

    //get all activities that are cycling
    @Query(value = "SELECT * FROM Activity WHERE activity = 'cycling'", nativeQuery = true)
    public Iterable<Activity> getAllCyclingActivities();

    @Query(value = "SELECT * FROM Activity WHERE activity = 'kayaking'", nativeQuery = true)
    public Iterable<Activity> getAllKayakingActivities();

    //get all activities that are not walking, running, transport, or cycling
    @Query(value = "SELECT * FROM Activity WHERE activity != 'cycling' AND activity != 'walking' AND activity != 'transport' AND activity != 'running'", nativeQuery = true)
    public Iterable<Activity> getAllOtherActivities();


//Queries used for visualization 1
    //get the amount of activities total
    @Query(value = "SELECT COUNT(*) FROM Activity", nativeQuery = true )
    public int findNumberOfActivities();

    //get the amount of walking activities total
    @Query(value = "SELECT COUNT(*) FROM Activity WHERE activity = 'walking'", nativeQuery = true )
    public int findNumberOfWalkingActivities();

    //get the amount of running activities total
    @Query(value = "SELECT COUNT(*) FROM Activity WHERE activity = 'running'", nativeQuery = true )
    public int findNumberOfRunningActivities();

    //get the amount of transport activities
    @Query(value = "SELECT COUNT(*) FROM Activity WHERE activity = 'transport'", nativeQuery = true )
    public int findNumberOfTransportActivities();

    //get the amount of cycling activities
    @Query(value = "SELECT COUNT(*) FROM Activity WHERE activity = 'cycling'", nativeQuery = true )
    public int findNumberOfCyclingActivities();

    //get the amount of running activities total
    @Query(value = "SELECT COUNT(*) FROM Activity WHERE activity = 'kayaking'", nativeQuery = true )
    public int findNumberOfKayakingActivities();

    //get the amount of cycling activities
    @Query(value = "SELECT COUNT(*) FROM Activity WHERE activity != 'cycling' AND activity != 'walking' AND activity != 'transport' AND activity != 'running'", nativeQuery = true )
    public int findNumberOfOtherActivities();

//queries used for visualization of time spent
    @Query(value = "SELECT SUM(duration) FROM Activity WHERE activity='walking' ", nativeQuery = true )
    public int findTotalTimeSpentOnWalking();
    @Query(value = "SELECT SUM(duration) FROM Activity WHERE activity='running' ", nativeQuery = true )
    public int findTotalTimeSpentOnRunning();
    @Query(value = "SELECT SUM(duration) FROM Activity WHERE activity='cycling' ", nativeQuery = true )
    public int findTotalTimeSpentOnCycling();
    @Query(value = "SELECT SUM(duration) FROM Activity WHERE activity='transport' ", nativeQuery = true )
    public int findTotalTimeSpentOnTransport();
    @Query(value = "SELECT SUM(duration) FROM Activity WHERE activity != 'cycling' AND activity != 'walking' AND activity != 'transport' AND activity != 'running' ", nativeQuery = true )
    public int findTotalTimeSpentOnOther();

//queries used for visualization of average calories
    @Query(value = "select AVG(calories) from Activity where activity ='walking' ", nativeQuery = true )
    public int findAverageCaloriesForWalking();
    @Query(value = "select AVG(calories) from Activity where activity ='running' ", nativeQuery = true )
    public int findAverageCaloriesForRunning();
    @Query(value = "select AVG(calories) from Activity where activity ='kayaking' ", nativeQuery = true )
    public int findAverageCaloriesForKayaking();
    @Query(value = "select AVG(calories) from Activity where activity ='cycling' ", nativeQuery = true )
    public int findAverageCaloriesForCycling();
    @Query(value = "select AVG(calories) from Activity where activity ='cross_country_skiing' ", nativeQuery = true )
    public int findAverageCaloriesForCrossCountrySkiing();

}




