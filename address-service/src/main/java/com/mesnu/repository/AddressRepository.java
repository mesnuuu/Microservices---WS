package com.mesnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mesnu.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
