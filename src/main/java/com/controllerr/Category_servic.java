package com.controllerr;

import java.util.List;

import org.springframework.stereotype.Service;


public interface Category_servic {
	
	public void save_category(Category_Model category); 
	//public Category_Model findCategory(String cat_name);
	public Category_Model findOne(Long id);
}
