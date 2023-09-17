package it.setp.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.setp.entity.PagedUser;
import it.setp.entity.User;
import it.setp.repo.UserRepo;
import it.setp.service.UserService;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo repo;

	@Override
	public Optional<User> getUserByID(Integer id) {
		Optional<User> userRes = repo.findById(id);
		return userRes;
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		Optional<User> userRes = repo.findByEmail(email);
		return userRes;
	}

	@Override
	public User saveUser(User user) {
		User userRes = null;
		Integer eta=( LocalDate.now().getYear() - user.getData().toLocalDate().getYear() );

		//Mi assicuro che sia maggiorenne.
		if( eta==18 ){

			if( LocalDate.now().getMonth().getValue() <= user.getData().toLocalDate().getMonth().getValue() ){

				if ( LocalDate.now().getMonth().getValue() < user.getData().toLocalDate().getMonth().getValue() ){
					eta--;
				}

				if( ( LocalDate.now().getMonth().getValue() == user.getData().toLocalDate().getMonth().getValue() ) &&
					( LocalDate.now().getDayOfMonth() < user.getData().toLocalDate().getDayOfMonth() ) ){

					eta--;
				}
			}

			System.out.println(eta);
		}

		if(eta>=18 && eta<=120){
			userRes = repo.save(user);
		}

		return userRes;
	}

	@Override
	public PagedUser getAllUserPaged(int offset, int pageSize) {
		
		PagedUser userRes = new PagedUser();
		
		userRes.setNumPag(repo.findAll(PageRequest.of(offset, pageSize)).getTotalPages());
		userRes.setUser(repo.findAll(PageRequest.of(offset, pageSize)).toList());
		
		return userRes;
	}

	@Override
	public User activeUserByID(Integer id) {
		User userRes = getUserByID(id).get();
		
		if(userRes.isActive()) {
			userRes.setActive(false);
		}
		else {
			userRes.setActive(true);
		}
		
		repo.save(userRes);
		
		return userRes;
	}

}
