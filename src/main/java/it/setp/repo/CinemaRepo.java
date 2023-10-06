package it.setp.repo;

import it.setp.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRepo extends JpaRepository<Cinema, Integer> {
    List<Cinema> findByNameContainingIgnoreCase(String name);
}
