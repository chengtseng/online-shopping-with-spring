package net.wei.onlineshopping.controller;

import net.wei.shoppingbackend.dao.CategoryDAO;
import net.wei.shoppingbackend.dto.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");//1-param: view name
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);		
		mv.addObject("categories", categoryDAO.list());		
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");//1-param: view name
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");//1-param: view name
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*method to load product*/
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView("page");//1-param: view name
		mv.addObject("title", "All Products");			
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);	
		return mv;
	}
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id")int id){
		ModelAndView mv = new ModelAndView("page");//1-param: view name
		//use category DAO to fetch single category
		Category category = null;
		
		category = categoryDAO.get(id);	
		
		mv.addObject("title", category.getName());
		mv.addObject("userClickAllProduct", true);
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);		
		mv.addObject("userClickCategoryProducts", true);	
		return mv;
	}
	
	
/*Test*/	
//	@RequestMapping(value = {"/test2"})
//	/*http://localhost:8080/onlineshopping/test?greeting=Welcome
//	 * here the "?greeting=Welcome" would be optional.
//	 * */
//	public ModelAndView test2(@RequestParam(value="greeting", required=false)String greeting){
//		if(greeting == null){
//			greeting = "Hello Hello";
//		}
//		ModelAndView mv = new ModelAndView("page");//1-param: view name
//		mv.addObject("greeting", greeting);
//		return mv;
//	}
//	
//	@RequestMapping(value = {"/test/{greetingX}"})	
//	public ModelAndView test(@PathVariable("greetingX")String greeting){
//		if(greeting == null){
//			greeting = "Hello Hello";
//		}
//		ModelAndView mv = new ModelAndView("page");//1-param: view name
//		mv.addObject("greeting", greeting);
//		return mv;
//	}

}
