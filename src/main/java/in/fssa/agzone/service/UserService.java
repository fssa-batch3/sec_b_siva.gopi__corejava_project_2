package in.fssa.agzone.service;

import java.util.Iterator;
import java.util.List;

import in.fssa.agzone.dao.UserDAO;
import in.fssa.agzone.exception.PersistanceException;
import in.fssa.agzone.exception.ServiceException;
import in.fssa.agzone.exception.ValidationException;
import in.fssa.agzone.model.User;
import in.fssa.agzone.validator.UserValidator;


public class UserService {
	UserDAO userDAO= new UserDAO();
	
	public void createUser(User user) throws ValidationException, ServiceException {
		try {
			UserValidator.validate(user);
			userDAO.create(user);
		} 
		catch (PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}

	}
	
	
	
	
	public void updateUser(long MobileNumber, User newUser) throws ValidationException, ServiceException {

		try {
			UserValidator.validateUpdate(MobileNumber, newUser);
			userDAO.update(MobileNumber, newUser);
		} catch (PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}

	}
	
	
	
	public User getByMobileNumber(long MobileNumber) throws ValidationException, ServiceException {

		try {
			UserValidator.validateMobileNumber(MobileNumber, "Mobile Number");
			return userDAO.findByMobileNumber(MobileNumber);

		} catch (PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}

	}



}