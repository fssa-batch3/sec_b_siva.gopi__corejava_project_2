package in.fssa.agzone.service;


import java.util.List;

import in.fssa.agzone.dao.ProductDAO;
import in.fssa.agzone.exception.PersistanceException;
import in.fssa.agzone.exception.ServiceException;
import in.fssa.agzone.exception.ValidationException;
import in.fssa.agzone.model.Product;
import in.fssa.agzone.validator.ProductValidator;



public class ProductService {

	ProductDAO productDAO = new ProductDAO();
	//PriceService priceService = new PriceService();
		
	// create a product
	public void createProduct(Product newProduct) throws ValidationException, ServiceException {

		int productId = 0;
		try {
			ProductValidator.validateCreate(newProduct);
			productId = productDAO.create(newProduct);
		} catch (PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}

//		try {
//			priceService.createPrice(newProduct.getPrice(), productId);
//		} catch (ServiceException e) {
//			System.out.println("Failed to create product price");
//			removeRow(productId);
//
//		} catch (ValidationException e) {
//			removeRow(productId);
//			throw new ValidationException(e.getMessage());
//
//		}

	}
	
	
	//Update a product
	public void updateProduct(Product newProduct, int id) throws ValidationException, ServiceException {

		try {
			ProductValidator.validateUpdate(newProduct, id);
		//	priceService.updatePrice(newProduct.getPrice(), id);
			productDAO.update(newProduct, id);

		} catch (PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}

	}
	
	// list all prduct
	
	public List<Product> getAllProducts() throws ServiceException {

		try {
			return productDAO.findAll();
		} catch (PersistanceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}

	}
	
	
	//delete a product
	
	public void deleteProduct(int productId) throws ValidationException, ServiceException {
		try {

			ProductValidator.validateProductId(productId);
			productDAO.delete(productId);

		} catch (PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	
	// find by id
	
	public Product findById(int newId) throws ValidationException, ServiceException {

		try {
			ProductValidator.validateProductId(newId);
			return productDAO.findById(newId);
		} catch (PersistanceException e) {
			throw new ServiceException(e.getMessage());
		}

	}


}
	
