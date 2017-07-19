package net.wei.shoppingbackend.daoimpl;



import java.util.List;

import net.wei.shoppingbackend.dao.UserDAO;
import net.wei.shoppingbackend.dto.Address;
import net.wei.shoppingbackend.dto.Cart;
import net.wei.shoppingbackend.dto.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional//Transactional Context
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public boolean addUser(User user) {
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try{
			sessionFactory.getCurrentSession().persist(address);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public User getUserByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
													    
		try{

			Query query = sessionFactory.getCurrentSession().createQuery(selectQuery).setParameter("email", email);
			return (User)query.uniqueResult();
			
											  
						
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.print("Problem when fetching user");
			return null;
		}		
	}

	@Override
	public Address getBillingAddress(User user) {		
		String query = "FROM Address WHERE user = :userId AND billing=:isBilling";
		
		try{
			return (Address)sessionFactory.getCurrentSession().createQuery(query)
												.setParameter("userId", user.getId())
												.setParameter("isBilling", true)
												.uniqueResult();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Address> getListOfShippingAddress(User user) {
		String query = "FROM Address WHERE user.id = :userId AND shipping = :isShipping";
		
		try{
			//sessionFactory.getCurrentSession().createCriteria(List.class).add(Restrictions.ne("user", 1L)).list();
			return sessionFactory.getCurrentSession().createQuery(query)
												.setParameter("userId", user.getId())
												.setParameter("isShipping", true)
												.list();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	

}
