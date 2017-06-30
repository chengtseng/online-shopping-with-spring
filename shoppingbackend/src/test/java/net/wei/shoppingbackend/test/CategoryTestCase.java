package net.wei.shoppingbackend.test;

import static org.junit.Assert.assertEquals;
import net.wei.shoppingbackend.dao.CategoryDAO;
import net.wei.shoppingbackend.dto.Category;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private Category category;
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.wei.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	/*@Test
	public void testAddCategory(){
		category = new Category();
		category.setName("Labtop");
		category.setDescription("This is for Labtop.");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Sucessfully added a category inside the table!",true,categoryDAO.add(category));
	}
	
	@Test
	public void testGetCategory(){
		category = categoryDAO.get(3);
		assertEquals("Sucessfully fetched a category inside the table!","Labtop",category.getName());
	}
	
	@Test
	public void testUpdateCategory(){
		category = categoryDAO.get(3);
		
		category.setName("LALA");
		
		assertEquals("Sucessfully update a category inside the table!",true,categoryDAO.update(category));
	}
	@Test
	public void testDeleteCategory(){
		category = categoryDAO.get(3);		
		
		assertEquals("Sucessfully delete a category inside the table!",true,categoryDAO.delete(category));
	}
	
	@Test
	public void testListCategory(){
		assertEquals("Sucessfully fetch list of category inside the table!",2,categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory(){
		/*add*/
		category = new Category();
		category.setName("Labtop_test");
		category.setDescription("This is for Labtop_test.");
		category.setImageURL("CAT_1_test.png");
		assertEquals("Sucessfully added a category inside the table!",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television_test");
		category.setDescription("This is for Television_test.");
		category.setImageURL("CAT_2_test.png");
		assertEquals("Sucessfully added a category inside the table!",true,categoryDAO.add(category));
		
		/*update*/
		category = categoryDAO.get(2);
		
		category.setName("DVD");
		
		assertEquals("Sucessfully update a category inside the table!",true,categoryDAO.update(category));
		
		/*delete*/
		assertEquals("Sucessfully delete a category inside the table!",true,categoryDAO.delete(category));
		
		/*get list of category*/
		assertEquals("Sucessfully fetch list of category inside the table!",1,categoryDAO.list().size());
	}
	
	
	
	
}
