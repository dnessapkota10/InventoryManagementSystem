//THIS IS UNIT TEST CLASS
package com.inventory.controllertest;

import org.springframework.ui.ExtendedModelMap;

import com.inventory.controller.ProductController;

import junit.framework.TestCase;

public class ProductControllerTest extends TestCase {

	public void testHandleRequestView() throws Exception {
		ProductController controller = new ProductController();

		// ExtendedModelMap() is used to create Model object, like in controller
		String viewName = controller.showHello(new ExtendedModelMap());
		assertEquals("product", viewName);
	}
}
