package it.setp.service.impl;

import it.setp.entity.Cinema;
import it.setp.repo.CinemaRepo;
import it.setp.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    CinemaRepo repo;


    @Override
    public List<Cinema> getAllCinemas() {
        return repo.findAll();
    }

    @Override
    public List<Cinema> getCinemasByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Optional<Cinema> getCinemaByID(Integer id) {
        return repo.findById(id);
    }
}
