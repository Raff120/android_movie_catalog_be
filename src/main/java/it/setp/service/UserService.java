package it.setp.service;

import java.util.Optional;

import it.setp.entity.PagedUser;
import it.setp.entity.User;

public interface UserService {
	
	Optional<User> getUserByID(Integer id);
	Optional<User> getUserByEmail(String email);
	
	PagedUser getAllUserPaged(int offset, int pageSize);
	
	User saveUser(User user);
	User activeUserByID(Integer id);

}
