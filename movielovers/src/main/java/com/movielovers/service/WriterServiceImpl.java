package com.movielovers.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import com.movielovers.model.Writer;
import com.movielovers.model.pk.WriterPK;
import com.movielovers.repository.WriterRepository;

@Named("writerService")
public class WriterServiceImpl implements WriterService {
	
	private final WriterRepository writerRepository;
	
	@Inject
	public WriterServiceImpl(final WriterRepository writerRepository) {
		this.writerRepository = writerRepository;
	}
	
	@Override
	public Optional<Writer> findWriterById(final WriterPK writerPK) {
		return writerRepository.findById(writerPK);
	}
	
	@Override
	public void persistNewActor(final Writer writer) {
		writerRepository.save(writer);
	}

}
