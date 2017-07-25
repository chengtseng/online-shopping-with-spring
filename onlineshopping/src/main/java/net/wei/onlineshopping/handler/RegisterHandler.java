package net.wei.onlineshopping.handler;

import net.wei.onlineshopping.Model.RegisterModel;
import net.wei.shoppingbackend.dao.UserDAO;
import net.wei.shoppingbackend.dto.Address;
import net.wei.shoppingbackend.dto.Cart;
import net.wei.shoppingbackend.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {
	
	@Autowired
	UserDAO userDAO;
	
	public RegisterModel init(){
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}
	
	public void addAddress(RegisterModel registerModel, Address address){
		registerModel.setAddress(address);
	}
	
	public String saveAll(RegisterModel model){
		String transition = "success";
		
		User user = model.getUser();
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}		
		userDAO.addUser(user);
		
		Address address = model.getAddress();
		address.setUser(user);
		address.setBilling(true);
		
		userDAO.addAddress(address);
		
		return transition;
	}
	
	public String validateUser(User user, MessageContext mc){
		String result = "success";
		
		if(!user.getPassword().equals(user.getConfirmPassword())){
			result="failure";
			mc.addMessage(new MessageBuilder()
							.error()
							.source("confirmPassword")
							.defaultText("Naughty!! You enterned different passwords, try again.")
							.build());			
		}
		
		if(userDAO.getUserByEmail(user.getEmail())!= null){
			result="failure";
			mc.addMessage(new MessageBuilder()
			.error()
			.source("email")
			.defaultText("The email existes in our database, do you want to log in instead?")
			.build());
		}
		
		return result;
	}

}
