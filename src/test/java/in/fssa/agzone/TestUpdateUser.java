package in.fssa.agzone;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

import in.fssa.agzone.exception.ValidationException;
import in.fssa.agzone.model.User;
import in.fssa.agzone.service.UserService;

public class TestUpdateUser {
	
	//Test Update User With Validate Data
	public void testUpdateUserWithValidData() {
		UserService userService = new UserService();

		User newUser = new User();

		newUser.setName("Siva");
		newUser.setMobileNumber(8270148693l);
		newUser.setDistrict("Sivaganagi");
		newUser.setTown("Manamadurai");
		newUser.setPassword("S1i2v3@A4");

		assertDoesNotThrow(() -> {
			userService.updateUser(8270148693l , newUser);
		});

	}
	
	
	//Test Update User With Invalidate Data
	@Test
	public void testUpdateUserWithInvalidData() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.updateUser(0,null);
		});
		String expectedMessage = "Invalid User Input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	//Test Update User With Name Null
	@Test
	public void testUpdateUserWithNameNull() {
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

			userService.updateUser(6787878787l,newUser);

		});
		String expectedMessage = "Name cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	//Test Update User With Name Empty
	@Test
	public void testUpdateUserWithNameEmpty() {
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

			userService.updateUser(6787878787l,newUser);

		});
		String expectedMessage = "Name cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	//Test Update User With Invalid Name Pattern
	
	public void testUpdateUserWithInvalidNamePattern() {
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


		Exception exception = assertThrows(ValidationException.class, () -> {

			userService.updateUser(6787878787l,newUser);

		});
		String expectedMessage = "doesn't match the Pattern";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	//Test Update User with District Null
	public void testUpdateUserWithDistrictNull() {
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

		Exception exception = assertThrows(ValidationException.class, () -> {

			userService.updateUser(6787878787l,newUser);

		});
		String expectedMessage = "District cannot be Null ";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	
	//Test Update User with District Empty
		public void testUpdateUserWithDistrictEmpty() {
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
			newUser.setDistrict("");
			newUser.setTown("Manamadurai");
			newUser.setPassword("S1i2v3@A4");

			Exception exception = assertThrows(ValidationException.class, () -> {

				userService.updateUser(6787878787l,newUser);

			});
			String expectedMessage = "District cannot be empty ";
			String actualMessage = exception.getMessage();
			assertTrue(expectedMessage.equals(actualMessage));
		}
		
		
		//Test Update User with Town Null
		public void testUpdateUserWithTownNull() {
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

				userService.updateUser(6787878787l,newUser);

			});
			String expectedMessage = "Town cannot be Null ";
			String actualMessage = exception.getMessage();
			assertTrue(expectedMessage.equals(actualMessage));
		}
		
		
		//Test Update User With Town Empty
				public void testUpdateUserWithTownEmpty() {
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
				
				
				//Test Update User With District And Town Null
				public void testUpdateUserWithDistrictAndTownNull() {
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
