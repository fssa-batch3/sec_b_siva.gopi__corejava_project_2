package in.fssa.agzone;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.agzone.exception.ValidationException;
import in.fssa.agzone.service.UserService;

public class TestUser {

	UserService userService = new UserService();
	
	
	public void testFindWithValidMobileNumber() {

		assertDoesNotThrow(() -> {
			userService.getByMobileNumber(6787879878l);
		});

	}
	
	public void testFindwithInvalidMobileNumber() {

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.getByMobileNumber(-56666666l);
		});
		String expectedMessage = "Mobile Number doesn't match the Pattern";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));

	}


}
