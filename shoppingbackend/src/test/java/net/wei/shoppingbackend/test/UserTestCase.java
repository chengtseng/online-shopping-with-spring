package net.wei.shoppingbackend.test;

import static org.junit.Assert.*;
import net.wei.shoppingbackend.dao.UserDAO;
import net.wei.shoppingbackend.dto.Address;
import net.wei.shoppingbackend.dto.Cart;
import net.wei.shoppingbackend.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private Cart cart= null;
	private User user = null;
	private Address address = null;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.wei.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");		
	}
	
	@Test
	public void testAdd(){
		user = new User();
		user.setFirstName("test");
		user.setLastName("test");
		user.setEmail("test@gmail.com");
		user.setPhone("test");
		user.setRole("USER");
		user.setPassword("1111");
		
		assertEquals("Fail to add user", true, userDAO.addUser(user));
		
		//billing Address
		address = new Address();
		address.setAddressLineOne("tet1");
		address.setAddressLineTwo("tet2");
		address.setCity("test");
		address.setState("test");
		address.setCountry("test");
		address.setZipCode("test");
		address.setBilling(true);
		address.setBilling(true);
		
		//link the user with the address
		address.setUserId(user.getId());
		assertEquals("Fail to add address to the user", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")){
			cart = new Cart();
			cart.setUserId(user.getId());
			assertEquals("Fail to add cart to the user", true, userDAO.addCart(cart));
			
			address = new Address();
			address.setAddressLineOne("tet1_Shipping");
			address.setAddressLineTwo("tet2_Shipping");
			address.setCity("test_Shipping");
			address.setState("test_Shipping");
			address.setCountry("test_Shipping");
			address.setZipCode("test_Shipping");
			address.setBilling(false);
			address.setShipping(true);
			
			address.setUserId(user.getId());
			
			assertEquals("Fail to add address to the user", true, userDAO.addAddress(address));
		}
		
		
		
		
	}
}
