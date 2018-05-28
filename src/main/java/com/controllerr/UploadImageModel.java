package com.controllerr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="files")
public class UploadImageModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@NotEmpty(message="file should not be Empty")
	@Column(name="file_name")
	private String multipartFile;
	
	public UploadImageModel(){}
	
	public UploadImageModel(Long id, String multipartFile) {
		super();
		this.id = id;
		this.multipartFile = multipartFile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(String multipartFile) {
		this.multipartFile = multipartFile;
	}

	@Override
	public String toString() {
		return "UploadImageModel [id=" + id + ", multipartFile=" + multipartFile + "]";
	}
 }
