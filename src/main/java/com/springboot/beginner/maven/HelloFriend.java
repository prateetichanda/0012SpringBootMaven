package com.springboot.beginner.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloFriend {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "Hello Prateety from Spring Boot";
	}
	
	@RequestMapping("/")
	public String welcome()
	{
		return "index";
	}
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute user user)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adduser");
		mv.addObject("userReceived",user);
		System.out.println(user.fname+" "+user.lname);
		
		UserEntity u=new UserEntity();
		u.setFname(user.fname);
		u.setLname(user.lname);
		userRepository.save(u);
		return mv;
	}
}
