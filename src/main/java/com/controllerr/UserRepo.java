package com.controllerr;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends CrudRepository<User, Long> {
	//User findByConfirmationToken(String confirmationToken);
	public User findUserByEmail(String email);
	public User findById(Long id);
	
	
	@Query("SELECT new com.controllerr.User(u.id, u.name,u.email) FROM User u")
	public List<User> finddByQueries132();

}
