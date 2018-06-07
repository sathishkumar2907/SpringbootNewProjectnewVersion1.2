package com.controllerr;



import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserControl {
	
	@Autowired
	private UserServ userserv;
	
	 /* @ModelAttribute("user")
	    public UserRegistrationDto userRegistrationDto() {
	        return new UserRegistrationDto();
	    }*/
	/*@Autowired
	private EmailService emailService;
	*/
	
	List<User> list;
	 
	@RequestMapping("/")
	    public String index() {
		    return "index";
	    }
	
	@RequestMapping(value="/save")
    public String saveemp() {
	    return "save";
    }

	    @RequestMapping(value="/save1",method=RequestMethod.POST)  
	   @ResponseBody
	    public Response save(@RequestBody @ModelAttribute @Valid User user,BindingResult result, ModelMap model){  

	    	  Response respone=new Response();
	    	  
	    	 
	    	  User user1 = userserv.findUserByEmail(user.getName());
	    	  System.out.println("user1====>"+user1);
	    		 
	    	  if (user1 != null){
	              result.rejectValue("name",null,"There is already an account registered with that name");
	          }
	    		
	    	  User user2=userserv.findUserByEmail(user.getEmail());
	    	  System.out.println("user1====>"+user2);
	    	 
	    	 if (user2 != null){
	              result.rejectValue("email",null,"There is already an account registered with that email");
	           }
	    	
	        if(result.hasErrors()){
	     
	        	//Get error message
	            Map<String, String> errors = result.getFieldErrors().stream()
	                  .collect(
	                        Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
	                    );
	            
	            respone.setValidated(false);
	            respone.setErrorMessages(errors);
	          
	        }else{
	       
	            ModelAndView modelAndView = new ModelAndView();
	            //userserv.save(new Role(user.getName(), user.getRoles()));
	        	userserv.save(user);
	       
	        	Map<String, String> map=new HashMap<>();
	            map.put("success", "successfully");
	            
	            respone.setValidated(true);
	            respone.setErrorMessages(map);
	            respone.setUser(user);
	            //respone.setData(user);
	           // respone.setErrorMessages("user add ");
	            
	            modelAndView.addObject("successMessage", "User has been registered successfully");
	            System.out.println("userid==>"+user.getId().toString());
	          
	           }
	            return respone;
	       }
	    
	    
	   /* @RequestMapping(value="/save",method=RequestMethod.GET)
	     public String showForm(){
	           return "save";
	     }*/

	    	
	    
	  @RequestMapping(value="/save", method=RequestMethod.GET)
	   @ResponseBody
		public Response getAllEmployees(ModelMap model) throws JSONException{
	    
		    Response respone=new Response();
	    
	    	List<User> user_list=userserv.getAllEmployees();
	    	System.out.println("user_list-->"+user_list);
	     	
	    
	    	
	    	model.addAttribute("posts",user_list);
	    	respone.setData(user_list);
	    	respone.setValidated(true);
	    
			return respone;
		}
	    	
	    //	userserv.save(user);
	    /*  ModelAndView modelAndView = new ModelAndView();  
	        modelAndView.setViewName("save");      
	        modelAndView.addObject("user", user); 
	        
	        System.out.println("userid==>"+user.getId().toString());
			
	       // return new Response("Done", modelAndView);
	        
	    return modelAndView;*/
	    
	  //  }  
	  
	  //=======================Important image upload===================================
	 /* @RequestMapping(value="/fileupload", method = RequestMethod.POST)
		//@ResponseBody
		public ResponseEntity<FileInfo> upload(HttpServletRequest servletRequest,@RequestParam("file") MultipartFile inputFile){
			//servletRequest.getServletContext().getRealPath("")
			
			
		 FileInfo fileInfo=new FileInfo();
		 HttpHeaders headers =new HttpHeaders();
		 if (!inputFile.isEmpty()) {
		 try {
			    String originalFilename = inputFile.getOriginalFilename();
			    String path="D:\\Springworkspace\\NewProject\\src\\main\\java\\com\\run";
			    System.out.println("file upload===========>"+path+ File.separator + originalFilename);
			    File destinationFile = new File(path+ File.separator + originalFilename);
			    inputFile.transferTo(destinationFile);
			    fileInfo.setFileName(destinationFile.getPath());
			    fileInfo.setFileSize(inputFile.getSize());
			    headers.add("File Uploaded Successfully - ", originalFilename);
			    return new ResponseEntity<FileInfo>(fileInfo, headers, HttpStatus.OK);
			   
		 } catch (Exception e) {    
			    return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
		 }
		
		 }else{
			   return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
		}
	   }*/
	 //========================================================== 
	  
     } 
  