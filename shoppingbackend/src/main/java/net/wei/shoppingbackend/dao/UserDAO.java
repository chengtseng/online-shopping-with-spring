package net.wei.shoppingbackend.dao;

import net.wei.shoppingbackend.dto.Address;
import net.wei.shoppingbackend.dto.Cart;
import net.wei.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	User getUserByEmail(String email);
	
	boolean addAddress(Address address);
	
	boolean updateCart (Cart cart);

}
