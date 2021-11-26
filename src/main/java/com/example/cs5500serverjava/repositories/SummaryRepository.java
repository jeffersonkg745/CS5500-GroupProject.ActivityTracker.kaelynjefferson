package com.example.cs5500serverjava.repositories;

import com.example.cs5500serverjava.models.DateRecorded;
import com.example.cs5500serverjava.models.Segments;
import com.example.cs5500serverjava.models.Summary;
import com.example.cs5500serverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SummaryRepository interface includes queries for Summary.
 */
@Repository
public interface SummaryRepository extends CrudRepository<Summary, Long> {

    //queries a list of activities for a specific collectionDateId
    @Query(value = "SELECT group_of_activity FROM summary WHERE collection_date_id LIKE id=:collectionDateId", nativeQuery = true)
    Iterable<Summary> getAllActivitiesForCollectionDateId(@Param("collectionDateId") Long collectionDateId);

    //create new row for a specific collection Date Id that already exists in db and adds a new activity for that
    @Query(value = "INSERT into summary (collection_date_id, group_of_activity) VALUES (id, activity); ", nativeQuery = true)
    Iterable<Summary> insertNewActivityForUser(@Param("id") Long id, @Param("activity") String activity);

    @Query(value = "SELECT * FROM summary", nativeQuery = true)
    Iterable<Summary> getAllSummary();

    //queries a list of all information from the collection_date table
    @Query(value = "SELECT * FROM summary WHERE date_recorded=:userId", nativeQuery = true )
    public Iterable<Summary> getSummaryForUser(@Param("userId") long userId);



}
