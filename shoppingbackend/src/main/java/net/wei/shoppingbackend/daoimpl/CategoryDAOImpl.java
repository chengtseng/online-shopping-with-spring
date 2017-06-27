package net.wei.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.wei.shoppingbackend.dao.CategoryDAO;
import net.wei.shoppingbackend.dto.Category;

import org.springframework.stereotype.Repository;
@Repository("categoryDAO") //give names
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> cats = new ArrayList<>();
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDecription("This is for television.");
		category.setImageURL("CAT_1.png");
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("mobile");
		category2.setDecription("This is for mobile.");
		category2.setImageURL("CAT_2.png");
		
		Category category3 = new Category();
		category3.setId(3);
		category3.setName("DVD");
		category3.setDecription("This is for DVD.");
		category3.setImageURL("CAT_3.png");
		
		cats.add(category);
		cats.add(category2);
		cats.add(category3);
	}
	
	@Override
	public List<Category> list() {		
		return cats;
	}

	@Override
	public Category get(int id) {
		for(Category c : cats){
			if(c.getId() == id) return c;
		}
		return null;
	}
	

}
