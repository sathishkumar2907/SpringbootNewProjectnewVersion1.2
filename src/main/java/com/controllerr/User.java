package com.controllerr;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;



@JsonInclude(JsonInclude.Include.NON_NULL)//====To remove the null elements in the json response===
@Entity
@Table(name = "user")
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	// @JsonIdentityReference(alwaysAsId = true)
	// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private Long id;
	 
	@NotEmpty(message="Enter name.")
	private String name;  
	

	@NotEmpty(message="Enter email.")
    private String email;
	 
	 
    @ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	 
public User(){}
   
public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		
}

public User(Long id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

@Override
public String toString() {
	return "id=" + id + ", name=" + name + ", email=" + email + "";
}


}
