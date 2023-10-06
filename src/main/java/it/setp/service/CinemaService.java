package it.setp.service;

import it.setp.entity.Cinema;

import java.util.List;
import java.util.Optional;

public interface CinemaService {

    List<Cinema> getAllCinemas(); //Not Paged
    List<Cinema> getCinemasByName(String name); //Not Paged

    Optional<Cinema> getCinemaByID(Integer id);

}
