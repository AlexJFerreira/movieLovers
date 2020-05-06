package com.movielovers.service;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.inject.Named;

import com.movielovers.model.Writer;
import com.movielovers.repository.WriterRepository;

@Named("writerService")
public class WriterServiceImpl implements WriterService {
	
	private final WriterRepository writerRepository;
	
	@Inject
	public WriterServiceImpl(final WriterRepository writerRepository) {
		this.writerRepository = writerRepository;
	}
	
	@Override
	public Writer findWriterByNameAndBornDate(final String name, final LocalDate bornDate) {
		return writerRepository.findWriterByNameAndBornDate(name, bornDate);
	}
	
	@Override
	public void persistNewActor(final Writer writer) {
		writerRepository.save(writer);
	}

}
