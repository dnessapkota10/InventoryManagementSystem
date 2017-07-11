/**
 * 
 */
package com.inventory.domaintest;

import java.util.ArrayList;
import java.util.List;

import com.inventory.domain.Product;
import com.inventory.service.ProductManagerService;
import com.inventory.service.ProductManagerServiceImpl;

/**
 * @author Dinesh Sapkota
 * 10 Jul 2017
 */
import junit.framework.TestCase;

public class ProductTests extends TestCase {

	private ProductManagerServiceImpl productManagerServiceImpl;
	private List<Product> products;

	private static int PRODUCT_COUNT = 2;

	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair";

	private static String TABLE_DESCRIPTION = "Table";
	private static Double TABLE_PRICE = new Double(150.10);

	protected void setUp() throws Exception {
		productManagerServiceImpl = new ProductManagerServiceImpl();
		products = new ArrayList<Product>();

		// stub up a list of products
		Product product = new Product();
		product.setDescription("Chair");
		product.setPrice(CHAIR_PRICE);
		products.add(product);

		product = new Product();
		product.setDescription("Table");
		product.setPrice(TABLE_PRICE);
		products.add(product);

		productManagerServiceImpl.setProducts(products);
	}

	public void testGetProductsWithNoProducts() {
		productManagerServiceImpl = new ProductManagerServiceImpl();
		assertNull(productManagerServiceImpl.getProducts());
	}

	public void testGetProducts() {
		List<Product> products = productManagerServiceImpl.getProducts();
		assertNotNull(products);
		assertEquals(PRODUCT_COUNT, productManagerServiceImpl.getProducts().size());

		Product product = products.get(0);
		assertEquals(CHAIR_DESCRIPTION, product.getDescription());
		assertEquals(CHAIR_PRICE, product.getPrice());

		product = products.get(1);
		assertEquals(TABLE_DESCRIPTION, product.getDescription());
		assertEquals(TABLE_PRICE, product.getPrice());
	}

}
