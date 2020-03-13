package com.movielovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movielovers.model.Writer;

public interface WriterRepository extends JpaRepository<Writer, Integer> {

}
