package in.fssa.agzone.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.fssa.agzone.exception.PersistanceException;
import in.fssa.agzone.model.Product;
import in.fssa.agzone.util.ConnectionUtil;



public class ProductDAO  {

	
	//create a product
	public int create(Product newProduct) throws PersistanceException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int productId = 0;

		try {
			String productquery = "INSERT INTO products (grain_name,variety_name,quantity,price) VALUES (?, ?, ?, ?);";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(productquery, java.sql.Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, newProduct.getGrainName());
			ps.setString(2, newProduct.getVarietyName());
			ps.setFloat(3, newProduct.getQuantity());
		//	ps.setPrice(4, newProduct.getPrice());
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				productId = rs.getInt(1);
			}

			System.out.println("Product Successfully Created :)");

		} catch (SQLException e) {
			if (e.getMessage().contains("Duplicate entry")) {
				throw new PersistanceException("Duplicate constraint");
			} else {
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}

		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return productId;
	}
	
	
		//update a product
		public void update(Product newProduct, int id) throws PersistanceException {
			Connection con = null;
			PreparedStatement ps = null;
	
			try {
				String query = "UPDATE products SET quantity = ? WHERE id = ?";
				con = ConnectionUtil.getConnection();
				ps = con.prepareStatement(query);
				ps.setFloat(1, newProduct.getQuantity());
				ps.setInt(2, id);
				ps.executeUpdate();
	
				System.out.println("Product Successfully Updated :)");
	
			} catch (SQLException e) {
				throw new PersistanceException(e.getMessage());
			} finally {
				ConnectionUtil.close(con, ps);
			}
	
		}


		
		//list all product
		public List<Product> findAll() throws PersistanceException {

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			List<Product> productList = new ArrayList<Product>();
			try {
				String query = "SELECT id , grain_name ,variety_name , quantity, FROM products WHERE is_active = 1";
				con = ConnectionUtil.getConnection();
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();

				while (rs.next()) {
					Product newProduct = new Product();
					newProduct.setGrainName(rs.getString("grain_name"));
					newProduct.setVarietyName(rs.getString("variety_name"));
					newProduct.setQuantity(rs.getFloat("quantity"));
					newProduct.setId(rs.getInt("id"));
					productList.add(newProduct);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new PersistanceException(e.getMessage());
			} finally {
				ConnectionUtil.close(con, ps, rs);
			}
			return productList;

		}
		
		
		//delete a product
		public void delete(int newId) throws PersistanceException {
			Connection con = null;
			PreparedStatement ps = null;

			try {
				String query = "UPDATE products SET is_active = false WHERE id = ? AND is_active = true";
				con = ConnectionUtil.getConnection();
				ps = con.prepareStatement(query);

				ps.setInt(1, newId);

				ps.executeUpdate();

				System.out.println("Product Successfully Deleted :)");

			} catch (SQLException e) {
				throw new PersistanceException(e.getMessage());
			} finally {
				ConnectionUtil.close(con, ps);
			}

		}
		
		
		
		//find by id
	public Product findById(int productId) throws PersistanceException {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			Product product = null;

			try {
				String query = "SELECT grain_name ,variety_name , quantity,id FROM products  WHERE id = ? ";
				con = ConnectionUtil.getConnection();
				ps = con.prepareStatement(query);
				ps.setInt(1, productId);
				rs = ps.executeQuery();

				if (rs.next()) {
					product = new Product();
					Product newProduct = new Product();
					newProduct.setGrainName(rs.getString("grain_name"));
					newProduct.setVarietyName(rs.getString("variety_name"));
					newProduct.setQuantity(rs.getFloat("variety_name"));
					newProduct.setId(rs.getInt("id"));
				}

			} catch (SQLException e) {

				throw new PersistanceException(e.getMessage());
			} finally {
				ConnectionUtil.close(con, ps, rs);
			}

			return product;
		}


	
	}
	


	
