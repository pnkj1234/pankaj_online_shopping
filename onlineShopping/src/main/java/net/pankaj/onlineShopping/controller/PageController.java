package net.pankaj.onlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.pankaj.shoppingbackend.dao.CategoryDAO;
import net.pankaj.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
//Passing the list of Category
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);

		return mv;

	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		// System.out.println("in controller");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);

		return mv;

	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);

		return mv;

	}
	/*
	 * Methods to load all the products and based on category
	 */
	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProdutcs () {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);

		return mv;

	}
	
	
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		//CategoryDAO to fecth a single category
		Category category=null;
		category=categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);

		return mv;

	}
	 

}
