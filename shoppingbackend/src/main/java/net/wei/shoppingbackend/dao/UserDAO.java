package net.wei.shoppingbackend.dao;

import net.wei.shoppingbackend.dto.Address;
import net.wei.shoppingbackend.dto.Cart;
import net.wei.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean addCart (Cart cart);

}
