package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
