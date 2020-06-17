package com.demo.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.backend.model.Profile;
import com.demo.backend.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProfileController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping("/profiles")
	public List<Profile> getAllCustomers() {
		System.out.println("");

		List<Profile> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);

		return customers;
	}

	@PostMapping("/profile")
	public Profile postCustomer(@RequestBody Profile profile) {

		Profile profiles = repository.save(new Profile(profile.getName(), profile.getAge()));
		return profile;
	}

	@DeleteMapping("/profile/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@GetMapping("profile/age/{age}")
	public List<Profile> findByAge(@PathVariable int age) {

		List<Profile> profiles = repository.findByAge(age);
		return profiles;
	}

	@PutMapping("/profile/{id}")
	public ResponseEntity<Profile> updateCustomer(@PathVariable("id") long id, @RequestBody Profile profile) {
		System.out.println("Update Customer with ID = " + id + "...");

		Optional<Profile> customerData = repository.findById(id);

		if (customerData.isPresent()) {
			Profile _customer = customerData.get();
			_customer.setName(profile.getName());
			_customer.setAge(profile.getAge());
			_customer.setActive(profile.isActive());
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
