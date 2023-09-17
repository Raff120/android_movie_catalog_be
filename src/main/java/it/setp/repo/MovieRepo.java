package it.setp.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import it.setp.entity.Movie;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, String> {

	List<Movie> findByGerneContainingIgnoreCase(String gerne);
	List<Movie> findByTitleContainingIgnoreCase(String title);
	List<Movie> findByTypeContainingIgnoreCase(String type);
	
	
	Page<Movie> findByTitleContainingIgnoreCase(String title, PageRequest page);
	Page<Movie> findByGerneContainingIgnoreCase(String gerne, PageRequest page);
}
