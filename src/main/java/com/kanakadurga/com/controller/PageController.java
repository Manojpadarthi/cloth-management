package com.kanakadurga.com.controller;





import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kanakadurga.com.Buy;
import com.kanakadurga.com.Logger;
import com.kanakadurga.com.Message;
import com.kanakadurga.com.entity.Item;
import com.kanakadurga.com.entity.Order;
import com.kanakadurga.com.entity.Product;
import com.kanakadurga.com.entity.User;
import com.kanakadurga.com.exception.UserNotFoundException;
import com.kanakadurga.com.repository.OrderRepository;
import com.kanakadurga.com.repository.ProductRepository;
import com.kanakadurga.com.repository.UserRepository;

@Controller
public class PageController 
{
	@Autowired 
	private UserRepository repository;
	
	@Autowired 
	private ProductRepository prdRepo;
	
	@Autowired 
	private OrderRepository ordRepo;
	
	/*@PersistenceContext
	EntityManager entityManager;*/
	
    @RequestMapping("/")
	public String getHome()
	{
		return "main";
	}
    
   /* @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute  Logger logger){
    	
    	List<User>users=repository.getUser(logger.getName(),logger.getPassword());
    	
    	ModelAndView modelView = new ModelAndView();
    	Message message = new Message();
    	/*if(logger.getName().isEmpty() || logger.getPassword().isEmpty())
    	{
    		message.setMessage("User name and Password cannot be empty");
    		modelView.setViewName("home");
        	modelView.addObject("message",message);
        	return modelView;
    	}
    	if(!users.isEmpty()){
    		message.setMessage("User already exists");
    		modelView.setViewName("home");
        	modelView.addObject("message",message);
        	return modelView;
    	}
    	else{
    	repository.save(new User(logger.getName(),logger.getPassword()));
    	message.setMessage("User created. Please login");
    	modelView.setViewName("home");
    	modelView.addObject("message",message);
    	return modelView;
     }
    
    }*/
    
   @GetMapping("/login")
    public ModelAndView getLogin(){
    	
    	ModelAndView modelView = new ModelAndView();
    	Message message = new Message("Please Login");
    	modelView.addObject("logger", new Logger());
    	modelView.addObject("message",message);
    	modelView.setViewName("login");
    	return modelView;
    	
    	
    }
   @GetMapping("/register")
   public ModelAndView getRegister(){
   	
   	ModelAndView modelView = new ModelAndView();
   	modelView.addObject("logger", new Logger());
    Message message = new Message("Please register");
	modelView.addObject("message",message);
   	modelView.setViewName("register");
   	return modelView;
   	
   	
   }
   @PostMapping("/register")
   public ModelAndView registerUser(@ModelAttribute("logger") Logger logger)
   {
	 System.out.println(logger.getName());
   	  
	   ModelAndView modelView = new ModelAndView();
	   if(repository.getUser(logger.getName()).isEmpty())
	   {
		 repository.save(new User(logger.getName(),logger.getPassword()));
		 
		 Message message = new Message("Succesfully Registered.Please Login");
	    	modelView.addObject("message",message);
	   	modelView.setViewName("login");
	   	return modelView;
	   }
	   else
	   {
		   Message message = new Message("User already exists");
		   //modelView.addObject("logger", new Logger());
		   modelView.addObject("message",message);
		   modelView.setViewName("register");
		   	return modelView;
	   }
	   
	}
    
    @PostMapping("/success")
    public ModelAndView getSuccess(@ModelAttribute("logger") Logger logger){
    	System.out.println(logger.getName());
    	ModelAndView modelView = new ModelAndView();
    	List<Product> products =prdRepo.findAll();
    	modelView.addObject("products", products);
    	/*Buy buy = new Buy();
    	for(int i=1;i<=products.size();i++){
    		buy.getItems().add(new Item());
    	}
    	modelView.addObject("buy", buy);*/
    	modelView.setViewName("success");
    	
    	return modelView;
    	
    	
    }
    @PostMapping("/order")
    
    public ModelAndView getBuy(@ModelAttribute("buy") Buy buy){
    	
    	
    	ModelAndView modelView = new ModelAndView();
    	
    	List<Integer>items=buy.getItems();
    	System.out.println(items);
    	
    	Order order = new Order();
    	order.setItems(items);
    	//entityManager.persist(order);
    	ordRepo.save(order);
    	modelView.setViewName("save");
    	
    	return modelView;
    	
    	
    }
    
    
    
   /* @PostMapping("/login")
    public ModelAndView getLoginAfter(){
    	
    	ModelAndView modelView = new ModelAndView();
    	//Message message = new Message("Please Login");
    	//modelView.addObject("logger",logger);
    	modelView.setViewName("success");
    	return modelView;
    	
    	
    }*/
    
    
    
    
}
