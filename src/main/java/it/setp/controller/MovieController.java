package it.setp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.setp.entity.Movie;
import it.setp.entity.PagedMovie;
import it.setp.service.MovieService;

@Controller
@RequestMapping("/movie")
@CrossOrigin(origins = "http://127.0.0.1:4200")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@PostMapping
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
		
		ResponseEntity<Movie> response = null;
		
		Movie movieRes = service.saveMovie(movie);
		
		response = new ResponseEntity<Movie>(movieRes, HttpStatus.CREATED);
		
//		try {
//			
//			Movie movieRes = service.saveMovie(movie);
//			
//			response = new ResponseEntity<Movie>(movieRes, HttpStatus.CREATED);
//		}catch (Exception e) {
//			// TODO: handle exception
//			response = new ResponseEntity<Movie>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		
		return response;
	}
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovie(){
		
		ResponseEntity<List<Movie>> response = null;
		
		try {
			List<Movie> lst = service.getAllMovie();
			
			response = new ResponseEntity<List<Movie>>(lst, HttpStatus.OK);
			
		} catch (Exception e) {
			
			response = new ResponseEntity<List<Movie>>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return response;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Movie> getMovieByID(@PathVariable("id") String id){
		
		ResponseEntity<Movie> response = null;
		
		try {
			Optional<Movie> movieRes = service.getMovieByID(id);
			
			if(movieRes.isPresent())
				response = new ResponseEntity<Movie>(movieRes.get(), HttpStatus.OK);
			else
				response = new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
			
			
		} catch (Exception e) {
			response = new ResponseEntity<Movie>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@GetMapping(value = "/page/{offset}/{pageSize}")
	public ResponseEntity<PagedMovie> getAllPaged(@PathVariable("offset") int offset, @PathVariable("pageSize") int pageSize){
		
		ResponseEntity<PagedMovie> response = null;
		
		try {
			PagedMovie movieRes = service.getAllMoviePaged(offset, pageSize);
			
			response = new ResponseEntity<PagedMovie>(movieRes, HttpStatus.OK);
			
		} catch (Exception e) {
			
			response = new ResponseEntity<PagedMovie>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return response;
	}
	
	@GetMapping(value = "/find/{title}/page/{page}")
	public ResponseEntity<PagedMovie> findPaged(@PathVariable("title") String title, @PathVariable("page") int page){
		
		ResponseEntity<PagedMovie> response = null;
		
		try {
			PagedMovie movieRes = service.findPaged(title, PageRequest.of(page, 8));
			
//			if(lst.size()>0) {
				response = new ResponseEntity<PagedMovie>(movieRes, HttpStatus.OK);
//			}else {
//				response = new ResponseEntity<List<Movie>>(lst, HttpStatus.NOT_FOUND);
//			}
			
		} catch (Exception e) {
			
			response = new ResponseEntity<PagedMovie>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return response;
	}

	@GetMapping(value = "/find/{title}")
	public ResponseEntity<List<Movie>> findByTitle(@PathVariable("title") String title){

		ResponseEntity<List<Movie>> response = null;

		try {
			List<Movie> movieRes = service.findByTitle(title);

//			if(lst.size()>0) {
			response = new ResponseEntity<List<Movie>>(movieRes, HttpStatus.OK);
//			}else {
//				response = new ResponseEntity<List<Movie>>(lst, HttpStatus.NOT_FOUND);
//			}

		} catch (Exception e) {

			response = new ResponseEntity<List<Movie>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return response;
	}
	
	@GetMapping(value = "/genre/{gerne}/page/{page}")
	public ResponseEntity<PagedMovie> findGenrePaged(@PathVariable("gerne") String gerne, @PathVariable("page") int page){
		
		ResponseEntity<PagedMovie> response = null;
		
		try {
			PagedMovie movieRes = service.findGenrePaged(gerne, PageRequest.of(page, 8));
			
			response = new ResponseEntity<PagedMovie>(movieRes, HttpStatus.OK);
			
		} catch (Exception e) {
			
			response = new ResponseEntity<PagedMovie>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return response;
	}

	@GetMapping(value = "/genre/{genre}")
	public ResponseEntity<List<Movie>> findByGenre(@PathVariable("genre") String genre){

		ResponseEntity<List<Movie>> response = null;

		try {
			List<Movie> movieRes = service.findByGenre(genre);

//			if(lst.size()>0) {
			response = new ResponseEntity<List<Movie>>(movieRes, HttpStatus.OK);
//			}else {
//				response = new ResponseEntity<List<Movie>>(lst, HttpStatus.NOT_FOUND);
//			}

		} catch (Exception e) {

			response = new ResponseEntity<List<Movie>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return response;
	}

	@GetMapping(value = "/type/{type}")
	public ResponseEntity<List<Movie>> findByType(@PathVariable("type") String type){

		ResponseEntity<List<Movie>> response = null;

		try {
			List<Movie> movieRes = service.findByType(type);

//			if(lst.size()>0) {
			response = new ResponseEntity<List<Movie>>(movieRes, HttpStatus.OK);
//			}else {
//				response = new ResponseEntity<List<Movie>>(lst, HttpStatus.NOT_FOUND);
//			}

		} catch (Exception e) {

			response = new ResponseEntity<List<Movie>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return response;
	}

}
