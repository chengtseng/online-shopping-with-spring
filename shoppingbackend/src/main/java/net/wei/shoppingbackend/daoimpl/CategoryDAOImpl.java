package net.wei.shoppingbackend.daoimpl;

import java.util.List;

import net.wei.shoppingbackend.dao.CategoryDAO;
import net.wei.shoppingbackend.dto.Category;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("categoryDAO") //give names
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory );
		query.setParameter("active", true);
		return  query.list();
	}

	@Override
	public Category get(int id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override	
	public boolean add(Category category) {
		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}		
	}

	@Override	
	public boolean update(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}	
	}

	@Override	
	public boolean delete(Category category) {
		category.setActive(false);
		
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	

}
