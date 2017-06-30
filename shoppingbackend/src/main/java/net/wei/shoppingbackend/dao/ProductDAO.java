package net.wei.shoppingbackend.dao;

import java.util.List;

import net.wei.shoppingbackend.dto.Product;

public interface ProductDAO {
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductByCategory(int category);
	List<Product> getLatestActiveProducts(int count);
}
