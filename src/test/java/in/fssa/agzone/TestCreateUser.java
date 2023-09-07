package in.fssa.agzone;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

import in.fssa.agzone.exception.ValidationException;
import in.fssa.agzone.model.User;
import in.fssa.agzone.service.UserService;


public class TestCreateUser {
	
	//Create user With Validate Data
	@Test
	public void testCreateUserWithValidData() {
		UserService userService = new UserService();

		User newUser = new User();

		long min = 6000000001l; // Minimum value for the random number
		long max = 9999999999l; // Maximum value for the random number
		int numberOfRandomNumbers = 100; // Set the number of random numbers you want to generate

		Random rand = new Random();
		long randomNumber = 0;
		for (int i = 0; i < numberOfRandomNumbers; i++) {
			randomNumber = rand.nextLong(max - min + 1) + min;

		}

		newUser.setName("Siva");
		newUser.setMobileNumber(randomNumber);
		newUser.setDistrict("Sivagangai");
		newUser.setTown("Manamadurai");
		newUser.setPassword("S1i2v3@A4");

		assertDoesNotThrow(() -> {
			userService.createUser(newUser);
		});

	}
	
	
	//Create with Invalidate Data
	@Test
	public void testCreateUserWithInvalidData() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.createUser(null);
		});
		String expectedMessage = "Invalid User Input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	//Test Create With Invalid Mobile Number
	@Test
	public void testCreateUserWithInvalidPhoneNumber() {
		UserService userService = new UserService();

		User newUser = new User();


		newUser.setName("Siva");
		newUser.setMobileNumber(0);
		newUser.setDistrict("Sivagangai");
		newUser.setTown("Manamadurai");
		newUser.setPassword("S1i2v3@A4");

		Exception exception = assertThrows(ValidationException.class, () -> {

			userService.createUser(newUser);

		});
		String expectedMessage = "Mobile Number doesn't match the Pattern";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	//Test Create with Invalid Mobile Number Pattern
	@Test
	public void testCreateUserWithInvalidMobileNumberPattern() {
		UserService userService = new UserService();

		User newUser = new User();


		newUser.setName("Siva");
		newUser.setMobileNumber(1234567890l);
		newUser.setDistrict("Sivagangai");
		newUser.setTown("Manamadurai");
		newUser.setPassword("S1i2v3@A4");

		Exception exception = assertThrows(ValidationException.class, () -> {

			userService.createUser(newUser);

		});
		String expectedMessage = "Mobile Number doesn't match the Pattern";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	//Test Create User With Existing User Details
	@Test
	public void testCreateUserWithExistingUserDetails() {
		UserService userService = new UserService();

		User newUser = new User();


		newUser.setName("Siva");
		newUser.setMobileNumber(8270148693l);
		newUser.setDistrict("Sivagangai");
		newUser.setTown("Manamadurai");
		newUser.setPassword("S1i2v3@A4");

		Exception exception = assertThrows(ValidationException.class, () -> {

			userService.createUser(newUser);

		});
		String expectedMessage = "User Already Exists";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	//Test Create User With Name Null
	@Test
	public void testCreateUserWithNameNull() {
		UserService userService = new UserService();

		User newUser = new User();


		long min = 6000000001l; // Minimum value for the random number
		long max = 9999999999l; // Maximum value for the random number
		int numberOfRandomNumbers = 100; // Set the number of random numbers you want to generate

		Random rand = new Random();
		long randomNumber = 0;
		for (int i = 0; i < numberOfRandomNumbers; i++) {
			randomNumber = rand.nextLong(max - min + 1) + min;

		}

		newUser.setName(null);
		newUser.setMobileNumber(randomNumber);
		newUser.setDistrict("Sivagangai");
		newUser.setTown("Manamadurai");
		newUser.setPassword("S1i2v3@A4");

		Exception exception = assertThrows(ValidationException.class, () -> {

			userService.createUser(newUser);

		});
		String expectedMessage = "Name cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	//Test Create User With Name Empty
	@Test
	public void testCreateUserWithNameEmpty() {
		UserService userService = new UserService();

		User newUser = new User();


		long min = 6000000001l; // Minimum value for the random number
		long max = 9999999999l; // Maximum value for the random number
		int numberOfRandomNumbers = 100; // Set the number of random numbers you want to generate

		Random rand = new Random();
		long randomNumber = 0;
		for (int i = 0; i < numberOfRandomNumbers; i++) {
			randomNumber = rand.nextLong(max - min + 1) + min;

		}

		newUser.setName("");
		newUser.setMobileNumber(randomNumber);
		newUser.setDistrict("Sivagangai");
		newUser.setTown("Manamadurai");
		newUser.setPassword("S1i2v3@A4");

		Exception exception = assertThrows(ValidationException.class, () -> {

			userService.createUser(newUser);

		});
		String expectedMessage = "Name cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	//Test Create User With Name Invalid Pattern
	@Test
	public void testCreateUserWithInvalidNamePattern() {
		UserService userService = new UserService();

		User newUser = new User();


		long min = 6000000001l; // Minimum value for the random number
		long max = 9999999999l; // Maximum value for the random number
		int numberOfRandomNumbers = 100; // Set the number of random numbers you want to generate

		Random rand = new Random();
		long randomNumber = 0;
		for (int i = 0; i < numberOfRandomNumbers; i++) {
			randomNumber = rand.nextLong(max - min + 1) + min;

		}

		newUser.setName("S67575iva");
		newUser.setMobileNumber(randomNumber);
		newUser.setDistrict("Sivagangai");
		newUser.setTown("Manamadurai");
		newUser.setPassword("S1i2v3@A4");

		Exception exception = assertThrows(ValidationException.class, () -> {

			userService.createUser(newUser);

		});
		String expectedMessage = "Name doesn't match the Pattern";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	//Test Create User With District Null
		@Test
		public void testCreateUserWithDistrictNull() {
			UserService userService = new UserService();

			User newUser = new User();


			long min = 6000000001l; // Minimum value for the random number
			long max = 9999999999l; // Maximum value for the random number
			int numberOfRandomNumbers = 100; // Set the number of random numbers you want to generate

			Random rand = new Random();
			long randomNumber = 0;
			for (int i = 0; i < numberOfRandomNumbers; i++) {
				randomNumber = rand.nextLong(max - min + 1) + min;

			}

			newUser.setName("Siva");
			newUser.setMobileNumber(randomNumber);
			newUser.setDistrict(null);
			newUser.setTown("Manamadurai");
			newUser.setPassword("S1i2v3@A4");

			assertDoesNotThrow(() -> {
				userService.createUser(newUser);
			});
		}
		
		
		//Test Create User With District Empty
		
		public void testCreateUserWithDistrictEmpty() {
			UserService userService = new UserService();

			User newUser = new User();


			long min = 6000000001l; // Minimum value for the random number
			long max = 9999999999l; // Maximum value for the random number
			int numberOfRandomNumbers = 100; // Set the number of random numbers you want to generate

			Random rand = new Random();
			long randomNumber = 0;
			for (int i = 0; i < numberOfRandomNumbers; i++) {
				randomNumber = rand.nextLong(max - min + 1) + min;

			}

			newUser.setName("");
			newUser.setMobileNumber(randomNumber);
			newUser.setDistrict("");
			newUser.setTown("Manamadurai");
			newUser.setPassword("S1i2v3@A4");

			Exception exception = assertThrows(ValidationException.class, () -> {

				userService.createUser(newUser);

			});
			String expectedMessage = "District cannot be empty";
			String actualMessage = exception.getMessage();
			assertTrue(expectedMessage.equals(actualMessage));
		}
		
		
		//Test Create User With Town Null
		public void testCreateUserWithTownNull() {
			UserService userService = new UserService();

			User newUser = new User();


			long min = 6000000001l; // Minimum value for the random number
			long max = 9999999999l; // Maximum value for the random number
			int numberOfRandomNumbers = 100; // Set the number of random numbers you want to generate

			Random rand = new Random();
			long randomNumber = 0;
			for (int i = 0; i < numberOfRandomNumbers; i++) {
				randomNumber = rand.nextLong(max - min + 1) + min;

			}

			newUser.setName("Siva");
			newUser.setMobileNumber(randomNumber);
			newUser.setDistrict("Sivagangai");
			newUser.setTown(null);
			newUser.setPassword("S1i2v3@A4");

			Exception exception = assertThrows(ValidationException.class, () -> {

				userService.createUser(newUser);

			});
			String expectedMessage = "Town cannot be Null";
			String actualMessage = exception.getMessage();
			assertTrue(expectedMessage.equals(actualMessage));
		}
		
		
		//Test Create User With Town Empty
		
		public void testCreateUserWithTownEmpty() {
			UserService userService = new UserService();

			User newUser = new User();


			long min = 6000000001l; // Minimum value for the random number
			long max = 9999999999l; // Maximum value for the random number
			int numberOfRandomNumbers = 100; // Set the number of random numbers you want to generate

			Random rand = new Random();
			long randomNumber = 0;
			for (int i = 0; i < numberOfRandomNumbers; i++) {
				randomNumber = rand.nextLong(max - min + 1) + min;

			}

			newUser.setName("Siva");
			newUser.setMobileNumber(randomNumber);
			newUser.setDistrict("Sivagangai");
			newUser.setTown("");
			newUser.setPassword("S1i2v3@A4");

			Exception exception = assertThrows(ValidationException.class, () -> {

				userService.createUser(newUser);

			});
			String expectedMessage = "Town cannot be empty";
			String actualMessage = exception.getMessage();
			assertTrue(expectedMessage.equals(actualMessage));
		}
		
		
		//Test Create User With District And Town Null
		@Test
		public void testCreateUserWithDistrictAndTownNull() {
			UserService userService = new UserService();

			User newUser = new User();

			long min = 6000000001l; // Minimum value for the random number
			long max = 9999999999l; // Maximum value for the random number
			int numberOfRandomNumbers = 100; // Set the number of random numbers you want to generate

			Random rand = new Random();
			long randomNumber = 0;
			for (int i = 0; i < numberOfRandomNumbers; i++) {
				randomNumber = rand.nextLong(max - min + 1) + min;

			}

			newUser.setName("Siva");
			newUser.setMobileNumber(randomNumber);
			newUser.setDistrict(null);
			newUser.setTown(null);
			newUser.setPassword("S1i2v3@A4");

			assertDoesNotThrow(() -> {
				userService.createUser(newUser);
			});

		}
	
}
