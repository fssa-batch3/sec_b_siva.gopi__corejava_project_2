package in.fssa.agzone.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.fssa.agzone.dao.UserDAO;
import in.fssa.agzone.exception.PersistanceException;
import in.fssa.agzone.exception.ValidationException;
import in.fssa.agzone.model.User;
import in.fssa.agzone.util.StringUtil;

public class UserValidator {

	
	public static void validate(User newUser) throws ValidationException {

		if (newUser == null) {
			throw new ValidationException("Invalid User Input");
		}

		StringUtil.rejectIfInvalidString(newUser.getName(), "Name");
		validateMobileNumber(newUser.getMobileNumber(), "Mobile Number");

//		if (newUser.getDistrict() != null) {
//			validateDistrict(newUser.getDistrict(), "District");
//		}
//		if (newUser.getAddress() != null) {
//			validateAddress(newUser.getAddress(), "Address");
//		}

		UserDAO userDAO = new UserDAO();
		try {
			User existingCheckUser = userDAO.findByMobileNumber(newUser.getMobileNumber());

			if (existingCheckUser != null) {
				throw new ValidationException("User Already Exists");
			}
		} catch (PersistanceException e) {

			throw new ValidationException(e.getMessage());
		}

	}

	
		public static void validateMobileNumber(long MobileNumber, String inputName) throws ValidationException {
			String regexPattern = "^[6-9]\\d{9}$";

			String number = Long.toString(MobileNumber);
			Pattern pattern = Pattern.compile(regexPattern);
			Matcher matcher = pattern.matcher(number);
			if (!matcher.matches()) {
				throw new ValidationException(inputName.concat(" doesn't match the Pattern"));
			}
		}
		


	public static void validateUpdate(long mobileNumber, User newUser) throws ValidationException {
		
		if (newUser == null) {
			throw new ValidationException("Invalid User Input");
		}

		validateMobileNumber(mobileNumber, "Mobile Number");
		validateMobileNumber(newUser.getMobileNumber(), "New Mobile Number");
		StringUtil.rejectIfInvalidString(newUser.getName(), "Name");

	
		UserDAO userDAO = new UserDAO();
		try {

			User CheckExistOrNot = userDAO.findByMobileNumber(mobileNumber);

			if (CheckExistOrNot == null) {
				throw new ValidationException("User Not Exists With this Number");
			}
			User AlreadyExistsOrNot = null;

			if (mobileNumber != newUser.getMobileNumber()) {
				AlreadyExistsOrNot = userDAO.findByMobileNumber(newUser.getMobileNumber());

			}

			if (AlreadyExistsOrNot != null) {
				throw new ValidationException("User Already Exists With this New Number");
			}

		} catch (PersistanceException e) {

			throw new ValidationException(e.getMessage());
		}

	}
	
	}
		
	


