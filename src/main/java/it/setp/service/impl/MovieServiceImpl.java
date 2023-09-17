package it.setp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.setp.entity.Movie;
import it.setp.entity.PagedMovie;
import it.setp.repo.MovieRepo;
import it.setp.service.MovieService;

import javax.transaction.Transactional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieRepo repo;

	//Not Paged
	@Override
	public List<Movie> getAllMovie() {
		List<Movie> lst= repo.findAll();
		return lst;
	}

	@Override
	public PagedMovie getAllMoviePaged(int offset, int pageSize) {

		PagedMovie movieRes = new PagedMovie();

		movieRes.setNumPag(repo.findAll(PageRequest.of(offset, pageSize)).getTotalPages());
		movieRes.setMovie(repo.findAll(PageRequest.of(offset, pageSize)).toList());

		return movieRes;
	}

	@Override
	public PagedMovie findPaged(String title, PageRequest page) {

		PagedMovie movieRes = new PagedMovie();

		movieRes.setNumPag(repo.findByTitleContainingIgnoreCase(title, page).getTotalPages());
		movieRes.setMovie(repo.findByTitleContainingIgnoreCase(title, page).toList());

		return movieRes;
	}

	@Override
	public List<Movie> findByTitle(String title) {

		List<Movie> lst = repo.findByTitleContainingIgnoreCase(title);

		return lst;
	}

	@Override
	public PagedMovie findGenrePaged(String gerne, PageRequest page) {

		PagedMovie movieRes = new PagedMovie();

		movieRes.setNumPag(repo.findByGerneContainingIgnoreCase(gerne, page).getTotalPages());
		movieRes.setMovie(repo.findByGerneContainingIgnoreCase(gerne, page).toList());

		return movieRes;
	}

	@Override
	public List<Movie> findByGenre(String genre) {

		List<Movie> lst = repo.findByGerneContainingIgnoreCase(genre);

		return lst;
	}

	@Override
	public List<Movie> findByType(String type) {

		List<Movie> lst = repo.findByTypeContainingIgnoreCase(type);

		return lst;
	}

	@Override
	public Optional<Movie> getMovieByID(String id) {
		Optional<Movie> movieRes = repo.findById(id);
		return movieRes;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		System.out.println("----------- LOG ------------"+movie);
		Movie movieRes = repo.save(movie);
		return movieRes;
	}

	@Override
	public Movie deleteMovie(String id) {
		Movie deletedMovie = getMovieByID(id).orElse(null);
		
		if (deletedMovie !=null) {
			repo.deleteById(id);
		}
		return deletedMovie;
	}
	


	

	


}
