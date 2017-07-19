package net.wei.shoppingbackend.daoimpl;



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
	

}
