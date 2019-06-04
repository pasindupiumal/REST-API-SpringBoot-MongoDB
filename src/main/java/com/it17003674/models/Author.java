package com.it17003674.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Author {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String nationality;
	
	public Author(String firstName, String lastName, String nationality) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
	}

	public String getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

}
