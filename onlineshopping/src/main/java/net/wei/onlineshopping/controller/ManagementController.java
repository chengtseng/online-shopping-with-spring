package net.wei.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.wei.onlineshopping.util.FileUploadUtility;
import net.wei.shoppingbackend.dao.CategoryDAO;
import net.wei.shoppingbackend.dao.ProductDAO;
import net.wei.shoppingbackend.dto.Category;
import net.wei.shoppingbackend.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired 
	private ProductDAO productDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required = false)String operation){
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		//product to page
		Product newProduct = new Product();
		newProduct.setSupplierId(1);
		newProduct.setActive(true);
		mv.addObject("product", newProduct);		
		
		if(operation != null && operation.equals("product")){
			mv.addObject("message", "product submitted succesfully");
		}		
		return mv;		
	}
	//enrich model and request implicitly. see 15.3.2.3 Supported handler method arguments and return types
	//http://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping-arguments
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product")Product modifiedProduct, 
										  BindingResult results, 
										  Model model, 					
										  HttpServletRequest request){
		//check if there are any error
		if(results.hasErrors()){			
			model.addAttribute("userClickManageProducts", true);
			
			model.addAttribute("title", "Manage Products");
			
			return "page";
		}
		
		productDAO.add(modifiedProduct);
		
		//if some file available
		if(!modifiedProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request, modifiedProduct.getFile(), modifiedProduct.getCode());
		}
		
		//redirect
		return "redirect:/manage/products?operation=product";
	}
	 
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDao.list();
	}
}
