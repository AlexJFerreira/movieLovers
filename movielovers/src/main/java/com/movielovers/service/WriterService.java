package com.movielovers.service;

import java.util.Optional;

import com.movielovers.model.Writer;
import com.movielovers.model.pk.WriterPK;

public interface WriterService {

	void persistNewActor(Writer writer);

	Optional<Writer> findWriterById(WriterPK writerPK);

}
