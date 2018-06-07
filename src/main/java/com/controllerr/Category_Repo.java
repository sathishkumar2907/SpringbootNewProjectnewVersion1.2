package com.controllerr;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface Category_Repo extends CrudRepository<Category_Model, Long>{
  
//	public Category_Model findCategory(String Cat_name);
	//Category_Model findBycategory(Iterable<Category_Model> iterable);
	public Category_Model findOne(Long id);

	public Response subcatModels(String name);
	 
	
	
	//@Query("SELECT c FROM category c where c.cat_id = :cat_id")
	//SELECT sub.cat_id FROM category as sub WHERE sub.cat_id=:cat_id
	//public List<Category_Model> findById(@Param("cat_id") Long cat_id);
	
}
