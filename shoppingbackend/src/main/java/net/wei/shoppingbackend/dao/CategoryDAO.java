package net.wei.shoppingbackend.dao;

import java.util.List;

import net.wei.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	//get a list of category
	List<Category> list();
	//get a category
	Category get(int id);
	//adding a new Category
	boolean add(Category category);
	//updating a Category
	boolean update(Category category);
	//delete a Category
	boolean delete(Category category);
}
