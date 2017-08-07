package net.wei.shoppingbackend.dao;

import java.util.List;

import net.wei.shoppingbackend.dto.Address;
import net.wei.shoppingbackend.dto.Cart;
import net.wei.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	User getUserByEmail(String email);
	
	boolean addAddress(Address address);
	
	Address getBillingAddress(User user);
	
	List<Address> getListOfShippingAddress(User user);

}
