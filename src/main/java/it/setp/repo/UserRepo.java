package it.setp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.setp.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);
//	User updateUserById(Integer id, User user);

}
