package com.kanakadurga.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kanakadurga.com.entity.Product;
import com.kanakadurga.com.entity.User;
import com.kanakadurga.com.repository.ProductService;
import com.kanakadurga.com.repository.UserRepository;

@SpringBootApplication
public class ClothManagementApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context=SpringApplication.run(ClothManagementApplication.class, args);
	
		/*UserRepository rep=context.getBean(UserRepository.class);
		rep.save(new User("manoj","Hyderabad@143"));*/
	   /*ProductService service= (ProductService) context.getBean("productService");
	    
	   Product product = new Product();
	   product.setName("Shirts");
	   product.setNumberOfItems(4);
	   
	   service.saveProduct(product);*/
	   
	
	}

}
