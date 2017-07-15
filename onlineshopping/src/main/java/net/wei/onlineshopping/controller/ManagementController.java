package net.wei.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.wei.onlineshopping.util.FileUploadUtility;
import net.wei.onlineshopping.validator.ProductValidator;
import net.wei.shoppingbackend.dao.CategoryDAO;
import net.wei.shoppingbackend.dao.ProductDAO;
import net.wei.shoppingbackend.dto.Category;
import net.wei.shoppingbackend.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired 
	private ProductDAO productDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required = false)String operation, ModelMap model){
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		System.out.print((List)model.get("categories"));
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
		//Custom Spring Validator
		new ProductValidator().validate(modifiedProduct, results);
		
		//Check if there are any error (hibernate validator) + Spring(the result return from the last command)
		if(results.hasErrors()){			
			//another way to return a page with model
			//need to set model to render the page. Cannot only do redirect.
			model.addAttribute("userClickManageProducts", true);
			
			model.addAttribute("title", "Manage Products");
			
			model.addAttribute("message", "Validation fail, please check the error message below.");
			
			return "page";
		}
		
		//no error, add product to database
		productDAO.add(modifiedProduct);
		
		//if image file available, upload image to both project and server directory
		if(!modifiedProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request, modifiedProduct.getFile(), modifiedProduct.getCode());
		}
		
		//redirect
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable("id") int id){
		Product product =  productDAO.get(id);
		
		if(product != null){
			boolean isActive = product.isActive();
			product.setActive(!isActive);
			productDAO.update(product);
		}
		String msg = product.isActive() ? " is activated" : " is deactivated"; 
		
		return "Product Name: " + product.getName()+" Product Id: " +id + msg;
	}
	 
	//display category list
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDao.list();
	}
}
