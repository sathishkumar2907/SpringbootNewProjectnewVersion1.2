package com.controllerr;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class Category_servImp implements Category_servic{

	@Autowired
	private Category_Repo catRepos;
	
	//@PersistenceContext
	//EntityManager entityManager;

	
	public void save_category(Category_Model category) {
		
	/*	for(Category_Model resource: category.getResources()){        
	        resource.s
	    }
		*/
		//entityManager.persist(category);
		catRepos.save(category);
	 }


	@Override
	public Category_Model findOne(Long id) {
		
		return catRepos.findOne(id);
	}

	/*public void addRole(Role role) {


    for(Resource resource: role.getResources()){        
        resource.setRole(role); 
    }

    roleRepository.save(role);
}*/
	
	/*public Category_Model findCategory(String cat_name) {
		return catRepos.findCategory(cat_name);
	}*/

}
