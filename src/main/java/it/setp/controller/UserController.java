package it.setp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.setp.entity.Movie;
import it.setp.entity.PagedMovie;
import it.setp.entity.PagedUser;
import it.setp.entity.User;
import it.setp.service.UserService;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:4200")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		ResponseEntity<User> response = null;
		
		User userRes = service.saveUser(user);
		
		if(userRes!=null){
			response = new ResponseEntity<User>(userRes, HttpStatus.CREATED);
		}
		else{
			response = new ResponseEntity<User>(userRes, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return response;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable("id") Integer id){
		
		ResponseEntity<User> response = null;
		
		try {
			Optional<User> userRes = service.getUserByID(id);
			
			if(userRes.isPresent())
				response = new ResponseEntity<User>(userRes.get(), HttpStatus.OK);
			else
				response = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			
			
		} catch (Exception e) {
			response = new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@GetMapping(value = "/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
		
		ResponseEntity<User> response = null;
		
		try {
			Optional<User> userRes = service.getUserByEmail(email);
			
			if(userRes.isPresent())
				response = new ResponseEntity<User>(userRes.get(), HttpStatus.OK);
			else
				response = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			
			
		} catch (Exception e) {
			response = new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@GetMapping(value = "/page/{offset}/{pageSize}")
	public ResponseEntity<PagedUser> getAllUserPaged(@PathVariable("offset") int offset, @PathVariable("pageSize") int pageSize){
		
		ResponseEntity<PagedUser> response = null;
		
		try {
			PagedUser movieRes = service.getAllUserPaged(offset, pageSize);
			
			response = new ResponseEntity<PagedUser>(movieRes, HttpStatus.OK);
			
		} catch (Exception e) {
			
			response = new ResponseEntity<PagedUser>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return response;
	}
	
	@PatchMapping(value = "/active/{id}")
	public ResponseEntity<User> activeUserByID(@PathVariable("id") Integer id){
		
		ResponseEntity<User> response = null;
		
		try {
			User userRes = service.activeUserByID(id);
			response = new ResponseEntity<User>(userRes, HttpStatus.OK);
			
			
		} catch (Exception e) {
			response = new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

}
