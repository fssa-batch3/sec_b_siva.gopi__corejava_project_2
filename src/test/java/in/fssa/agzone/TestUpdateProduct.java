package in.fssa.agzone;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import in.fssa.agzone.model.Product;
import in.fssa.agzone.service.ProductService;
import in.fssa.agzone.service.UserService;


public class TestUpdateProduct {
	
	//Update a product 
	@Test
	 public void testUpdateProduct() {
	        // Define the product properties
	        String grainName = "Wheat";
	        String varietyName = " Grain";
	        float quantity = 50f;

	        // Create a product instance
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
	 
	 
	 //validate data
	@Test
	 public void testUpdateProductWithValidData() {
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


