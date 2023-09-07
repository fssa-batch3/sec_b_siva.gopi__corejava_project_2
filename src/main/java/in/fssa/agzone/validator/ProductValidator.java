package in.fssa.agzone.validator;

import in.fssa.agzone.dao.ProductDAO;
import in.fssa.agzone.exception.PersistanceException;
import in.fssa.agzone.exception.ValidationException;
import in.fssa.agzone.model.Product;
import in.fssa.agzone.util.StringUtil;

public class ProductValidator {
	
	// create validate
	public static void validateCreate(Product newProduct) throws ValidationException {

		if (newProduct == null) {
			throw new ValidationException("Invalid Product Input");
		}

		StringUtil.rejectIfInvalidString(newProduct.getGrainName(), "Grain Name");

		if (newProduct.getVarietyName() != null) {
			StringUtil.rejectIfInvalidString(newProduct.getVarietyName(), "Variety Name");
		}

		if (newProduct.getQuantity() < 1) {
			throw new ValidationException("Invalid Product Quantity");
		}

	

	

	}
	
	
	//validate Update
	public static void validateUpdate(Product newProduct, int id) throws ValidationException {

		if (newProduct == null) {
			throw new ValidationException("Invalid Product Input");
		}

		if (id <= 0) {
			throw new ValidationException("Invalid Product ID");
		}

		StringUtil.rejectIfInvalidString(newProduct.getGrainName(), "Grain Name");

		if (newProduct.getVarietyName() != null) {
			StringUtil.rejectIfInvalidString(newProduct.getVarietyName(), "Variety Name");
		}
		if (newProduct.getQuantity() <= 0) {
			throw new ValidationException("Invalid Product Quantity");
		}

		

	}
	
	
	//validate update and delete
	public static void validateProductId(int id) throws ValidationException {
		if (id < 1) {
			throw new ValidationException("Invalid Product ID");
		}

	}

}
