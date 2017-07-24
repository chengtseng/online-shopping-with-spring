package net.wei.onlineshopping.Model;

import java.io.Serializable;

import net.wei.shoppingbackend.dto.Address;
import net.wei.shoppingbackend.dto.User;

public class RegisterModel implements Serializable{
	private User user;
	private Address address;
		
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
