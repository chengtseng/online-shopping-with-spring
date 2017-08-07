package net.wei.shoppingbackend.test;
import static org.junit.Assert.assertEquals;
import net.wei.shoppingbackend.dao.CartLineDAO;
import net.wei.shoppingbackend.dao.ProductDAO;
import net.wei.shoppingbackend.dao.UserDAO;
import net.wei.shoppingbackend.dto.Cart;
import net.wei.shoppingbackend.dto.CartLine;
import net.wei.shoppingbackend.dto.Product;
import net.wei.shoppingbackend.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartLineTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	private static User user = null;;
	private static Product product = null;;
	private static Cart cart  = null;;
	private static CartLine cartLine = null;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.wei.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		userDAO = (UserDAO)context.getBean("userDAO");		
	}
	
	@Test
	public void testAddNewCartLine(){
		user = userDAO.getUserByEmail("weichengtseng0731@gmail.com");
		
		cart = user.getCart();
		
		product = productDAO.get(1);
		
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setAvailable(true);
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("Error when adding cart line to the cart", true, cartLineDAO.add(cartLine));	
		
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		assertEquals("Fail to updat the cart", true, cartLineDAO.updateCart(cart));
		
	}
}
