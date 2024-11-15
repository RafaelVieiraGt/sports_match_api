package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.UserPlanHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPlanHistoricRepository extends JpaRepository<UserPlanHistoric, Long> {
}
