/**
 * 
 */
package com.inventory.service;

import java.util.List;

import com.inventory.domain.Product;

/**
 * @author Dinesh Sapkota 10 Jul 2017
 */
public class ProductManagerServiceImpl implements ProductManagerService {
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void increasePrice(int percentage) {
		// TODO Auto-generated method stub
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
				product.setPrice(newPrice);
			}
		}
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
