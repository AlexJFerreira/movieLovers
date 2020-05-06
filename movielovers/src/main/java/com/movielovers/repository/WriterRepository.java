package com.movielovers.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movielovers.model.Writer;

public interface WriterRepository extends JpaRepository<Writer, Integer> {
	
	public Writer findWriterByNameAndBornDate(String name, LocalDate bornDate);


}
