/**
 * 
 */
package com.inventory.service;

import java.util.List;

import com.inventory.domain.Product;

/**
 * @author Dinesh Sapkota
 * 10 Jul 2017
 */
public interface ProductManagerService{	

	    public void increasePrice(int percentage);	    
	    public List<Product> getProducts();
	    	
}
