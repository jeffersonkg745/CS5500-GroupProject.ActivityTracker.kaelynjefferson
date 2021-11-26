package com.example.cs5500serverjava.repositories;

import com.example.cs5500serverjava.models.Segments;
import com.example.cs5500serverjava.models.Summary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * SegmentsRepository interface includes queries for Segments.
 */
@Repository
public interface SegmentsRepository extends CrudRepository<Segments, Long> {

    @Query(value = "SELECT * FROM segments", nativeQuery = true)
    Iterable<Segments> getAllSegments();

    @Query(value = "SELECT * FROM segments WHERE date_recorded_seg=:userId", nativeQuery = true )
    Iterable<Segments> getSegmentsForUser(long userId);
}
