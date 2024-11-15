package com.sportsmatch.sportsmatch.Repository;

import com.sportsmatch.sportsmatch.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
