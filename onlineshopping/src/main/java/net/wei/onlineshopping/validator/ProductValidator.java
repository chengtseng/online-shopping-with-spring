package net.wei.onlineshopping.validator;

import net.wei.shoppingbackend.dto.Product;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

	//this class is used for product class only
	@Override	
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product)target;
		
		//whether afile has been selected
		if(product.getFile() == null || 
				product.getFile().getOriginalFilename().equals("")){
			//field, error code, default message
			errors.rejectValue("file", null, "Please select an image file to upload.");
			return;
		}
		//check if file is jpg
		if(!(product.getFile().getContentType().equals("image/jpeg")||
		   product.getFile().getContentType().equals("image/png")||
		   product.getFile().getContentType().equals("image/gif"))){
			errors.rejectValue("file", null, "Please select file in jpeg,png or gif.");
			return;
		}		
	}
}
