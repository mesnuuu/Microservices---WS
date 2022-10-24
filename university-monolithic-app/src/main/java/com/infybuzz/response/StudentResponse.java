package com.infybuzz.response;

import com.infybuzz.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

	private long id;

	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	public StudentResponse(Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();

		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
	}

}
