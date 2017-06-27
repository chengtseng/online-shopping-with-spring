package net.wei.shoppingbackend.dao;

import java.util.List;

import net.wei.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);

}
