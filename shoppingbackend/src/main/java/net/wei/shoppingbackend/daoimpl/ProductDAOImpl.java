package net.wei.shoppingbackend.daoimpl;

import java.util.List;

import net.wei.shoppingbackend.dao.ProductDAO;
import net.wei.shoppingbackend.dto.Product;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId) {
		try{
			return (Product)sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}catch(Exception ex){
			ex.printStackTrace();		
		}
		return null;
	}

	@Override
	public List<Product> list() {
		String query = "FROM Product";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}

	@Override
	public boolean add(Product product) {
		try{
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try{
			product.setActive(false);			
			return update(product);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		
		return (List<Product>) sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts)
						.setParameter("active", true).list();
						
	}

	@Override
	public List<Product> listActiveProductByCategory(int cat) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return (List<Product>) sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory)
						.setParameter("active", true)
						.setParameter("categoryId", cat).list();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String selectLatestActiveProducts = "FROM Product WHERE active = :active ORDER BY id";
		return (List<Product>) sessionFactory
				.getCurrentSession()
					.createQuery(selectLatestActiveProducts)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.list();
	}




}
