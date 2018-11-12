package com.rakesh.Mvc.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	UserService2 service;
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	  public ModelAndView showHome(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("home");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	
	 @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new User());
	    return mav;
	  }
	 @RequestMapping(value = "/welcome", method = RequestMethod.GET)
	  public ModelAndView showWelcome(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("welcome");
	    mav.addObject("login", new Login());
	    return mav;	  
}
	 @RequestMapping(value="/login",method=RequestMethod.POST)
	   public String executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login")Login login)
	  
	       {    ModelAndView model= null; 
	           try
	           {
	               boolean isSave =service.add(login);  
	               if(isSave) 
	               {
	                   System.out.println("login Saved Successful");  
	                   request.setAttribute("loggedInUser",login.getUsername());
	                   model = new ModelAndView("welcome");  
	               }            
	        }
	           catch(Exception e)
	           {
	                e.printStackTrace();
	           }
	           return "login";
}	
	 @RequestMapping(value="/register",method=RequestMethod.POST)
	   public String executeUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("register")User user)
	  
	       {    ModelAndView model= null; 
	           try
	           {
	               boolean isSave =service.add(user);  
	               if(isSave) 
	               {
	                   System.out.println("User Saved Successful");  
	                   request.setAttribute("registeredInUserregistered",user.getUsername());
	                   model = new ModelAndView("welcome");  
	               }            
	        }
	           catch(Exception e)
	           {
	                e.printStackTrace();
	           }
	           return "register";
}	
}
