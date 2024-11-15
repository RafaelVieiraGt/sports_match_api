package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.Sports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsRepository extends JpaRepository<Sports, Long> {
}
