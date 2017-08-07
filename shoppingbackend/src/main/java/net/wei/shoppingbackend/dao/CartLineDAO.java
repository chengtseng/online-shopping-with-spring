package net.wei.shoppingbackend.dao;

import java.util.List;

import net.wei.shoppingbackend.dto.Cart;
import net.wei.shoppingbackend.dto.CartLine;

public interface CartLineDAO {
	public CartLine get(int id);
	public boolean add(CartLine newCartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	boolean updateCart (Cart cart);
}
