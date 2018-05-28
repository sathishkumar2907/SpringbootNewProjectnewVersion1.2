package com.controllerr;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadImageControll {

	@Autowired
	public UploadImageServ uploadimageserv;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="/addimage",headers=("content-type=multipart/*"), method=RequestMethod.POST)
	//@ResponseBody
	public ResponseEntity upload(@RequestParam("file") MultipartFile inputFile, @RequestParam("id") Long id, HttpServletResponse response, HttpServletRequest request){
		
		  UploadImageModel fileInfo = new UploadImageModel();
		  HttpHeaders headers = new HttpHeaders();
		  Response respone=new Response();
	    try {
	      /*MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
	        Iterator<String> it=multipartRequest.getFileNames();
	        MultipartFile multipart=multipartRequest.getFile(it.next());
	        String fileName=id+".png";
	        String imageName = fileName;*/
	    	
	    	/*Path path = Paths.get("upload-dir");
	    	System.out.println("sathiash===>"+path);*/
	    	
	    	 /*String path=System.getProperty("user.dir");
	    	 System.out.println("new path--->"+path);*/
	    	
            //String path="D:\\Springworkspace\\NewProject\\Image\\";
        	
	    	 String path = "C:\\xampp\\htdocs\\NewProject\\Image";
	        String originalFilename = inputFile.getOriginalFilename();
	        
	        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss"); // add S if you need milliseconds
	        String filename = df.format(new Date())+ "." + "jpg";
	        System.out.println("filename=====>"+filename);
	        
	       // File destinationFile = new File(path, originalFilename);
	        File destinationFile = new File(path, filename);
        	System.out.println("path=====> "+destinationFile);
        	
	        
	        inputFile.transferTo(destinationFile);
	        //fileInfo.setMultipartFile(destinationFile.getPath());
	        //fileInfo.setFileSize(inputFile.getSize());
	        
	        fileInfo.setMultipartFile("\\Image\\"+destinationFile.getName());
	        
	       
	        
	        uploadimageserv.save_uploadimage(fileInfo);
	        
	        headers.add("File Uploaded Successfully - ", originalFilename);

	        return new ResponseEntity<UploadImageModel>(fileInfo, headers, HttpStatus.OK);
	    
         //   return respone;
	    } catch (Exception e) {
	         e.printStackTrace();
	        return new ResponseEntity("Upload fialed", HttpStatus.BAD_REQUEST);
	    }
	}
  }
