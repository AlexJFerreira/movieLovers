package com.movielovers.service;

import java.time.LocalDate;

import com.movielovers.model.Writer;

public interface WriterService {

	void persistNewActor(Writer writer);

	Writer findWriterByNameAndBornDate(String name, LocalDate bornDate);

}
