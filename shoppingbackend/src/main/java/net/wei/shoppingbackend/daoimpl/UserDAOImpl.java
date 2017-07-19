package net.wei.shoppingbackend.daoimpl;

import net.wei.shoppingbackend.dao.UserDAO;
import net.wei.shoppingbackend.dto.Address;
import net.wei.shoppingbackend.dto.Cart;
import net.wei.shoppingbackend.dto.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
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
	public boolean addCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}
	

}
