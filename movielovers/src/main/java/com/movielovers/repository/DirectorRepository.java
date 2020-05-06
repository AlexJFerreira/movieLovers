package com.movielovers.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movielovers.model.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
	
	public Director findDirectorByNameAndBornDate(String name, LocalDate bornDate);


}
