package net.wei.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlabalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handler_noHandlerFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed");
		
		mv.addObject("errorDescription", "The page you are looking for is not available");
				
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView hanlder_productNotFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The product is not available");
		
		mv.addObject("errorDescription", "The product you are looking for is not available");
				
		mv.addObject("title", "Product Unavailable");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView hanlder_Exception(Exception ex){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact Your Administrator");
		
		mv.addObject("errorDescription", ex.toString());
				
		mv.addObject("title", "Error");
		
		return mv;
	}
}
