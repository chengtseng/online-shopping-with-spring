package net.wei.shoppingbackend.test;

import static org.junit.Assert.assertEquals;
import net.wei.shoppingbackend.dao.ProductDAO;
import net.wei.shoppingbackend.dto.Product;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private Product category;
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.wei.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");		
	}
	
	@Test
	public void testCRUDCategory(){
		Product pro_test1 = new Product();
		pro_test1.setName("test_1");
		pro_test1.setBrand("b1");
		pro_test1.setDescription("This is product_test 1");
		pro_test1.setUnitPrice(500);
		pro_test1.setActive(true);
		pro_test1.setCategoryId(1);
		pro_test1.setSupplierId(3);
		
		//add product
		assertEquals("Somethiing went wrong when adding product.",true,productDAO.add(pro_test1));
		
		//update
		pro_test1 = productDAO.get(2);
		pro_test1.setName("GALAXY 8");
		
		assertEquals("Something went wrong when updating.", true, productDAO.update(pro_test1));
		
		assertEquals("Something went wrong when deleting.", true, productDAO.delete(pro_test1));
		
		assertEquals("Something went wrong when fetching list.", 10, productDAO.list().size());
		
		
	}
//	
//	@Test 
//	public void testListActiveProdects(){
//		assertEquals("Something wrong when fetching active products", 9,productDAO.listActiveProducts().size());
//	}
//	
//	
//	@Test
//	public void testForGetProductByCategory(){
//		assertEquals("Something wrong when fetching active products", 2, productDAO.listActiveProductByCategory(3).size());
//		assertEquals("Something wrong when fetching active products", 7, productDAO.listActiveProductByCategory(1).size());
//	}
	
//	@Test
//	public void testForGetLatestActiveProduct(){
//		assertEquals("Something wrong when fetching latest active products", 3, productDAO.getLatestActiveProducts(3).size());
//	}

}
