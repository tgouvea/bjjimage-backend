package com.bjjimage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private UserDetailsService userService;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();

		 if(SecurityContextHolder.getContext().getAuthentication() != null &&
				 SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
				 //when Anonymous Authentication is enabled
				 !(SecurityContextHolder.getContext().getAuthentication()
				          instanceof AnonymousAuthenticationToken)){

				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				UserDetails user = userService.loadUserByUsername(auth.getName());
				modelAndView.addObject("userName", "Bem vindo " + user.getUsername() + " : " + user.getAuthorities() + " (" + user.getUsername() + ")");
				modelAndView.addObject("adminMessage","Conteúdo disponível apenas para usuários logados");
				modelAndView.setViewName("index");


		 }else {

				modelAndView.setViewName("login");

		}

		return modelAndView;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
			 
		modelAndView.setViewName("index");


		return modelAndView;
	}

	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage () {
		
		ModelAndView modelAndView = new ModelAndView();
		
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(null, null, auth);;
	    }
	    
		modelAndView.setViewName("index");
	    
	    return modelAndView;//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}



	@RequestMapping(value="/index", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails user = userService.loadUserByUsername(auth.getName());
		modelAndView.addObject("userName", "Bem vindo " + user.getUsername() + " : " + user.getAuthorities() + " (" + user.getUsername() + ")");
		modelAndView.addObject("adminMessage","Conteúdo disponível apenas para usuários logados");
		modelAndView.setViewName("index");
		return modelAndView;
	}

}