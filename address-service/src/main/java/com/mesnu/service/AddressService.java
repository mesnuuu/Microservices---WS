package com.mesnu.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mesnu.entity.Address;
import com.mesnu.repository.AddressRepository;
import com.mesnu.request.CreateAddressRequest;
import com.mesnu.response.AddressResponse;

@Service
public class AddressService {

    Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse getById(long id) {

        logger.info("Inside getById " + id);

        Optional<Address> address = addressRepository.findById(id);

        return new AddressResponse(address.get());
    }

    public AddressResponse createAddress(CreateAddressRequest addressRequest) {

        Address address = new Address();

        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());

        addressRepository.save(address);

        return new AddressResponse(address);
    }

}
