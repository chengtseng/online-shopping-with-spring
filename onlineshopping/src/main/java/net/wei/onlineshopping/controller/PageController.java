package net.wei.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");//1-param: view name
		mv.addObject("greeting", "Welcome to Spring MVC");
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
