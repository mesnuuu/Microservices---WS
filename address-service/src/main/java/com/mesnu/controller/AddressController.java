package com.mesnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mesnu.request.CreateAddressRequest;
import com.mesnu.response.AddressResponse;
import com.mesnu.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody CreateAddressRequest addressRequest){

        return addressService.createAddress(addressRequest);
    }

    
    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id){

        return addressService.getById(id);
    }

    @GetMapping("/index")
    public String index(){

        return "index";
    }
}
