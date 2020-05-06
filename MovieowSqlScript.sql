CREATE TABLE user (
	user_id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(150),
    user_name VARCHAR(25),
    password VARCHAR(250),
	born_date DATE,
    ip VARCHAR(15),
	email VARCHAR(255),
	score INTEGER,
	CONSTRAINT user_pk PRIMARY KEY (user_id)
);

CREATE TABLE badge (
	badge_id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(350),
	description TEXT,
	CONSTRAINT badge_pk PRIMARY KEY (badge_id)
);

CREATE TABLE user_badge (
	user_badge_id INTEGER NOT NULL AUTO_INCREMENT,
	badge_id INTEGER,
    user_id INTEGER,
	CONSTRAINT user_badge_pk PRIMARY KEY (user_badge_id),
	FOREIGN KEY (badge_id) REFERENCES badge (badge_id) ON DELETE CASCADE,
	FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE
);


CREATE TABLE movie (
	movie_id INTEGER NOT NULL AUTO_INCREMENT,
    translated_title VARCHAR(150),
	original_title VARCHAR(150),
	plot MEDIUMTEXT,
    genre VARCHAR(150),
	language VARCHAR(100),
	upvotes INTEGER,
	premiere_year INTEGER(4),
	duration_minutes Integer,
    country VARCHAR(300),
	CONSTRAINT movie_pk PRIMARY KEY (movie_id)
);

CREATE TABLE watched_user_movie (
	watched_user_movie_id INTEGER NOT NULL AUTO_INCREMENT,
    user_id INTEGER,
    movie_id INTEGER,
	CONSTRAINT watched_user_movie_pk PRIMARY KEY (watched_user_movie_id),
	FOREIGN KEY (movie_id) REFERENCES movie (movie_id) ON DELETE CASCADE,
	FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE
);

CREATE TABLE wanted_user_movie (
	wanted_user_movie_id INTEGER NOT NULL AUTO_INCREMENT,
    user_id INTEGER,
    movie_id INTEGER,
	CONSTRAINT wanted_user_movie_pk PRIMARY KEY (wanted_user_movie_id),
	FOREIGN KEY (movie_id) REFERENCES movie (movie_id) ON DELETE CASCADE,
	FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE
);

CREATE TABLE actor (
	actor_id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(150),
	nationality VARCHAR(150),
	born_date DATE,
	CONSTRAINT actor_pk PRIMARY KEY (actor_id)
);

CREATE TABLE director (
	director_id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(150),
	nationality VARCHAR(150),
	born_date DATE,
	CONSTRAINT director_pk PRIMARY KEY (director_id)
);

CREATE TABLE writer (
	writer_id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(150),
	born_date DATE,
	nationality VARCHAR(150),
	CONSTRAINT writer_pk PRIMARY KEY (writer_id)
);

CREATE TABLE actor_movie (
	actor_movie_id INTEGER NOT NULL AUTO_INCREMENT,
	actor_id INTEGER,
    movie_id INTEGER,
	CONSTRAINT actor_movie_id_pk PRIMARY KEY (actor_movie_id),
	FOREIGN KEY (actor_id) REFERENCES actor (actor_id) ON DELETE CASCADE,
	FOREIGN KEY (movie_id) REFERENCES movie (movie_id) ON DELETE CASCADE
);

CREATE TABLE director_movie (
	director_movie_id INTEGER NOT NULL AUTO_INCREMENT,
	director_id INTEGER,
    movie_id INTEGER,
	CONSTRAINT director_movie_pk PRIMARY KEY (director_movie_id),
	FOREIGN KEY (director_id) REFERENCES director (director_id) ON DELETE CASCADE,
	FOREIGN KEY (movie_id) REFERENCES movie (movie_id) ON DELETE CASCADE
);

CREATE TABLE writer_movie (
	writer_movie_id INTEGER NOT NULL AUTO_INCREMENT,
	writer_id INTEGER,
    movie_id INTEGER,
	CONSTRAINT writer_movie_pk PRIMARY KEY (writer_movie_id),
	FOREIGN KEY (writer_id) REFERENCES writer (writer_id) ON DELETE CASCADE,
	FOREIGN KEY (movie_id) REFERENCES movie (movie_id) ON DELETE CASCADE
);

CREATE TABLE user_list (
	list_id INTEGER NOT NULL AUTO_INCREMENT,
	user_id INTEGER,
    title VARCHAR(150),
    description MEDIUMTEXT,
	upvotes INTEGER,
	FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE,
	CONSTRAINT list_pk PRIMARY KEY (list_id)
);

CREATE TABLE list_movie (
	list_movie_id INTEGER NOT NULL AUTO_INCREMENT,
	movie_id INTEGER,
    list_id INTEGER,
	CONSTRAINT list_movie_pk PRIMARY KEY (list_movie_id),
	FOREIGN KEY (movie_id) REFERENCES movie (movie_id) ON DELETE CASCADE,
	FOREIGN KEY (list_id) REFERENCES user_list (list_id) ON DELETE CASCADE
);


