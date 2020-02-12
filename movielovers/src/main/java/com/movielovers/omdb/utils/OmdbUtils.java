package com.movielovers.omdb.utils;

import static org.apache.commons.lang3.StringUtils.remove;
import static org.apache.commons.lang3.StringUtils.trim;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.movielovers.model.Actor;
import com.movielovers.model.Director;
import com.movielovers.model.Writer;

public class OmdbUtils {
	
	private OmdbUtils() {}

	public static Integer adjustMovieDurationTime(final String durationTime) {
		return Integer.valueOf(trim(remove(durationTime, "min")));
	}
	
	public static Set<Actor> extractActors(final String actors) {
		final List<String> actorsList = List.of(actors.split(","));
		return actorsList.stream().map(Actor::new).collect(Collectors.toSet());
	}
	
	public static Set<Writer> extractWriters(final String writers) {
		final List<String> writerList = List.of(writers.split(","));
		return writerList.stream().map(Writer::new).collect(Collectors.toSet());
	}
	
	public static Set<Director> extractDirectors(final String directors) {
		final List<String> directorsList = List.of(directors.split(","));
		return directorsList.stream().map(Director::new).collect(Collectors.toSet());
	}

}
