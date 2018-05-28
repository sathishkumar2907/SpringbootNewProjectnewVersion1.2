package com.controllerr;

import java.util.List;

public interface UserServ {

	public void save(User user);

	public User findUserByEmail(String name);
	
	public List<User> getAllEmployees();
	public User findById(Long id);

//	public void sendEmail(SimpleMailMessage registrationEmail);

	
	
}
