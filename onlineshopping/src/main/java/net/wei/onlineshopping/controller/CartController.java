package net.wei.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//refer to spring-security.xml
@RequestMapping(value="/cart")
public class CartController {
	@RequestMapping("/show")
	public ModelAndView showCart(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "User Cart");
		mv.addObject("userClickedShowCart",true);
		mv.addObject("cartLines", null);
		
		return mv;
	}
}
