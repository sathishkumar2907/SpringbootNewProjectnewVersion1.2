package com.controllerr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServi implements UserServ{

	List<User> li;
	
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo rolerepo;
	
	
	public void  save(User user){
		Role userRole = rolerepo.findByRole("ADMIN");

		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	    userRepo.save(user);
	   // System.out.println(userRepo.save(user));
	}

	public User findUserByEmail(String name) {
		return userRepo.findUserByEmail(name);
	}
	
	public User findById(Long id) {
		return userRepo.findById(id);
	}

	public List<User> getAllEmployees() {
		//return (List<User>) userRepo.findAll();
		 
		return userRepo.finddByQueries132();
	}
	
	/*public User findByConfirmationToken(String confirmationToken) {
		return userRepo.findByConfirmationToken(confirmationToken);
		
	}*/
		
}
