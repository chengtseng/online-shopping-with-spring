package net.wei.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final String absolutePath = "E:\\workspace\\Projects\\online-shopping-with-spring\\onlineshopping\\src\\main\\webapp\\images\\";
	private static String realPath = "";
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		realPath = request.getSession().getServletContext().getRealPath("/assets/images/");
		System.out.print(realPath);
		//to make sure all the directory exists. please create the directories
		if(!new File(absolutePath).exists()){
			new File(absolutePath).mkdirs(); 
		}
		
		if(!new File(realPath).exists()){
			new File(realPath).mkdirs(); 
		}
		
		try{
			//server uplead
			file.transferTo(new File(realPath + code + ".jpg"));
			
			//update to project
			file.transferTo(new File(absolutePath + code + ".jpg"));			
		}catch(IOException ex){
			
		}
	}

}
