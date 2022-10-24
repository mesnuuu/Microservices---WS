package com.infybuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infybuzz.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
