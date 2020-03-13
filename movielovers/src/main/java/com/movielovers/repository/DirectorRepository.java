package com.movielovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movielovers.model.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

}
