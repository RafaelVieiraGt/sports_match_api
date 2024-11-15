package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
