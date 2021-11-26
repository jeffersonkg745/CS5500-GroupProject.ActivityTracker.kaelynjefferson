package com.example.cs5500serverjava.repositories;

import com.example.cs5500serverjava.models.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * PlaceRepository class includes queries for Place.
 */
public interface PlaceRepository extends CrudRepository<Place, Long> {

    @Query(value = "SELECT * FROM place", nativeQuery = true)
    Iterable<Place> getAllPlaceInfo();

}
