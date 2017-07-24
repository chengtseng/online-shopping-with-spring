package net.wei.onlineshopping.handler;

import net.wei.onlineshopping.Model.RegisterModel;
import net.wei.shoppingbackend.dto.Address;
import net.wei.shoppingbackend.dto.User;

import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {
	
	public RegisterModel init(){
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}
	
	public void addAddress(RegisterModel registerModel, Address address){
		registerModel.setAddress(address);
	}

}
