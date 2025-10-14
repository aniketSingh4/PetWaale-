package org.my.petwaale.authservice.service;

import java.util.List;

import org.my.petwaale.authservice.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService 
{
	 public static List<Product> getAllProducts() 
	 {
	     // Mock data
	      return List.of(
	            new Product(1L, "Dog Food", "High quality dog food", 12.99, "/images/dog_food.jpg"),
	            new Product(2L, "Cat Toy", "Fun toy for cats", 5.99, "/images/cat_toy.jpg")
	        );
	    }
}



