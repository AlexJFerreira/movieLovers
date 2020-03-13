package com.movielovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movielovers.model.Writer;
import com.movielovers.model.pk.WriterPK;

public interface WriterRepository extends JpaRepository<Writer, WriterPK> {

}
