package com.demo.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.backend.model.Profile;

public interface EmployeeRepository extends CrudRepository<Profile, Long> {
	List<Profile> findByAge(int age);
}
