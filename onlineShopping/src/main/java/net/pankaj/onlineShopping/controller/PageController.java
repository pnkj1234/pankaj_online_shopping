package net.pankaj.onlineShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value ={"/","/home","/index"})
	public ModelAndView index() {
		System.out.println("in controller");
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting", "Welcome to the web MVC");
		return mv;
	}
	
}
