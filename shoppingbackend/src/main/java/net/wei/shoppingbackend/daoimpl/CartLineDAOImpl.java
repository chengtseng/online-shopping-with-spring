package net.wei.shoppingbackend.daoimpl;

import java.util.List;

import net.wei.shoppingbackend.dao.CartLineDAO;
import net.wei.shoppingbackend.dto.Cart;
import net.wei.shoppingbackend.dto.CartLine;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {
	@Autowired
	private SessionFactory session;

	@Override
	public CartLine get(int id) {		
		return (CartLine)session.getCurrentSession().get(CartLine.class, id);
	}

	@Override
	public boolean add(CartLine newCartLine) {
		try{
			session.getCurrentSession().persist(newCartLine);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(CartLine cartLine) {
		try{
			session.getCurrentSession().update(cartLine);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(CartLine cartLine) {
		try{
			session.getCurrentSession().delete(cartLine);
			return true;			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CartLine> list(int cartId) {
		String query = "FROM CartLine WHERE cartId= :cartId";
		return session.getCurrentSession().createQuery(query).setParameter("cartId", cartId).list();									  
	
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND isAvailable = :available";
		return session.getCurrentSession().createQuery(query)
				.setParameter("cartId", cartId)
				.setParameter("available", true)
				.list();
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
		try{
			return (CartLine)session.getCurrentSession().createQuery(query)
					.setParameter("cartId", cartId)
					.setParameter("productId", productId).uniqueResult();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean updateCart(Cart cart) {
		try{
			session.getCurrentSession().update(cart);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}

}
