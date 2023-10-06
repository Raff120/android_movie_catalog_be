package it.setp.controller;

import it.setp.entity.Cinema;
import it.setp.entity.Movie;
import it.setp.service.CinemaService;
import it.setp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cinema")
@CrossOrigin(origins = "http://127.0.0.1:4200")
public class CinemaController {

    @Autowired
    CinemaService service;

    @GetMapping
    public ResponseEntity<List<Cinema>> getAllCinemas(){

        ResponseEntity<List<Cinema>> response = null;

        try {
            List<Cinema> lst = service.getAllCinemas();

            response = new ResponseEntity<List<Cinema>>(lst, HttpStatus.OK);

        } catch (Exception e) {

            response = new ResponseEntity<List<Cinema>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return response;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cinema> getCinemaByID(@PathVariable("id") Integer id){

        ResponseEntity<Cinema> response = null;

        try {
            Optional<Cinema> movieRes = service.getCinemaByID(id);

            if(movieRes.isPresent())
                response = new ResponseEntity<Cinema>(movieRes.get(), HttpStatus.OK);
            else
                response = new ResponseEntity<Cinema>(HttpStatus.NOT_FOUND);


        } catch (Exception e) {
            response = new ResponseEntity<Cinema>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @GetMapping(value = "/find/{name}")
    public ResponseEntity<List<Cinema>> findCinemaByName(@PathVariable("name") String name){

        ResponseEntity<List<Cinema>> response = null;

        try {
            List<Cinema> movieRes = service.getCinemasByName(name);

//			if(lst.size()>0) {
            response = new ResponseEntity<List<Cinema>>(movieRes, HttpStatus.OK);
//			}else {
//				response = new ResponseEntity<List<Movie>>(lst, HttpStatus.NOT_FOUND);
//			}

        } catch (Exception e) {

            response = new ResponseEntity<List<Cinema>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return response;
    }


}
