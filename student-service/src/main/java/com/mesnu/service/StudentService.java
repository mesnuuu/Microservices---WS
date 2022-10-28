package com.mesnu.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mesnu.entity.Student;
import com.mesnu.feignclients.AddressFeignClient;
import com.mesnu.repository.StudentRepository;
import com.mesnu.request.CreateStudentRequest;

import com.mesnu.response.StudentResponse;



@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    WebClient webClient;

    @Autowired
	AddressFeignClient addressFeignClient;

    @Autowired
    CommonService commonService;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentResponse getById(long id) {

        logger.info("Inside Student getById");

        Student student = studentRepository.findById(id).get();

        StudentResponse studentResponse = new StudentResponse(student);

        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));

        //   Web Client code

        // studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

        // Open Feign Client code

        // studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

        return studentResponse;
    }

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());

        student.setAddressId(createStudentRequest.getAddressId());
        student = studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse(student);

       // Open Feign Client code
        studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

       //   Web Client code      
       // studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

        return studentResponse;
    }

    // @CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
    // public AddressResponse getAddressById(long addressId) {

    //     //   Web Client code

    //     // Mono<AddressResponse> addressResponse = webClient.get()
    //     //         .uri("/getById/" + addressId)
    //     //         .retrieve()
    //     //         .bodyToMono(AddressResponse.class);

    //     // return addressResponse.block();

    //     AddressResponse addressResponse = addressFeignClient.getById(addressId);

    //     return addressResponse;
    // }

    // public AddressResponse fallbackGetAddressById(long addressId, Throwable th) {
	// 	return new AddressResponse();
    // }

}
