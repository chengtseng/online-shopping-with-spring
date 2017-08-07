package net.wei.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.wei.onlineshopping.exception.ProductNotFoundException;
import net.wei.shoppingbackend.dao.CategoryDAO;
import net.wei.shoppingbackend.dao.ProductDAO;
import net.wei.shoppingbackend.dto.Category;
import net.wei.shoppingbackend.dto.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	private static final Logger Logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");//1-param: view name
		mv.addObject("title", "Home");
		
		Logger.info("categories", categoryDAO.list());
		Logger.debug("userClickHome", true);		
		
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
		//mv.addObject("Hello", "HelloHello");
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
	
	@RequestMapping(value = {"/show/{id}/product"})
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		
		//update product view
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name="error", required=false)String error,
							  @RequestParam(name="logout", required=false)String logout){		
		
		ModelAndView mv = new ModelAndView("login");
		
		if(logout != null){
			mv.addObject("logout", "The username is logged out successfully.");
		}
		
		if(error != null){
			mv.addObject("message", "The username or password is invalid.");
		}
		
		mv.addObject("title", "log in");
		
		
		return mv;
	}

	
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied(){		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "403 - Access Denied");
		mv.addObject("errorDescription", "You are not authorized to view the page");
		return mv;
	}
	
	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		
 		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}


}
