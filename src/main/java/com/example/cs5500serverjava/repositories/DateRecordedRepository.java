package com.example.cs5500serverjava.repositories;

import com.example.cs5500serverjava.models.DateRecorded;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * DateRecordedRepository interface includes queries for DateRecorded.
 */
@Repository
public interface DateRecordedRepository extends CrudRepository<DateRecorded, Long> {

    //queries a list of all information from the collection_date table
    @Query(value = "SELECT * FROM date_recorded WHERE user_id=:userId", nativeQuery = true )
    public Iterable<DateRecorded> getAllCollectionDates(@Param("userId") long userId);

}
