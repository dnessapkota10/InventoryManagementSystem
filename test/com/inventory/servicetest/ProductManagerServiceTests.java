/**
 * 
 */
package com.inventory.servicetest;

import java.util.ArrayList;
import java.util.List;

import com.inventory.domain.Product;
import com.inventory.service.ProductManagerServiceImpl;

/**
 * @author Dinesh Sapkota
 * 10 Jul 2017
 */
import junit.framework.TestCase;

public class ProductManagerServiceTests extends TestCase {

	private ProductManagerServiceImpl productManagerServiceImpl;

	private List<Product> products;

	private static int PRODUCT_COUNT = 2;

	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair";

	private static String TABLE_DESCRIPTION = "Table";
	private static Double TABLE_PRICE = new Double(150.10);

	private static int POSITIVE_PRICE_INCREASE = 10;

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

	public void testIncreasePriceWithNullListOfProducts() {
		try {
			productManagerServiceImpl = new ProductManagerServiceImpl();
			productManagerServiceImpl.increasePrice(POSITIVE_PRICE_INCREASE);
		} catch (NullPointerException ex) {
			fail("Products list is null.");
		}
	}

	public void testIncreasePriceWithEmptyListOfProducts() {
		try {
			productManagerServiceImpl = new ProductManagerServiceImpl();
			productManagerServiceImpl.setProducts(new ArrayList<Product>());
			productManagerServiceImpl.increasePrice(POSITIVE_PRICE_INCREASE);
		} catch (Exception ex) {
			fail("Products list is empty.");
		}
	}

	public void testIncreasePriceWithPositivePercentage() {
		productManagerServiceImpl.increasePrice(POSITIVE_PRICE_INCREASE);
		double expectedChairPriceWithIncrease = 22.55;
		double expectedTablePriceWithIncrease = 165.11;

		List<Product> products = productManagerServiceImpl.getProducts();
		Product product = products.get(0);
		assertEquals(expectedChairPriceWithIncrease, product.getPrice());

		product = products.get(1);
		assertEquals(expectedTablePriceWithIncrease, product.getPrice());
	}

}