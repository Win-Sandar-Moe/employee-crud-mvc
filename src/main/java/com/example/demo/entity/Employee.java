package com.example.demo.entity;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "First Name cannot be empty!")
	@NotBlank(message = "First Name cannot be blank!")
	@Pattern(regexp = "[a-zA-Z]*",message = "First Name cannot contains illegal characters")
	@Length(min = 3,max = 15,message = "First Name must be between 3 characters and 15 characters.")
	private String firstName;
	@NotEmpty(message = "Last Name cannot be empty!")
	@NotBlank(message = "Last Name cannot be blank!")
	@Pattern(regexp = "[a-zA-Z]*",message = "Last Name cannot contains illegal characters")
	@Length(min = 3,max = 15,message = "Last Name must be between 3 characters and 15 characters.")
	private String lastName;
	@Email(message = "Invalid Email Format")
	private String email;
	@NotEmpty(message = "PhoneNumber cannot be empty!")
	@NotBlank(message = "PhoneNumber cannot be blank!")
	@Pattern(regexp = "\\d{10}", 
		message = "Phone number must be exactly 10 digits")
	private String phoneNumber;
	@Past(message = "Hired date must be past.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate hiredDate;
}






