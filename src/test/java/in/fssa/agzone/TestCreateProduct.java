package in.fssa.agzone;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import in.fssa.agzone.model.Product;
import in.fssa.agzone.service.ProductService;
import in.fssa.agzone.service.UserService;

public class TestCreateProduct {
	
	ProductService productService = new ProductService();
	
	
	//create a product
	
//	public void testCreateProductWithValidData() {
//		
//		ProductService productService = new ProductService();
//		
//		Product newproduct = new product();
//
//		int min = 1; 
//		int max = 10000; 
//		int numberOfRandomNumbers = 100;
//
//		Random rand = new Random();
//		int randomNumber = 0;
//		for (int i = 0; i < numberOfRandomNumbers; i++) {
//			randomNumber = rand.nextInt(max - min + 1) + min;
//
//		}
//		
//		
//		new
//
////		newproduct..setGrainName("Paddy");
////		newProduct.setVarietyName("Ponny");
////		newProduct.setQuantity("5");
////		newProduct.setPrice();
//
//		assertDoesNotThrow(() -> {
//			productService.createUser(newproduct);
//		});
//
//	}
	
	
	//create a product 
	@Test
	 public void testCreateProduct() {
	        // Define the product properties
	        String grainName = "Wheat";
	        String varietyName = "Whole Grain";
	        float quantity = 50f;

	        // Create a product instance
	        Product product = new Product();
	        product.setGrainName(grainName);
	        product.setVarietyName(varietyName);
	        product.setQuantity(quantity);
	        System.out.println("Product created Successfully");

	        // Verify that the product was created correctly
	        assertNotNull(product, "Product should not be null");
	        assertEquals(grainName, product.getGrainName(), "Grain Name should match");
	        assertEquals(varietyName, product.getVarietyName(), "Variety Name should match");
	        assertEquals(quantity, product.getQuantity(), "Quantity should match");
	    }
	 
	 
	 //validate data
	@Test
	 public void testCreateProductWithValidData() {
	        // Define valid data
	        String grainName = "Rice";
	        String varietyName = "Jasmine";
	        float quantity = 10;

	        // Create a product instance with valid data
	        Product product = new Product();
	        product.setGrainName(grainName);
	        product.setVarietyName(varietyName);
	        product.setQuantity(quantity);

	        // Verify that the product was created correctly
	        assertNotNull(product, "Product should not be null");
	        assertEquals(grainName, product.getGrainName(), "Grain Name should match");
	        assertEquals(varietyName, product.getVarietyName(), "Variety Name should match");
	        assertEquals(quantity, product.getQuantity(), "Quantity should match");
	    }

}
