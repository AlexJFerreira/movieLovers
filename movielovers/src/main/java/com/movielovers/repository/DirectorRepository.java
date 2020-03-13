package com.movielovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movielovers.model.Director;
import com.movielovers.model.pk.DirectorPK;

public interface DirectorRepository extends JpaRepository<Director, DirectorPK> {

}
