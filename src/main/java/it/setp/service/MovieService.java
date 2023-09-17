package it.setp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;

import it.setp.entity.Movie;
import it.setp.entity.PagedMovie;

public interface MovieService {
	
	List<Movie> getAllMovie(); //Not Paged
	List<Movie> findByTitle(String title); //Not Paged
	List<Movie> findByGenre(String genre);
	List<Movie> findByType(String type);

	//Paged API
	PagedMovie getAllMoviePaged(int offset, int pageSize);
	PagedMovie findPaged(String title, PageRequest page);
	PagedMovie findGenrePaged(String title, PageRequest page);
	
	Optional<Movie> getMovieByID(String id);
	
	Movie saveMovie(Movie movie);
	Movie deleteMovie (String id); //to DO
		
}
